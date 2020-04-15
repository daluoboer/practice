package com.radish.utils;

/**
 * @description Utils
 * @Author Radish
 * @Date 2020/4/917:38
 */

public class MyUtils {
    private static int counter = 0;
    public static void print(int[] nums) {
        System.out.println("----------" + ++counter + "----------");
        for (int i : nums)
            System.out.print(i + ", ");
        System.out.println("\n");
    }

    public static void print(int[][] nums) {
        for (int[] arr : nums) {
            for (int i : arr) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
