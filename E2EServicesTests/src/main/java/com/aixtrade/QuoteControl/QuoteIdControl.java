package com.aixtrade.QuoteControl;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class QuoteIdControl {

    public static List<Integer> quoteIds = new ArrayList<>();
    @Getter
    private int quoteId;

    public int storeQuoteId(int newQuoteId) {
        quoteIds.add(newQuoteId);
        quoteId = newQuoteId;
        return newQuoteId;
    }
}
