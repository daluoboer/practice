package com.example.examine;

/**
 * @Description
 *
 * 过多久升温
 *
 * @Author Radish
 * @Date 2020/4/3
 */

public class Temp {
    public static void main(String[] args) {
        int[] days = getDays(new int[]{1, 15, 30, 2, 7});
        /*for (int i : days) {
            System.out.print(i + ", ");
        }*/


    }

    public static int[] getDays(int[] temps) {
        int[] days = new int[temps.length];
        //过几天温度会升高
        for (int i = 0; i < temps.length; i++) {
            days[i] = 0;
            for (int j = i+1; j < temps.length; j++) {
                if (temps[j]>temps[i]) {
                    days[i] = j-i;
                    break;
                }
            }
        }
        return days;
    }


}
