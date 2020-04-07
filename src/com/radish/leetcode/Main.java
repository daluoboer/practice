package com.example.leetcode;

import java.util.*;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/12
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        Random random = new Random();
        /*int n = in.nextInt();
        int i = n;
        while (i-->0) {
            set.add(random.nextInt(1000));
        }
        System.out.println(set);
        Main main = new Main();
        Integer[] nums = new Integer[set.size()];
        set.toArray(nums);
        main.structure(nums);
        for (Integer integer : nums) {
            System.out.println(integer);
        }*/
        while (in.hasNext()){
            int n = in.nextInt();
            int i = n;
            HashSet<Integer> set = new HashSet();
            while (i-->0) {
                int i1 = in.nextInt();
                set.add(i1);
            }
            Main main = new Main();
            Integer[] nums = new Integer[set.size()];
            set.toArray(nums);
            main.sort(nums);
            for (Integer integer : nums) {
                System.out.println(integer);
            }
        }
    }

    public void sort(Integer[] nums) {
        for (int i = 0; i < nums.length-1;i++) {
            for (int j = i+1;j>0;j--) {
                if (nums[j]<nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }
}
