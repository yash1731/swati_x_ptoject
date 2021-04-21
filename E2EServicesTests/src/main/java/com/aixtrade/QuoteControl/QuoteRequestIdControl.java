package com.aixtrade.QuoteControl;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class QuoteRequestIdControl {

    public static List<Integer> quoteRequestIds = new ArrayList<>();
    @Getter
    private int quoteRequestId;

    public int storeQuoteRequestId(int newQuoteRequestId) {
        quoteRequestIds.add(newQuoteRequestId);
        quoteRequestId = newQuoteRequestId;
        return newQuoteRequestId;
    }
}
