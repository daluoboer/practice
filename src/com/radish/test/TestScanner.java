package com.radish.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/16
 */

public class TestScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i++ == 0){
                System.out.write(13);
            }
            strs.add(in.nextLine());
            System.out.println(strs);
        }

    }
}
