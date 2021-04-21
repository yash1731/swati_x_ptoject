package com.aixtrade.Streams.OrderStreams;

import com.aixtrade.Streams.StreamWorldHelper;
import com.aixtrade.utilities.StreamsReader;
import com.aixtrade.utilities.TestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.concurrent.Executors;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;


public class StreamFactory {

    private static WebClient webClient;
    public static String orderBaseUrl = TestData.getValue("orderStream url");
    public static String baseUri = StreamsReader.getValue("orderStream.uri");

    public static void subscribeToAllStreams() {

        if (webClient == null) {
            webClient =
                    WebClient
                            .builder()
                            .baseUrl(orderBaseUrl)
                            .defaultHeader("Content-Type", APPLICATION_STREAM_JSON_VALUE)
                            .build();
        }
        subscribeToOrderbookStream("order");
    }

    private static void subscribeToOrderbookStream(String streamName) {
        System.out.println(format("establishing %s stream \n", streamName));

        Executors.newCachedThreadPool().execute(() -> {
            webClient.get()
                    .uri(baseUri)
                    .accept(MediaType.APPLICATION_STREAM_JSON)
                    .exchange()
                    .flatMapMany(response -> response.bodyToFlux(Map.class))
                    .publishOn(Schedulers.parallel())
                    .subscribe(
                            body -> {
                                if (body.containsKey("event")) {
                                    final Map<String, Object> event = (Map<String, Object>) body.get("event");

                                    final Map<String, Object> payload = (Map<String, Object>) event.get("payload");

                                    if (payload != null) {
                                        System.out.println(format("OrderData stream received: %s", payload));
                                        try {
                                            StreamWorldHelper.addOrderUpdates(payload);
                                        } catch (JsonProcessingException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            },
                            err -> {
                                System.err.println(String.format("Failed to retrieve payload from order stream", err));
                            },
                            () -> System.out.println("OrderData stream stopped"));
        });
    }
}
