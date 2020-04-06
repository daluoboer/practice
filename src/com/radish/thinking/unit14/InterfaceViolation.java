package com.radish.thinking.unit14;

class B implements A {
    @Override
    public void f() {

    }

    public void g(){}
}
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}
