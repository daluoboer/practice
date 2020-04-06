package com.radish.thinking.unit15;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {return array;}

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
//        Integer[] rep = gai.rep();
        Object[] rep = gai.rep();
        gai.put(1,1);
        System.out.println(Arrays.toString(rep));
    }
}
