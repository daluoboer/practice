package com.radish.leetcode.sortOrSearch;

import java.util.Random;

/**
 * @description VersionControl
 *
 * 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 *
 * @Author Radish
 * @Date 2020/4/917:50
 */

public class VersionControl {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(8));
    }
    private static Random rand = new Random();

    //啥？二分查找居然超出了时间限制？？？嗨呀，你确实写的有点复杂耶，不过解决了就行，之后再做二分的话可以优化~
    public static int firstBadVersion(int n) {
        return firstBad(0,n);
    }

    public static int firstBad(int l,int r) {
        if (l>=r) return l;
        int mid = l + (r - l)/2;
        if (isBadVersion(mid)) {
            //往前找
            if (isBadVersion(mid-1)) {
                //如果前面的错，继续往前找,否则这个就是错的第一个版本
                return firstBad(l,mid-1);
            } else return mid;
        }
        else {
            //往后找
            if (!isBadVersion(mid+1)) {
                //如果后面的一个是错的，说明后面这个就是错误版本
                return firstBad(mid+1,r);
            } else return mid+1;
        }
    }

    public static boolean isBadVersion(int version) {
        boolean[] boos = new boolean[]{true,true,false,false,false,false,false,false};
        return !boos[version];
//        return rand.nextBoolean();
    }

    public static boolean getByIndex(boolean[] boos, int n) {
        return boos[n];
    }
}
