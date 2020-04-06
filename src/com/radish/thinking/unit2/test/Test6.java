package com.radish.thinking.unit2.test;

public class Test6 {
    int storage(String s){
        return s.length() * 2;
    }

    public static void main(String[] args) {
        Test6 t6 = new Test6();
        System.out.println(t6.storage("My name is Amy."));
    }
}
