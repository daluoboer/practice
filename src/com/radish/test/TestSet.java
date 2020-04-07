package com.example.test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/14
 */

public class TestSet {
    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(getN(1));
        /*Character c = '哈';
        String str = "";
        boolean a = str instanceof Object;
        new BigInteger()
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(objectObjectHashMap);

        TreeSet<Object> objects = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });*/
    }
    public static int getN(int a){
        try {
            int b = 10/a;
            System.out.println("I am try");
            return 0;
        } catch (Exception e) {
            System.out.println("I catch You!");
            return 1;
        } finally {
            System.out.println("Yeah finally");
            return 2;
        }
    }
}
