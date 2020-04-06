package com.radish.thinking.unit15;

abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class GreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
