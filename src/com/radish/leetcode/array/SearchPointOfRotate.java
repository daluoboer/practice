package com.radish.leetcode.array;

/**
 * @description SearchPointOfRotate
 *
 * 33. 搜索旋转排序数组
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
 *
 * 呀！这个题居然真的做过哎！之前的做法好像还很厉害~不过效率好像跟这次做的差不多啦！
 *
 * 之前的做法耶~懒得看~e...还是瞄一瞄吧~之前的做法在{@link com.radish.leetcode.structure.Erfen#search(int[] nums, int target)}噢！
 *
 * @Author Radish
 * @Date 2020-04-27 15:56:41
 */

public class SearchPointOfRotate {
    public static void main(String[] args) {
        int search = search(new int[]{5, 6, 7, 10, 1, 2, 4}, 1);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        //双指针可以吗？可是 是不是
        //哎呀你看错啦！是搜索是不是存在一个值，不是找到旋转点
        //不过的确需要找到旋转点啊因为你要找到最大值嘛，可不可以用二分法，咋感觉似曾相识呢
        //找到旋转点，就是这个点大于它后面的值，可是如果先找到旋转点的话，那复杂度不就已经O(n)了吗
        //直接通过二分查找呢？在二分的过程中查找旋转点
        return searchNum(nums,target,0,nums.length-1);
    }

    public static int searchNum(int[] nums, int target, int left, int right) {
        if (left > right || left < 0 || right >= nums.length) return -1;

        if (left == right) {
            if (nums[left] == target) return left;
            else return -1;
        }

        //在数组的[left]~[right]中查找target,如果找到了就返回index，否则就返回-1
        int mid = left + (right - left)/2;
        if (nums[mid] == target) return mid;
        if (mid < right) {
            if (nums[mid] > nums[mid+1]) {
                //该点为旋转点，它为最大值，它后面的值为最小值
                if (target > nums[mid] || target < nums[mid+1]) return -1;
            }
        }
        //如果右点大于左点，说明该段是顺序的，否则说明是旋转的
        int leftIndex = -1;
        int rightIndex = -1;
        if (nums[left] < nums[mid]) {
            //顺序
            if (target >= nums[left] && target <= nums[mid-1]) {
                //可以继续找
                leftIndex = searchNum(nums,target,left,mid - 1);
            }
        } else {//转折点不明确也可以继续找
            leftIndex = searchNum(nums,target,left,mid - 1);
        }

        if (nums[right] > nums[mid]) {
            if (target >= nums[mid+1] && target <= nums[right]) {
                //可以继续找
                rightIndex = searchNum(nums,target,mid+1,right);
            }
        } else {
            rightIndex = searchNum(nums,target,mid+1,right);
        }
        if (leftIndex > -1) return leftIndex;
        if (rightIndex > -1) return rightIndex;
        return -1;
    }
}
