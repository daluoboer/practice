package com.example.leetcode.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/10
 */

public class Erfen {
    public static void main(String[] args) {
        /*System.out.println("hhhhh");
        int search = searchAgain(new int[]{5}, -5);
        System.out.println(search);*/
//        System.out.println(mySqrt(2147395599));
        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() && scanner.nextInt()!=0) {
            System.out.println(mySqrt(scanner.nextInt()));
        }*/

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = in.nextInt();
            }
            List<Integer> list = sortArray(ints);
            System.out.println(list);
        }


//        System.out.println(search(new int[]{4,5,6,7,0,1,2},8));
//        System.out.println(search(new int[]{3,1},0));
        /*int[] structure = new int[]{1,5,2,3,0};
        List<Integer> integerList = sortArray(structure);
        System.out.println(integerList);*/
    }

    /**
     * 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        //需要知道旋转点在哪里然后选择某一段进行查找
        int i = 0;
        int j = nums.length-1;
        //需要先找到旋转点耶！要不会有问题的
        //那么有旋转点的咋办呐
        if (nums.length < 1) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
        } else if (nums[nums.length-1] > nums[0]) {
            while (i <= j) {
                int mid = i + (j-i)/2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        } else if (nums[nums.length-1] < nums[0]) {
            while (i <= j) {
                int mid = i + (j-i+1)/2;
                if (nums[mid] < nums[mid-1]){
                    //mid 为旋转点
                    if (target == nums[mid]) return mid;
                    if (target > nums[mid-1]) return -1;
                    if (target > nums[nums.length-1]) {
                        //在前半段中
                        i = 0;
                        j = mid-1;
                    } else {
                        //在后半段中
                        i = mid;
                        j = nums.length-1;
                    }

                    //继续查找
                    while (i <= j) {
                        mid = i + (j-i)/2;
                        if (nums[mid] == target) return mid;
                        if (nums[mid] > target) {
                            j = mid - 1;
                        } else {
                            i = mid + 1;
                        }
                    }
                } else {
                    if (nums[mid]>nums[0]){//比nums[0]大说明还是前半段
                        i = mid + 1;
                    } else {//后半段
                        j = mid - 1;
                    }
                }
            }
        }
        return -1;

    }


    /**
     *  x 的平方根
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        //哇！求平方根原来也可以通过二分查找来实现啊！牛！
        int i = 1;
        int j = x;
        while (i <= j) {
            int mid = i + (j-i)/2;
            int result = x/mid;
            if (result==mid) {
                return mid;
            } else if (result>mid){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }


    public static int searchAgain(int[] nums,int target){
        if (nums.length >= 1) {
            int i = 0;
            int j = nums.length-1;
            while (i<=j) {
                int mid = i+(j-i)/2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    i = mid + 1;
                }
                if (nums[mid] > target) {
                    j = mid - 1;
                }
            }
            return -1;
        }
        return -1;
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    /*public static int search(int[] nums, int target) {
        return searchInArray(nums,0,nums.length-1,target);
    }

    public static int searchInArray(int[] nums,int start,int end,int target) {
        if (start > end) return -1;
        int index = (end+start)/2;
        if (nums[index] == target) return index;
        if (nums[index] < target) return searchInArray(nums,index+1,end,target);
        if (nums[index] > target) return searchInArray(nums,0,index-1,target);
        return -1;
    }*/


    /*public static int search(int[] nums,int target) {
        int i = 0;
        int j = nums.length-1;
        while (i<=j) {
            int index = i+ (j-i)/2;
            if (nums[index] == target) return index;
            if (nums[index] < target) {
                i = index + 1;
            }
            if (nums[index] > target) {
                j = index - 1;
            }
        }
        return -1;
    }*/

    /**
     * 排序
     * @param nums
     * @return
     */
    public static List<Integer> sortArray(int[] nums) {
        //冒泡
        /*好像冒得不对耶*/
        /*for (int i = 0; i < nums.length-1;i++) {
            for (int j = 0; j < nums.length-i-1;j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }*/

        /*这种才对啊*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1;j>0;j--) {
                if (nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }*/

        //快速排序
        quickSort(nums,0,nums.length-1);


        //选择排序
        /*for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length;j++) {
                if (nums[i]>nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/
        //哎呀呀你这样都把选择排序搞复杂了！不需要每次交换的啊！只要把第i小的数放到第i位即可！
        /*for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }*/

        //插入排序
        /*for (int i = 0; i <nums.length-1; i++) {
            for (int j = i+1;j>0;j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } *//*else break;*//*
            }
        }*/
        //

        return arrToList(nums);
    }

    /*快速排序*/
    public static void quickSort(int[] nums, int l, int r) {
    //选定一个基数，把小于该数的放在该数前，大于该数的放在该数后
        int i = l,j = r;
        if (i >= j) return;
        int curData = nums[i];//选定基数
        while (i < j) {
            while (j > i){
                if (nums[j]<curData) {
                    nums[i] = nums[j];
                    i++;
                    break;
                }
                j--;
            }
            while (j > i) {
                if (nums[i] > curData) {
                    nums[j] = nums[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        nums[i] = curData;
        //然后对左右两边继续排序
        quickSort(nums,l,i-1);
        quickSort(nums,j+1,r);
    }

    public static List<Integer> arrToList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int obj : nums) {
            list.add(obj);
        }
        return list;
    }
}
