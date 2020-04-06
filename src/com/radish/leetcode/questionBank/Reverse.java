package com.radish.leetcode.questionBank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//反转正负整数 好像也是错的？？？
public class Reverse {
    public static void main(String[] args) {
        int a = -123;
        Character first = Integer.valueOf(a).toString().charAt(0);
        StringBuilder aStr;
        if(isNumsGoodMethod(first.toString())){
            aStr = new StringBuilder(Integer.valueOf(a).toString().substring(1));
        }
        else{
            aStr = new StringBuilder(Integer.valueOf(a).toString());
        }
        StringBuilder reverse = new StringBuilder(Integer.valueOf(a).toString()).reverse();
        if(first.equals('-')){
            System.out.println(new StringBuilder(Character.valueOf(first)).append("i"));
        }
        else{
            System.out.println(reverse);
        }
    }
    public static boolean isNumsGoodMethod(String arr){
        char[] charArray=arr.toCharArray();
        for(char c:charArray){
            if(c>'9'||c<'0')
                return false;
        }
        return true;
    }
    public static boolean isNumeric(String str) {
        String regEx = "^-?[0-9]+$";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        if (mat.find()) {
            return true;
        }
        else {
            return false;
        }
    }
}
