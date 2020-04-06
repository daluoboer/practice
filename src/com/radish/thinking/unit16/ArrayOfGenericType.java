package com.radish.thinking.unit16;

public class ArrayOfGenericType<T> {
    T[] array;

    public ArrayOfGenericType(int size) {
        array = (T[])new Object[size];
    }
}
