package com.radish.thinking.unit16;

import java.util.Comparator;

class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}
public class ComparatorTest {
    public static void main(String[] args) {
//        CompType[] a = Generated
    }
}
