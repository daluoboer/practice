package com.radish.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortArray {
    public static List<Integer> sortArray1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : nums) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> params = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            params.add(random.nextInt());
        }
//        int[] arr = new int[]{};
//        int[] arr =
        /*List<Integer> list = SortArray.sortArray1(arr);
        System.out.println(list);*/
    }
}
