package com.radish.thinking.unit19;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum OverrideConstantSpecific {
    NUT,BOLT,WASHER {void f() {
        System.out.println("Overridden method");
    }};
    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        /*for (OverrideConstantSpecific ocs : values()) {
            System.out.println(ocs + ": ");
            ocs.f();
        }*/

        System.out.println(test(BigDecimal.valueOf(1.0)));
        System.out.println(test(BigDecimal.valueOf(1.20)));

        System.out.println(test(BigDecimal.ZERO));
        System.out.println(test(BigDecimal.valueOf(0.001)));
        System.out.println(test(BigDecimal.valueOf(5.3)));
    }

    public static BigDecimal test(BigDecimal f){
        BigDecimal bigDecimal = f.setScale(0,RoundingMode.DOWN);
        if (bigDecimal.compareTo(f) != 0) {
            return f;
        }
        return bigDecimal;
    }
}
