package com.radish.thinking.unit3;

public class TestBinary {
    public static void main(String[] args) {
        /*System.out.println(Integer.toBinaryString(100));
        System.out.println(Long.toBinaryString(0100));
        System.out.println(Integer.toBinaryString(0x100));*/
        float f4 = 1e-40f;
        float f5 = 11111111111111111111111111111111111111.0f;
        /*System.out.println(true&true);
        System.out.println(true|true);
        System.out.println(true^true);
        System.out.println();*/
        int a = 0xaaaaa;
        int b = 0x5555;
        int A = -a;
        /*System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(A));*/
//        System.out.println(Integer.toBinaryString(b));
        /*System.out.println(Integer.toBinaryString(a&b));
        System.out.println(Integer.toBinaryString(a|b));
        System.out.println(Integer.toBinaryString(a^b));*/
        /*System.out.println("正数右移");
        System.out.println(Integer.toBinaryString(a>>1));
        System.out.println("有符号右移");
        System.out.println(Integer.toBinaryString(a>>>1));

        System.out.println("负数右移");
        System.out.println(Integer.toBinaryString(A>>1));
        System.out.println("有符号右移");
        System.out.println(Integer.toBinaryString(A>>>1));

        System.out.println("正数左移");
        System.out.println(Integer.toBinaryString(a<<1));

        System.out.println("负数左移");
        System.out.println(Integer.toBinaryString(A<<1));*/

        /*int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
        long l = -1;
        System.out.println(Long.toBinaryString(l));
        l >>>= 10;
        System.out.println(Long.toBinaryString(l));*/
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));

        System.out.println();
        byte b1 = -1;
        System.out.println(Integer.toBinaryString(b1));
        System.out.println(Integer.toBinaryString(b1 >>> 10));
        b1 >>>= 10;
        System.out.println(Integer.toBinaryString(b1));


    }
}
