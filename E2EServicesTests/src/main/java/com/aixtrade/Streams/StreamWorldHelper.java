package com.aixtrade.Streams;

import com.aixtrade.Streams.OrderStreams.OrderStreamResponse;
import com.aixtrade.Streams.QuoteStreams.QuoteStreamResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.aixtrade.Streams.OrderStreams.OrderStreamResponse.ORDER_BY_ENTERED_AT_MILLIS;
import static java.lang.String.format;


@Slf4j
public class StreamWorldHelper {

    private static final long WAIT_FOR_STREAM_UPDATE_IN_SECONDS = 30L;
    private static final long WAIT_FOR_OPEN_ORDER_STREAM_UPDATE_IN_SECONDS = 10L;
    private static CountDownLatch streamCountDownLatch;
    private static CountDownLatch openItemStreamCountDownLatch;
    private static CountDownLatch cancelledItemStreamCountDownLatch;
    private static Integer streamCountDownLatchOriginalCount;
    private static final Multimap<String, OrderStreamResponse> orderStreamUpdates = Multimaps.synchronizedMultimap(HashMultimap.create());
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Gson gson = new Gson();
    private static final Multimap<String, QuoteStreamResponse> quoteStreamUpdates = Multimaps.synchronizedMultimap(HashMultimap.create());


    public void initCountDownLatch(
            List<StreamUpdateCount> streamUpdateCounts,
            String name,
            Consumer<StreamUpdateCount> streamUpdateCountConsumer) {

        streamUpdateCounts
                .stream()
                .filter(streamUpdateCount ->
                        name.equals(streamUpdateCount.getName()))
                .findFirst()
                .ifPresent(streamUpdateCountConsumer);
    }

    public void initStreamCountDownLatch(Integer count) {
        streamCountDownLatchOriginalCount = count;
        streamCountDownLatch = new CountDownLatch(streamCountDownLatchOriginalCount);
    }

    public void awaitStreamCountDownLatch() throws InterruptedException {
        streamCountDownLatch.await(WAIT_FOR_STREAM_UPDATE_IN_SECONDS, TimeUnit.SECONDS);
    }

    public static void initOpenOrderStreamCountDownLatch(Integer count) {
        openItemStreamCountDownLatch = new CountDownLatch(count);
    }

    public void initCancelledOrderStreamCountDownLatch(Integer count) {
        cancelledItemStreamCountDownLatch = new CountDownLatch(count);
    }

    public void awaitOpenOrderStreamCountDownLatch() throws InterruptedException {
        openItemStreamCountDownLatch.await(WAIT_FOR_OPEN_ORDER_STREAM_UPDATE_IN_SECONDS, TimeUnit.SECONDS);
    }

    public void awaitCancelledOrderStreamCountDownLatch() throws InterruptedException {
        if (cancelledItemStreamCountDownLatch != null) {
            cancelledItemStreamCountDownLatch.await(WAIT_FOR_STREAM_UPDATE_IN_SECONDS, TimeUnit.SECONDS);
        }
    }

    public List<OrderStreamResponse> getOrderStreamUpdates() {
        final Collection<OrderStreamResponse> values = orderStreamUpdates.values();
        synchronized (orderStreamUpdates) {
            return values
                    .stream()
                    .peek(orderResponse -> orderResponse.setSymbol(orderResponse.getSymbol().split("_")[0]))
                    .sorted(ORDER_BY_ENTERED_AT_MILLIS)
                    .collect(Collectors.toList());
        }
    }

    public List<QuoteStreamResponse> getQuoteStreamUpdates() {
        final Collection<QuoteStreamResponse> values = quoteStreamUpdates.values();
        synchronized (quoteStreamUpdates) {
            return values
                    .stream()
                    .peek(orderResponse -> orderResponse.setSymbol(orderResponse.getSymbol().split("_")[0]))
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    public static void resetOrderUpdates() {
        orderStreamUpdates.clear();
    }

    public static void resetQuoteUpdates() {
        quoteStreamUpdates.clear();
    }

    public static void addOrderUpdates(Map<String, Object> data) throws JsonProcessingException {

        final OrderStreamResponse streamUpdate = convertToObject(objectMapper.writeValueAsString(data), OrderStreamResponse.class);

        System.out.println(format("adding order update: %s", streamUpdate));

        final String symbol = streamUpdate.getSymbol();
        final Collection<OrderStreamResponse> orderStreamResponses = orderStreamUpdates.get(symbol);

        synchronized (orderStreamUpdates) {

            if (orderStreamResponses.isEmpty() || !orderInList(orderStreamResponses, streamUpdate)) {
                orderStreamUpdates.put(symbol, streamUpdate);
                log.info("QuoteStreamResponse ({}): {}", (streamCountDownLatchOriginalCount - streamCountDownLatch.getCount()), streamUpdate);
                streamCountDownLatch.countDown();
                if ("Open".equals(streamUpdate.getOrderStatus())) {
                    if (openItemStreamCountDownLatch != null) {
                        openItemStreamCountDownLatch.countDown();
                    }
                } else if ("Canceled".equals(streamUpdate.getOrderStatus())) {
                    if (cancelledItemStreamCountDownLatch != null) {
                        cancelledItemStreamCountDownLatch.countDown();
                    }
                }
            }
        }
    }

    public static void addQuoteUpdates(Map<String, Object> data) throws JsonProcessingException {

        final QuoteStreamResponse quoteStreamUpdate = convertToObject(objectMapper.writeValueAsString(data), QuoteStreamResponse.class);

        System.out.println(format("adding quote update: %s", quoteStreamUpdate));

        final String symbol = quoteStreamUpdate.getSymbol();
        final Collection<QuoteStreamResponse> quoteStreamResponses = quoteStreamUpdates.get(symbol);

        synchronized (quoteStreamUpdates) {

            if (quoteStreamResponses.isEmpty() || !listInOrder(quoteStreamResponses, quoteStreamUpdate)) {
                quoteStreamUpdates.put(symbol, quoteStreamUpdate);
                log.info("QuoteStreamResponse ({}): {}", (streamCountDownLatchOriginalCount - streamCountDownLatch.getCount()), quoteStreamUpdate);
                streamCountDownLatch.countDown();
                if ("Open".equals(quoteStreamUpdate.getStatus())) {
                    if (openItemStreamCountDownLatch != null) {
                        openItemStreamCountDownLatch.countDown();
                    }
                } else if ("Canceled".equals(quoteStreamUpdate.getStatus())) {
                    if (cancelledItemStreamCountDownLatch != null) {
                        cancelledItemStreamCountDownLatch.countDown();
                    }
                }
            }
        }
    }

    public static String convertToString(Object object) {
        return gson.toJson(object);
    }

    private static <T> T convertToObject(String body, Class<T> clazz) {
        return gson.fromJson(body, clazz);
    }

    private static boolean orderInList(Collection<OrderStreamResponse> actualStreamResponses, OrderStreamResponse expectedStreamResponse) {
        return
                actualStreamResponses
                        .stream()
                        .anyMatch(actualStreamResponse -> ordersMatch(actualStreamResponse, expectedStreamResponse));
    }

    private static boolean listInOrder(Collection<QuoteStreamResponse> actualQuoteStreamResponses, QuoteStreamResponse expectedStreamResponse) {
        return
                actualQuoteStreamResponses
                        .stream()
                        .anyMatch(actualQuoteStreamResponse -> quoteMatch(actualQuoteStreamResponse, expectedStreamResponse));
    }

    private static boolean ordersMatch(OrderStreamResponse actualStreamResponse, OrderStreamResponse expectedStreamResponse) {
        return actualStreamResponse.getSymbol().equals(expectedStreamResponse.getSymbol()) &&
                actualStreamResponse.getSide().equals(expectedStreamResponse.getSide()) &&
                actualStreamResponse.getQuantity().equals(expectedStreamResponse.getQuantity()) &&
                actualStreamResponse.getOriginalQuantity().equals(expectedStreamResponse.getOriginalQuantity()) &&
                actualStreamResponse.getLiveQuantity().equals(expectedStreamResponse.getLiveQuantity()) &&
                actualStreamResponse.getExecutionQuantity().equals(expectedStreamResponse.getExecutionQuantity()) &&
                actualStreamResponse.getTrader().equals(expectedStreamResponse.getTrader()) &&
                actualStreamResponse.getOrderType().equals(expectedStreamResponse.getOrderType()) &&
                actualStreamResponse.getOrderStatus().equals(expectedStreamResponse.getOrderStatus());
    }

    private static boolean quoteMatch(QuoteStreamResponse actualQuoteStreamResponse, QuoteStreamResponse expectedStreamResponse) {
        return actualQuoteStreamResponse.getSymbol().equals(expectedStreamResponse.getSymbol()) &&
                actualQuoteStreamResponse.getChannel().equals(expectedStreamResponse.getChannel()) &&
                actualQuoteStreamResponse.getQuantity().equals(expectedStreamResponse.getQuantity()) &&
                actualQuoteStreamResponse.getDirection().equals(expectedStreamResponse.getDirection()) &&
                actualQuoteStreamResponse.getStatus().equals(expectedStreamResponse.getStatus())&&
                actualQuoteStreamResponse.getLatestQuote().getBid().getPrice().equals(expectedStreamResponse.getLatestQuote().getBid().getPrice()) &&
                actualQuoteStreamResponse.getTrader().equals(expectedStreamResponse.getTrader()) &&
                actualQuoteStreamResponse.getLatestQuote().getOffer().getPrice().equals(expectedStreamResponse.getLatestQuote().getOffer().getPrice()) &&
                actualQuoteStreamResponse.getLatestQuote().getBid().getPrice().equals(expectedStreamResponse.getLatestQuote().getBid().getPrice());
    }

    private void assertJsonStringMatch(String expectedResponse, String actualResponse) throws JSONException {
        JSONAssert
                .assertEquals(
                        format("\nexpected: %s \nactual: %s", expectedResponse, actualResponse),
                        expectedResponse,
                        actualResponse,
                        JSONCompareMode.LENIENT);
    }

    public void assertJsonObjectMatch(Object expectedResponse, Object actualResponse) {
        final String expectedAsString = convertToString(expectedResponse);
        final String actualAsString = convertToString(actualResponse);
        assertJsonStringMatch(expectedAsString, actualAsString);
    }
}
