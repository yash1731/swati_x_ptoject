package com.aixtrade.OrderControl;

import com.aixtrade.httpsVerbs.DeleteVerb;
import com.aixtrade.utilities.TestData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class OrderIdControl {

    public static List<String> orderIds = new ArrayList<>();
    @Getter
    private String orderId;

    public String storeOrderId(String newOrderId) {
        orderIds.add(newOrderId);
        orderId = newOrderId;
        return newOrderId;
    }

    public static void deleteOrderIds() {
        List<String> orders = orderIds;
        System.out.println("Found order ids" + orderIds);
        orders.forEach(orderId -> {
            String order_uri = TestData.getValue("order service");
            String endpoint = order_uri + "/" + orderId;
            DeleteVerb deleteVerb = new DeleteVerb();
            deleteVerb.deleteOnApi(endpoint, null);
        });
    }

    public static void resetOrderIds() {
        orderIds.clear();
    }
}
