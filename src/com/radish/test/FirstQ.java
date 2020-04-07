package com.example.test;

import java.util.Scanner;

/**
 * @Description
 * 输入数字序列，验证是否符合规则
 * 规则：
 * 1.一位数和二位数交替出现
 * 2.头尾为一位数，中间为二位数
 * 3.头尾为二位数，中间为一位数
 * @Author Radish
 * @Date 2020/3/16
 */

public class FirstQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.length()<1) continue;
            String[] strs = str.split(" ");
            //如果只有一个或0个，为true
            if (strs.length < 1) continue;
            if (strs.length<2) {
                System.out.print(true + " ");
                continue;
            }
            boolean right = false;

            boolean flag = true;
            //数字个数>=2
            int length0 = strs[0].length();
            int length1 = strs[1].length();
            int lengthLast = strs[strs.length-1].length();
            if (length0 != length1 && length0 != lengthLast) {
                //只能是交替
                for (int i = 0; i < strs.length; i+=2) {
                    if (strs[i].length() != length0) {
                        flag = false;
                    }
                }
                for (int i = 1; i < strs.length; i+=2) {
                    if (strs[i].length() != length1) {
                        flag = false;
                    }
                }
                if (flag) right = true;
            }
            if (length0 == lengthLast){
                //情况2或3,中间的长度不能等于头尾
                for (int i = 1; i < strs.length-1; i++) {
                    if (strs[i].length() == length0) {
                        flag = false;
                    }
                }
                if (flag) right = true;
            }
            System.out.print(right + " ");
        }

    }
}
