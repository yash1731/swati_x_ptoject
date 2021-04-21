package com.aixtrade.Streams.QuoteStreams;

import lombok.Data;

@Data
public class LatestQuoteData {

    private Long quoteId;
    private Object quoteResponseId;
    private Long quoteRequestId;
    private String symbol;
    private Long quantity;
    private String channel;
    private String direction;
    private String trader;
    private String status;
    private Boolean unsolicited;
    private BidData bid;
    private OfferData offer;
}
