package com.radish.thinking.unit15;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        Apple apple = new Apple();
        List<? extends Fruit> flist = Arrays.asList(apple);
//        List<Apple> flist = Arrays.asList(apple);
        Apple a = (Apple) flist.get(0);
        boolean contains = flist.contains(new Apple());
        int i = flist.indexOf(new Apple());
        int j = flist.indexOf(apple);
        System.out.println(contains);
        System.out.println(i);
        System.out.println(j);
        System.out.println(apple == a);
        System.out.println(flist.contains(new Object()));
        System.out.println(flist.indexOf(new Object()));
    }
}
