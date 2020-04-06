package com.radish.thinking.unit5;

public class ProveTest {
    static void print(){
        System.out.println("s1: "+s1+"  s2: "+s2);
    }
    static String s1 = "s1";
    static String s2;
    static {
        s2 = "s2";
    }

}
