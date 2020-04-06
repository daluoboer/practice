package com.radish.niuke;

import java.io.UnsupportedEncodingException;

public class GbkTest {
    public static void main(String[] args) {
        byte[] src = {1,2,3},dst = {};
        try {
            dst = new String(src,"GBK").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(src);
        System.out.println(dst);
    }
}
