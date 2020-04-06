package com.radish.thinking.unit14;

public class WildcardClassReference {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
