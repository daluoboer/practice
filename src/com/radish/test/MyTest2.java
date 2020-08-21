package com.radish.test;

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(~-1);
        System.out.println((1^2) + " " + (2 ^ 2)+ " " + (3 ^ 2)+ " " + (4 ^ 2)+ " " + (5 ^ 2)+ " " + (6 ^ 2));
        System.out.println((1&2) + " " + (2 & 2)+ " " + (3 & 2)+ " " + (4 & 2)+ " " + (5 & 2)+ " " + (6 & 2));
        System.out.println(((1^2)&2) + " " + ((2 ^ 2)&2)+ " " + ((3 ^ 2)&2)+ " " + ((4 ^ 2)&2)+ " " + ((5 ^ 2)&2)+ " " + ((6 ^ 2)&2));
        int a2 = Integer.MAX_VALUE;
        System.out.println(a2+1);
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
