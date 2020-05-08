package com.radish.javaProgramming.chapter2;

/**
 * @description Test
 * @Author Radish
 * @Date 2020-05-07 18:15:39
 */

public class Test {
    public static void main(String[] args) {
        final int A = 10;
        int a = Integer.MAX_VALUE + 1;
        System.out.println(a);
        int b = Integer.MIN_VALUE;
        System.out.println(b);
        System.out.println(b-1);
//        int c = -2147483649;
//        System.out.println(c);
        System.out.println(1-0.1-0.1-0.1);
        System.out.println(1-0.3);
        System.out.println(1-0.9);
        //八进制以0开头
        System.out.println(0111);
        //十六进制以0x或0X开头
        System.out.println(0x10);
        System.out.println(5.0/9);
        System.out.println(6.0/9);
        System.out.println(6/9.0);
        System.out.println(6/9);
    }

    public final void a(){
        System.out.println("hhhhhh");
    }
}
