package com.radish.test;

public class InnerTest {
    int a = 0;
    static int b = 1;
    private String c;
    private static String d;
    class Inner1{
        //private static String inner11;
        void test(){
            //外围类属性
            System.out.println(a);
            //外围类静态属性
            System.out.println(b);
            //外围类私有属性
            System.out.println(c);
            //外围类私有静态属性
            System.out.println(d);
        }
        /*
        * 普通内部类：
        * 可以访问外围类非静态数据，包含私有数据
        * 可以访问外围类静态数据，包含私有数据
        * */
    }
    static class Inner2{
        private static String inner22;
        void test(){
            //System.out.println(a);
            System.out.println(b);
            //System.out.println(c);
            System.out.println(d);
        }
        /*
        * 静态内部类：
        * 可以访问外围类静态数据，包含私有数据
        * 不可以访问外围类非静态数据
        * */
    }
}
