package com.radish.thinking.unit7;

public class A {
    static D d = new D("a1 父类static");
    D d2 = new D("a2 父类成员变量");
    static {
        System.out.println("父类static域");
    }
    {
        System.out.println("父类域");
    }
    public A() {
        System.out.println("父类构造方法A");
    }
}
