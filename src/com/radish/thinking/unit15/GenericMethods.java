package com.radish.thinking.unit15;

public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1);
        gm.f("");
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f("c");
        gm.f(gm);
    }
}
