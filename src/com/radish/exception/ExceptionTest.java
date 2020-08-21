package com.radish.exception;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/25
 */

public class ExceptionTest {
    public static void main(String[] args) {
//        int a = 1/0;
        /*System.out.println((int)100000l);
        int[] arr = new int[2];
        System.out.println(arr[-1]);*/
        int division = getDivision(10);
        System.out.println(division);
    }

    public static int getDivision(int n) {
        try {
            n+=1;
            if (n/0 > 0) {
                n += 10;
            } else {
                n -= 10;
            }
            return n;
        } catch (Exception e) {
            n++;
        }
        n++;
        return n++;
    }
}
