package com.radish.leetcode.array;

/**
 * @Description MergeArray
 *
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 * 昂？？？昂昂昂？？？？？居然通过啦！前几次那个是超时了耶，反正还是需要优化的
 * 昂？？？奇怪了，咋16天前通过了？？？我记错啦？？？算了
 *
 * @Author Radish
 * @Date 2020-04-11 19:34
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] ints = {2, 0};
        int[] ints1 = {1};
        merge(ints,1,ints1,1);
        System.out.println(ints);
        for (int i : ints) System.out.print(i + ", ");
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //先看看第一个数组中是不是为空，第一个和第二个都==0？开始也可能就存了俩0呢？先不考虑0吧，直接比较大小,哎呀怎么傻了吧唧的！人家传了长度啊！
        //先暴力解决吧！从后面插应该会快一点，因为不用移动那么多，就从后头插入吧！
        if (n == 0) return;
        if (m == 0){
            //直接将数组挪到num1中
            for (int i = 0;i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        //1.找一个数，插入
        int totalI = m + n - 1;
        int i = m-1;
        int j = n-1;
        while (totalI >= 0 && j >= 0) {
            //比较哪个值最大，就插入到最后
            if (i < 0) {
                nums1[totalI--] = nums2[j--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[totalI--] = nums1[i--];
            } else {
                nums1[totalI--] = nums2[j--];
            }
        }
    }
}
