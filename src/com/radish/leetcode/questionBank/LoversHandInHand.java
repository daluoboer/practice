package com.radish.leetcode.questionBank;

public class LoversHandInHand {
    public static void main(String[] args) {
        int[] lovers = new int[]{5,4,2,6,3,1,0,7};
        System.out.println("交换次数："+minSwapsCouples(lovers));
        printArray(lovers);
    }
    public static void printArray(int[] row) {
        for (int i = 0; i<row.length; i++) {
            System.out.println(row[i]);
        }
    }
    //让每一对情侣都牵手，交换的最小次数
    public static int minSwapsCouples(int[] row) {
        int changeTime = 0;
        for (int i = 0; i<row.length-2; i = i+2) {
            //1.判断当前位置人是否与自己的伴侣在一起
                //(⊙o⊙)…咋判断是不是情侣呢？啊如果这个位置是偶数，那他的伴侣为他+1，如果这个位置是奇数，他的伴侣应该为他-1
            if (row[i] % 2 == 0) {
                if (row[i+1] == row[i]+1) {
                    continue;
                }
                //2.如果不在一起，找到他的伴侣并交换位置
                findLoverAndChange(row, i, row[i] + 1);
                changeTime++;
                //交换位置
            } else {
                if (row[i+1] == row[i]-1) {
                    continue;
                }
                findLoverAndChange(row, i, row[i] - 1);
                changeTime++;
            }
        }
        return changeTime;
    }

    /**
     * 找到伴侣的位置，对象跟别人交换位置，坐回自己身边
     * @param row
     * @param my 自己的位置
     * @param lover
     * @return
     */
    public static void findLoverAndChange(int[] row, int my, int lover) {
        for (int i = my; i<row.length; i++) {
            if (row[i] == lover) {
                int temp = row[my+1];
                row[my+1] = row[i];
                row[i] = temp;
            }
        }
    }

}
