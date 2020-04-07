package com.radish.examine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * 磁盘容量排序
 * M G T 升序
 * @Author Radish
 * @Date 2020/3/16
 */

public class Rongliang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.next();
            }
            //先转换后排序
            //那都转换成M？
            //或者不转，直接分成三段进行排序？可是如果不转每次比较大小的时候还是要转？
            List<Integer> m = new ArrayList<>(n);
            List<Integer> g = new ArrayList<>(n);
            List<Integer> t = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                if (strs[i].endsWith("M")){
                    m.add(Integer.valueOf(strs[i].substring(0,strs[i].length()-1)));
                } else if (strs[i].endsWith("G")){
                    g.add(Integer.valueOf(strs[i].substring(0,strs[i].length()-1)));
                } else if (strs[i].endsWith("T")){
                    t.add(Integer.valueOf(strs[i].substring(0,strs[i].length()-1)));
                }
            }

            //对三段进行排序，然后一起输出
            sort(m);sort(g);sort(t);
            for (Integer i : m) {
                System.out.println(i +"M");
            }
            for (Integer i : g) {
                System.out.println(i + "G");
            }
            for (Integer i : t) {
                System.out.println(i + "T");
            }

        }

    }
    public static void sort(List<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                int temp = list.get(j);
                if (list.get(j)<list.get(j-1)) {
                    list.set(j,list.get(j-1));
                    list.set(j-1,temp);
                }
            }
        }
    }


    /*public static void sort(List<Integer> list,int l,int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        int curData = list.get(i);
        while (i<j) {
            while (i<j) {
                //从右边挖小的

            }
            while (i<j) {
                //从左边挖大的
            }
        }

    }*/
}
