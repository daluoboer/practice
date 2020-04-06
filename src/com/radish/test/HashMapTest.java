package com.radish.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap h = new HashMap();
        h.put(null,null);
        System.out.println(h.get(null));
        h.put(0,1);
        System.out.println(h.get(0));
        System.out.println(h.get(1));
        System.out.println(h.containsKey(null));
        System.out.println(h.containsKey(1));
        int a = -10;
        System.out.println("十进制："+a+"；二进制："+Integer.toBinaryString(a));
        a = a>>1;
        System.out.println("十进制："+a+"；二进制："+Integer.toBinaryString(a));
        System.out.println(h.size());
        HashMap h1 = new HashMap();
        h1.putAll(h);
        System.out.println(h1);
        System.out.println(h == h1);
        HashMap h2 = h;
        System.out.println(h2 ==h);
        System.out.println(h.containsValue(null));
        System.out.println(h.containsValue(""));
        Set s = new HashSet();
    }
}
