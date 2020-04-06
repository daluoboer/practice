package com.radish.easyCoding.unit2;

public class OuterClass {//OuterClass.class
    private class InstanceInnerClass {}//OuterClass$InstanceInnerClass.class
    static class StaticInnerClass {}//OuterClass$StaticInnerClass

    public static void main(String[] args) {
        (new Thread() {}).start();//OuterClass$1.class
        (new Thread() {}).start();//OuterClass$2.class
        class MethodClass1 {}//OuterClass$MethodClass1.class
        class MethodClass2 {}//OuterClass$MethodClass2.class
    }
}
