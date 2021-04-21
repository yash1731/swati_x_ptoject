package com.aixtrade.support;


import com.aixtrade.OrderControl.OrderIdControl;
import com.aixtrade.QuoteControl.QuoteIdControl;
import com.aixtrade.QuoteControl.QuoteRequestIdControl;
import com.aixtrade.httpsVerbs.*;


public class WorldHelper {

    private static BaseVerb baseVerb;
    private static GetVerb getVerb;
    private static PostVerb postVerb;
    private static DeleteVerb deleteVerb;
    private static OrderIdControl getOrderIdControl;
    private static QuoteIdControl getQuoteIdControl;
    private static QuoteRequestIdControl getQuoteRequestIdControl;

    public GetVerb getVerb() {
        if (getVerb != null) return getVerb;
        getVerb = new GetVerb();
        return getVerb();
    }

    public BaseVerb baseVerb() {
        if (baseVerb != null) return baseVerb;
        baseVerb = new BaseVerb();
        return baseVerb();
    }

    public PostVerb postVerb() {
        if (postVerb != null) return postVerb;
        postVerb = new PostVerb();
        return postVerb();
    }

    public DeleteVerb deleteVerb() {
        if (deleteVerb != null) return deleteVerb;
        deleteVerb = new DeleteVerb();
        return deleteVerb();
    }

    public OrderIdControl getOrderIdControl() {
        if (getOrderIdControl != null) return getOrderIdControl;
        getOrderIdControl = new OrderIdControl();
        return getOrderIdControl;
    }

    public QuoteIdControl getQuoteIdControl() {
        if (getQuoteIdControl != null) return getQuoteIdControl;
        getQuoteIdControl = new QuoteIdControl();
        return getQuoteIdControl;
    }

    public QuoteRequestIdControl getQuoteRequestIdControl() {
        if (getQuoteRequestIdControl != null) return getQuoteRequestIdControl;
        getQuoteRequestIdControl = new QuoteRequestIdControl();
        return getQuoteRequestIdControl;
    }
}
