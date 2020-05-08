package com.radish.javaProgramming.chapter3;

import java.util.Scanner;

/**
 * @description ComputeBMI
 * @Author Radish
 * @Date 2020-05-08 14:41:14
 */

public class ComputeBMI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your weight(kg):");
        while (in.hasNext()) {
            double weight = in.nextDouble();
            System.out.println("Please enter your height(m):");
            double height = in.nextDouble();
            double bmi = weight / (height * height);
            System.out.println("your bmi is " + bmi);
            getStatus(bmi);
            System.out.println("Please enter your weight(kg):");
        }
    }
    public static void getStatus(double bmi) {
        if (bmi < 16) {
            System.out.println("you are too light,you should eat more or get more nutrition so that you can heavier");
        } else if (bmi < 18) {
            System.out.println("you are a little light,just eat what you want");
        } else if (bmi < 24) {
            System.out.println("you are healthy!");
        } else if (bmi < 29) {
            System.out.println("hey,you are a little weight,eat letter and do some sports");
        } else if (bmi < 35) {
            System.out.println("sorry,but you are overweight,you must care for your body and do some sports to make you keep healthy");
        } else {
            System.out.println("god,you should go to hospital to get some suggestions to get healthy");
        }
    }
}
