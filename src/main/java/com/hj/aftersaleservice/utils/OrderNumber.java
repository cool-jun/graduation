package com.hj.aftersaleservice.utils;

import java.util.UUID;

public class OrderNumber {
    public static String getOrderIdByUUID() {
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return machineId + String.format("%015d", hashCodeV);
    }
}
