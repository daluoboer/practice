package com.example.examine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Description
 * 报文转义功能
 * 报文中如果出现0x0A,转义成两个字节0x12 0x34,如果出现0x0B,转义成两个字节0xAB,0xCD,其他报文保持不变
 * 输出的第一个字节为报文长度（包含它自己）
 * 就是如果输入A就转义成12 34，如果输入B就转义成AB CD
 *
 * 这是修改后的代码哦
 * @Author Radish
 * @Date 2020/4/5
 */

public class Baowen2 {
    public static void main(String[] args) {

        //十进制转其他进制
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toOctalString(12));
        System.out.println(Integer.toHexString(12));
        System.out.println(Integer.toString(12,3));
        Scanner in = new Scanner(System.in);

        //其他进制转十进制
        System.out.println(Integer.parseInt("12",16));

        /*while (in.hasNext()) {
            String str = in.nextLine();
            if (str.equals("")) continue;
            String[] strs = str.split(" ");
            ArrayList<String> list = new ArrayList<>();
            for (String s : strs) {
                if (s.equalsIgnoreCase("A")) {
                    list.add("12");
                    list.add("34");
                } else if (s.equalsIgnoreCase("B")) {
                    list.add("AB");
                    list.add("CD");
                } else {
                    list.add(s);
                }
            }
            list.add(0, Integer.toHexString(list.size() + 1).toUpperCase());
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+ " ");
            }
        }*/
    }
}
