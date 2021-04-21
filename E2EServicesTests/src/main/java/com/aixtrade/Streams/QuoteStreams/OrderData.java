package com.aixtrade.Streams.QuoteStreams;

import lombok.Data;

@Data
public class OrderData {

    private String id;
    private Long price;
    private String status;
    private Boolean isQuote;
    private Long liveQuantity;
    private String userId;
}
