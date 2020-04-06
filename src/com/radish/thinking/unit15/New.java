package com.radish.thinking.unit15;

import java.util.*;

public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<Object> list = New.list();
        LinkedList<Object> objects = New.lList();
        Set<Object> set = New.set();
        Queue<Object> queue = New.queue();
    }
}
