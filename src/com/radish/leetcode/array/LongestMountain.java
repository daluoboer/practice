package com.radish.leetcode.array;

/**
 * @Description LongestMountain
 *
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @Author Radish
 * @Date 2020-10-25 09:12
 */
public class LongestMountain {
    public static void main(String[] args) {
        LongestMountain l = new LongestMountain();
//        int[] ints = new int[]{2,1,4,7,3,2,5};
        int[] ints = new int[]{ 0,1,2,3,4,5,4,3,2,1,0};
        /*int[] ints = new int[]{2,2,2};*/
        int i = l.longestMountain(ints);
        System.out.println(i);
    }

    private int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left+1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }


    public int longestMountain2(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i-1] < A[i] ? left[i-1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i+1] < A[i] ? right[i+1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    public int longestMountain1(int[] A) {
        //遍历所有的山，得到山脉最长的即可
        //哎~不知道头和尾能不能作为山峰？先不让它当山峰
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || i == A.length - 1) continue;
            if (!(A[i] > A[i-1] && A[i] > A[i+1])) continue;
            int[] length = getLength(A, i);
            max = Math.max(length[0],max);
            i += length[1];
            //但是这全都遍历了一遍呀，应该把这个山上的点直接跳过去啊，因为已经遍历过了
        }
        return max;
    }

    private int[] getLength(int[] a, int i) {
        int l = i - 1, r = i + 1, lenL = 1, lenR = 1;
        while (l > 0) {
            if (a[l] <= a[l-1]) break;
            lenL++;
            l--;
        }
        while (r < a.length - 1) {
            if (a[r] <= a[r+1]) break;
            lenR++;
            r++;
        }
        return new int[]{lenL + lenR + 1, lenR};
    }


}
