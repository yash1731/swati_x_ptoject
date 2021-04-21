package com.aixtrade.hooks;

import cucumber.api.java.Before;

public class GlobalHooks {

    private static boolean dunit = false;


    @Before(order = 1)
    public static void beforeAllTests(){
        if (!dunit) {
            System.out.println("Run once at start time.........................");
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
