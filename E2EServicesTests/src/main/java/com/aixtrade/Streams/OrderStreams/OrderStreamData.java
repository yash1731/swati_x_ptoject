package com.aixtrade.Streams.OrderStreams;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderStreamData {
    private String orderId;
    private String symbol;
    private BigDecimal price;
    private String side;
    private Long quantity;
    private Long originalQuantity;
    private Long liveQuantity;
    private Long executionQuantity;
    private Long minimumQuantity;
    private Long displayQuantity;
    private Long quantityFractionBase;
    private String trader;
    private String orderType;
    private String orderStatus;
    private String timeInForce;
    private Long expireAtInMillis;
    private String userId;
    private String broker;
    private String clearingFirm;
    private String rootReferenceNumber;
    private String referenceNumber;
    private Long enteredAtInMillis;
    private Long updatedAtInMillis;
    private Long receivedAtInMillis;
    private Boolean isQuote;
    private String quoteRequestId;
    private Long rejectQuantity;
}
