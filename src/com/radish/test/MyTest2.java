package com.radish.test;

public class MyTest2 {
    public static void main(String[] args) {
        //String s = new String("xyz");
        /*String a = "hello2";
        final String b = "hello";
        String c = "hello";

        String d = b+2;
        String e = c+2;
        System.out.println(d);
        System.out.println(e);
        System.out.println(a == d);
        System.out.println(a == e);*/

        final String a = "hello2";
        String b = "hello";
        String e = getHello();
        String c = b+2;
        String d = e+2;
        System.out.println(a == c);
        System.out.println(a == d);


    }
    public static String getHello(){
        return "hello";
    }
}
