package com.aixtrade.Streams.QuoteStreams;

import lombok.Data;

@Data
public class QuoteRequestStreamData {

    private Long quoteRequestId;
    private String symbol;
    private Long quantity;
    private String channel;
    private String direction;
    private String trader;
    private String status;
    private Double spotPrice;
    private String expiresAt;
    private LatestQuoteData latestQuote;
    private Long price;
}
