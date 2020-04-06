package com.radish.leetcode.questionBank;

import java.math.BigDecimal;


public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(1534236469));
    }

    /**
     * 错误的方法！
     * @param x
     * @return
     */
    public static int reverse(int x) {
        BigDecimal temp;
        //加入系统只能存32位有符号整数，如果溢出返回0
        if (x < 0) {
            temp = BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(-1));
        } else {
            temp = BigDecimal.valueOf(x);
        }
        /*if (temp.compareTo(BigDecimal.valueOf(-Math.pow(2,31)))<0 || temp.compareTo(BigDecimal.valueOf(Math.pow(2,31)-1))>0 ) {
            return 0;
        }*/
        StringBuilder result = new StringBuilder().append(temp).reverse();
        BigDecimal resultInt;
        if (x <= 0) {
            resultInt = new BigDecimal(result.toString()).multiply(BigDecimal.valueOf(-1));
        } else {
            resultInt = new BigDecimal(result.toString());
        }
        if (resultInt.compareTo(BigDecimal.valueOf(-Math.pow(2,31)))<0 || temp.compareTo(BigDecimal.valueOf(Math.pow(2,31)-1))>0 ) {
            return 0;
        }
        return resultInt.intValue();
    }
}
