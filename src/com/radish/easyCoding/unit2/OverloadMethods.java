package com.radish.easyCoding.unit2;

public class OverloadMethods {
    public void overloadMethod() {
        System.out.println("无参方法");
    }
    public void overloadMethod(int param) {
        System.out.println("参数为基本类型int的方法");
    }
    public void overloadMethod(Integer param) {
        System.out.println("参数为包装类型Integer的方法");
    }
    public void overloadMethod(Integer... param) {
        System.out.println("可变参数列表");
    }
    public void overloadMethod(Object param) {
        System.out.println("参数为object的方法");
    }

    public void overloadMethod(Integer param1, int param2) {
        System.out.println("参数为Integer和int的方法");
    }

    public void overloadMethod(int param1, Integer param2) {
        System.out.println("参数为int和Integer的方法");
    }

    public static void main(String[] args) {
        OverloadMethods methods = new OverloadMethods();
        methods.overloadMethod(7);
        methods.overloadMethod(new Long(1));
//        methods.overloadMethod(1,1);
    }
}
