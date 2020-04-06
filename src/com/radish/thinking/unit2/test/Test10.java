package com.radish.thinking.unit2.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is Test10
 */
public class Test10 {
    /*
    这是main方法
     */
    public static void main(String[] args) {
        String[] arr = new String[3];
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<3;i++){
            arr[i] = input.next();
        }
        for(int i = 0;i<3;i++){
            System.out.println("The "+(i+1)+" string you input is:'"+arr[i]+"'");
        }
    }
}
