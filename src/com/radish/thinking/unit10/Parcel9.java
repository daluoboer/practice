package com.radish.thinking.unit10;

import com.radish.test.Apple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parcel9 {
    public Destination destination(final String dest){
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println(System.nanoTime());
        List<Apple> a = new ArrayList<>();
        System.out.println();
        int b = 10;
        b = b >> 1;
        System.out.println(b);
        Set s = new HashSet();
        s.add("a");
        s.add("mmm");
        s.add("b");
        for(Object o:s)
            System.out.println(o);
    }
}
