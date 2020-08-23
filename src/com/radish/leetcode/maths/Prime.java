package com.radish.leetcode.maths;

import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 *
 *
 * 函数接口说明：
 *
 * public String getResult(long ulDataInput)
 *
 * 输入参数：
 *
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 *
 * String
 *
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 复制
 * 180
 * 输出
 * 复制
 * 2 2 3 3 5
 * @Author Radish
 * @Date 2020/3/12
 */

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long l = in.nextLong();
            getResult(l);
        }
    }

    public static String getResult(long ulDataInput){
        StringBuilder str = new StringBuilder();
        long curData = ulDataInput;
        for (int i = 2; i < curData; i++) {
            while (curData%i == 0) {
                curData/=i;
                str.append(i + " ");
            }
        }
        if (curData>1){
            str.append(curData+" ");
        }
        System.out.println(str);
        return str.toString();
    }
}
