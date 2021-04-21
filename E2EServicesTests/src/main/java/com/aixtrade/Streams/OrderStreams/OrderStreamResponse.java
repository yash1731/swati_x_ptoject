package com.aixtrade.Streams.OrderStreams;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderStreamResponse extends OrderStreamData {

    public final static Comparator<OrderStreamResponse> ORDER_BY_ENTERED_AT_MILLIS =
            Comparator.comparing(OrderStreamResponse::getEnteredAtInMillis);

    public final static Comparator<OrderStreamResponse> ORDER_BY_UPDATED_AT_MILLIS =
            Comparator.comparing(OrderStreamResponse::getUpdatedAtInMillis);

    private String id;
}
