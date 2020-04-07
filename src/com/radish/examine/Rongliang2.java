package com.example.examine;

import java.util.*;

/**
 * @Description
 * 磁盘容量排序
 * M G T 升序
 * @Author Radish
 * @Date 2020/3/16
 */

public class Rongliang2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] strs = new String[n];

            //先转换后排序
            //那都转换成M？
            //或者不转，直接分成三段进行排序？可是如果不转每次比较大小的时候还是要转？
            //知道啦！利用TreeMap啊！
            TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    //直接获取单位，然后换算比较
                    int o11 = getO(o1);
                    int o22 = getO(o2);
                    if (o11 < o22) {
                        return -1;
                    }
                    if (o11 > o22) {
                        return 1;
                    }
                    return 0;
                }
            });
            for (int i = 0; i < n; i++) {
//                strs[i] = in.next();
                set.add(in.next());
            }
            System.out.println(set);

        }

    }

    private static int getO(String o1) {
        int o11 = Integer.valueOf(o1.substring(0,o1.length()-1));
        switch (o1.substring(o1.length()-1)) {
            case "G":
                o11 = o11 * 1000;
                break;
            case "T":
                o11 = o11 * 1000000;
                break;
        }
        return o11;
    }
}
