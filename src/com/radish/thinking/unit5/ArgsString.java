package com.radish.thinking.unit5;

public class ArgsString {
    ArgsString(String s){
        System.out.println("your s is: "+s);
    }

    public static void main(String[] args) {
        ArgsString[] arr = new ArgsString[10];
        for(int i = 0; i<arr.length; i++)
            arr[i] = new ArgsString("I am "+i);
    }
}
