package com.radish.thinking.unit5;

public class OverloadingVarargs2 {
    static void f(float f, Character... args){
        System.out.println("first");
    }
    static void f(char c, Character... args){
        System.out.println("second");
    }
    static void s(String... args){
        for(String s:args)
            System.out.println(s);
    }

    public static void main(String[] args) {
        f(1,'a');
        f('a','b');
        s(new String[]{"aaaa","bbb"});
    }
}
