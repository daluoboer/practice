package com.radish.leetcode.sortOrSearch;

import com.radish.utils.MyUtils;

/**
 * @Description SortedSquares
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Radish
 * @Date 2020-10-16 09:48
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares s = new SortedSquares();
//        int[] ints = new int[]{-4,-1,0,3,10};
//        int[] ints = new int[]{-7,-3,2,3,11};
        int[] ints = new int[]{-7};
//        int[] ints = new int[]{};
        int[] ints1 = s.sortedSquares(ints);
        MyUtils.print(ints1);
    }

    //可以利用正负,因为已经有序了,那么负数部分为降序,正数部分为升序,所以两头的数大于中间的数
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0, end = A.length - 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = A[start]*A[start] > A[end]*A[end] ? A[start]*A[start++] : A[end]*A[end--];
        }
        return result;
    }

    public int[] sortedSquares1(int[] A) {
        //那就是先排序再求平方，或者是先求平方再排序呗
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = A[i] * A[i];
        }
//        sortArr(result);
        quickSort(result,0, result.length - 1);
        return result;
    }

    //插入排序
    public void sortArr(int[] arr) {
        //比较到哪一个数字
        //当前数字到了哪里
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    //快排
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        int cur = arr[start];
        while (i < j) {
            //从后面找小于基准值的
            while (i < j && arr[j] >= cur) {
                j--;
            }
            //在j处挖坑,在i处填数
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //从前面找大于基准值的
            while (i < j && arr[i] <= cur) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //找到了自己的坑,填进去
        arr[i] = cur;
        //左边和右边继续排序
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
