package com.radish.thinking.unit15;

public class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulator() {obj.f();}
}
