package com.aixtrade.hooks;


import com.aixtrade.Streams.QuoteStreams.QuoteStreamFactory;
import com.aixtrade.Streams.OrderStreams.StreamFactory;
import cucumber.api.java.Before;

public class GlobalHooks {

    private static boolean dunit = false;


    @Before(order = 1)
    public static void beforeAllTests() {
        if (!dunit) {
            System.out.println("Run once at start time.........................");
            StreamFactory.subscribeToAllStreams();
            QuoteStreamFactory.subscribeToQuoteStreams();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.out.println("Calling System.exit() ..................");
                }
            });
        }
        dunit = true;
    }
}
