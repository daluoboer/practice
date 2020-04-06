package com.radish.thinking.unit5;

public class OptionalTrailingArgujents {
    static void f(int required, String... traling){
        System.out.print("required: "+required+" ");
        for(String s:traling)
            System.out.print(s+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        f(1,"one");
        f(2,"two","three");
        f(0);
    }
}
