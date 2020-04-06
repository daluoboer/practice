package com.radish.thinking.unit7;

public class M {
    public void a(){
        System.out.println("M-a");
    }
    private void b(){
        System.out.println("M-b");
    }
    public void c(){
        a();b();
        System.out.println("M-c");
    }
}
