package com.radish.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    public static void main(String[] args){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ThreadLocal threadLocal = new ThreadLocal();
        MyTest.useEnum(Fruits.Apple);
        ConcurrentHashMap map = new ConcurrentHashMap();
        Map s = new HashMap();
        Map s1 = new Hashtable<String,String>();
        ReentrantLock lock = new ReentrantLock();
        Apple apple = new Apple(1);
        Thread t1 = new Thread();
        Random myRandom = new Random();
        myRandom.nextInt();
        List<String> arrayList = new ArrayList<>();
        String str = "abcjdoeijfergocba";
        System.out.println(str.endsWith("cba"));
        System.out.println(str.startsWith("abc"));
    }

    /**
     * 测试Enum
     */
    public static void useEnum(Fruits fruit){
        switch(fruit){
            case Apple:
                System.out.println("You are an apple!");
                break;
            case Banana:
                System.out.println("You are a banana!");
                break;
            case Orange:
                System.out.println("You are an orange!");
        }
    }
}
