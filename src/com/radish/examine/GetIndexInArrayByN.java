package com.example.examine;

/**
 * @Description
 *
 * 一个整数数组int[] nums，一个整数n
 * 存在且只存在一对数之和=n
 * 求这俩数
 * @Author Radish
 * @Date 2020/4/2
 */

public class GetIndexInArrayByN {
    public static void main(String[] args) {
        getIndexs(new int[]{7,1,7,9,7,3,5,2,4,6,0,1},5);
    }
    //先排序，求最大值和最小值之和，如果>n,最大值往前走，如果<n,最小值往右走
    public static void getIndexs(int[] nums, int n) {
        //不如...换个有意思的排序？嘿嘿嘿....
        //先来快排吧~你要掌握才行啊！
        quickSort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.print(i + "\t");
        }

        //
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            while (nums[i] + nums[j] != n) {
                if (nums[i] + nums[j] < n) {
                    //小了，变大
                    i++;
                } else {
                    j--;
                }
            }
            System.out.println("结果是：" + nums[i] + ", " + nums[j]);
            i++;j--;
        }

    }

    //很棒！
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l;
        int j = r;
        int point = nums[i];
        while (i < j) {
            //右边的小数
            while (i < j && nums[j] >= point){
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            //左边的大数
            while (i < j && nums[i] <= point) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = point;
        //左边
        quickSort(nums, l, i-1);
        //右边
        quickSort(nums, i+1, r);
    }
    //堆排序？要不要挑战一哈er？罢辽先复习框架吧
}
