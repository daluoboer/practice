package com.radish.thinking.unit17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
