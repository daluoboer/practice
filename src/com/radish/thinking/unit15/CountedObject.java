package com.radish.thinking.unit15;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CounteredObject " + id;
    }
}
