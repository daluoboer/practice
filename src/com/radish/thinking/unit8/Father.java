package com.radish.thinking.unit8;

public class Father {
    void f1(){f2();}
    void f2(){
        System.out.println("This is f2()");
    }

    public static void main(String[] args) {
        Father f = new Son();
        f.f1();
    }
}
class Son extends Father{
    @Override
    void f2() {
        System.out.println("This is Override f2()");
    }
}

