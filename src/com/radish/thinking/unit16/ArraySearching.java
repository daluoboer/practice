package com.radish.thinking.unit16;

import com.radish.thinking.unit15.Generator;

import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = {10,2,5,8,1,6,12,7,3,4,17,16};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int times = 0;
        while (true) {
            int r = gen.next();
            times++;
            int location = Arrays.binarySearch(a,r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                System.out.println("times = " + times);
                break;
            }
        }
    }
}
