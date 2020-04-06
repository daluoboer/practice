package com.radish.thinking.unit7;

public class C extends A {

    static {
        System.out.println("子类静态域");
    }
    {
        System.out.println("子类域");
    }
    B b = new B("子类变量c1");
    private B b1 = new B("c2 子类私有变量");
    static D d = new D("c 子类static变量");

    public C(String c) {
        System.out.println("C "+c+" 子类构造方法");
    }

    public static void main(String[] args) {
        C c = new C("c");
    }
}
