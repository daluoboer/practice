package com.radish.collections;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/26
 */

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(-1);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        linkedList.getFirst();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(1);

        TreeMap<Integer,String> map = new TreeMap<>();

        Set<Map.Entry<Integer,String>> set = new HashSet<>();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
//        System.out.println(5^9);
//        System.out.println(Objects.hashCode(5)^Objects.hashCode("hhh"));
//        System.out.println(Objects.hashCode(5)^Objects.hashCode("hhh"));
        /*低位全置为1，然后+1可获得>=该数的最小的2的幂*/
        /*int n = 18;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);

        System.out.println((n < 0) ? 1 : (n >= 100) ? 100 : n + 1);*/
        /*int[] a = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 0;
        int index = 1;
        System.arraycopy(a,index,a,index+1,2);
        a[index] = 1;
        for (int i : a)
            System.out.println(i);*/
    }
}
