package com.radish.thinking.unit9;

public class Impl implements MyInter,SonInter,SonInter1 {
    @Override
    public void sonInter() {
        System.out.println("sonInter");
    }

    @Override
    public void sonInter1() {
        System.out.println("sonInter1");
    }

    @Override
    public void myInter() {
        System.out.println("myInter");
    }

    public static void main(String[] args) {
        Impl i = new Impl();
        i.myInter();
        i.sonInter();
        i.sonInter1();
    }
}
