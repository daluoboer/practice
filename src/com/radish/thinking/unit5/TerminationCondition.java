package com.radish.thinking.unit5;

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
//        novel.checkIn();
//        new Book(true);
        System.gc();
    }
}
