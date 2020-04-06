package com.radish.thinking.unit13;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return " InfiniteRecursion address: "+super.toString()+"\n";
//        return " InfiniteRecursion address: "+this+"\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for(int i = 0;i<10;i++){
            v.add(new InfiniteRecursion());
        }
//        System.out.println(v);
        String s = "   abc  daq   ";
        StringBuilder sb = new StringBuilder("abc");
        StringBuffer stringBuffer = new StringBuffer(s);
        char[] chars = s.toCharArray();
        boolean b = s.contentEquals(s);
        boolean b1 = s.contentEquals(sb);
        boolean b2 = s.contentEquals(stringBuffer);
        boolean equals1 = s.equals(sb);
        System.out.println("equals: "+equals1);
        boolean equals = s.equals(s);
        System.out.println("b: "+b+"\nb1: "+b1+"\nb2: "+b2);
        System.out.println(chars);
        System.out.println(s.charAt(1));
        System.out.println(s.getBytes());
        boolean b3 = s.startsWith("b",1);
        boolean d = s.endsWith("c");
        System.out.println("d: "+d);
        System.out.println("b3: "+b3);
        int i = s.indexOf("a");
        int a = s.lastIndexOf("a");
        System.out.println("i="+i+" a="+a);
        String substring = s.substring(2);
        System.out.println(substring);
        System.out.println(s.replace("b","a"));
        System.out.println(s.trim());
        System.out.println(s.intern());
        System.out.printf("aaa");
    }
}
