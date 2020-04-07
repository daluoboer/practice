package com.radish.classLoader;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */

public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}
    public void sayHello(Human guy){
        System.out.println("Hello,guy");
    }
    public void sayHello(Man guy){
        System.out.println("Hello,gentleman");
    }
    public void sayHello(Woman guy) {
        System.out.println("Hello,lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
    }
}
