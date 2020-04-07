package com.radish.examine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Description
 * 报文转义功能
 * 报文中如果出现0x0A,转义成两个字节0x12 0x34,如果出现0x0B,转义成两个字节0xAB,0xCD,其他报文保持不变
 * 输出的第一个字节为报文长度（包含它自己）
 * 就是如果输入A就转义成12 34，如果输入B就转义成AB CD
 *
 * 这是笔试源代码
 * @Author Radish
 * @Date 2020/3/16
 */

public class Baowen {
    public static void main(String[] args) {
        /*System.out.println(0x0a);
        System.out.println(0x0B);
        System.out.println(0x12);
        System.out.println(0x34);*/
        /*ArrayList<String> list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add(1,"a");
        System.out.println(list);*/
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.equals("")) continue;
            String[] strs = str.split(" ");
            ArrayList<String> list = new ArrayList<>();
            for (String s : strs) {
                if (s.equalsIgnoreCase("ReflectionTest")) {
                    list.add("12");
                    list.add("34");
                } else if (s.equalsIgnoreCase("B")) {
                    list.add("AB");
                    list.add("CD");
                } else {
                    list.add(s);
                }
            }
            list.set(0, String.valueOf(list.size()));
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+ " ");
            }
        }
    }
}
