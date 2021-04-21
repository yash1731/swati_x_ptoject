package com.aixtrade.Streams.QuoteStreams;

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


public class QuoteStreamFactory {

    private static WebClient webClient;
    public static String quoteBaseUrl = TestData.getValue("quoteService baseUrl");
    public static String baseUri = StreamsReader.getValue("quoteRequestStream.uri");

    public static void subscribeToQuoteStreams() {

        if (webClient == null) {
            webClient =
                    WebClient
                            .builder()
                            .baseUrl(quoteBaseUrl)
                            .defaultHeader("Content-Type", APPLICATION_STREAM_JSON_VALUE)
                            .build();
        }
        subscribeToQuoteStream("quote");
    }

    private static void subscribeToQuoteStream(String streamName) {
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
                                if (body.containsKey("createdQuoteRequestEvent")) {
                                    final Map<String, Object> event = (Map<String, Object>) body.get("createdQuoteRequestEvent");

                                    if (event != null) {
                                        System.out.println(format("Quote stream received: %s", event));
                                        try {
                                            StreamWorldHelper.addQuoteUpdates(event);
                                        } catch (JsonProcessingException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            },
                            err -> {
                                System.err.println(String.format("Failed to retrieve payload from quote stream", err));
                            },
                            () -> System.out.println("Quote stream stopped"));
        });
    }
}
