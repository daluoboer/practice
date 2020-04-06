package com.radish.thinking.unit17;

public class TestAAA {
    public static TestAAA t1 = new TestAAA();
    {
        System.out.println("blockA");
    }
    static {
        System.out.println("blockB");
        double bb = 0x12345678;
        long cc = 12;
//        Long dd = 12;
    }

    public static void main(String[] args) {
        TestAAA t2 = new TestAAA();
    }
}
