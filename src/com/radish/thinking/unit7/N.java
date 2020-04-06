package com.radish.thinking.unit7;

public class N extends M {
    @Override
    public void a() {
        System.out.println("N-a");
    }
    public void b(){
        System.out.println("N-b");
    }

    public static void main(String[] args) {
        N n = new N();
        n.c();
    }
}
