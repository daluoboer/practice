package com.radish.thinking.unit17;

import java.util.ArrayList;
import java.util.List;

public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
        System.out.println(hellos[0].equals(hellos[1]));
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        a.retainAll(b);
        System.out.println(a);
    }
}
