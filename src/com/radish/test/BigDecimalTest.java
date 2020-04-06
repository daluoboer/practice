package com.radish.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {
    BigDecimal b1;

    public static void main(String[] args) {
        /*BigDecimalTest bb = new BigDecimalTest();
        System.out.println(bb.b1.intValue());*/
        /*List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(1));
        appleList.add(new Apple(3));
        for (Apple apple:appleList){
            apple.setAge(apple.getAge()+1);
            System.out.println(apple.getAge());
        }*/
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        System.out.println(list.toString().substring(1,list.toString().length()-1));
    }
}
