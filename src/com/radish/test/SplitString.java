package com.radish.test;

import java.util.Scanner;

/**
 * @Description •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @Author Radish
 * @Date 2020/3/12
 */

public class SplitString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            while (str.length()%8!=0) {
                str+='0';
            }
            int length = str.length()/8;
            String[] strs = new String[length];
            for (int i = 0; i < length; i++) {
                strs[i] = str.substring(i*8,(i+1)*8);
            }
            for (String s : strs) {
                System.out.println(s);
            }
        }
    }
}
