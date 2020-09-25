package com.radish.jvm;

import java.util.List;

/**
 * @Description GenericType
 * @Author Radish
 * @Date 2020-09-24 16:06
 */
public class GenericType {
    public static void main(String[] args) {
        /*m(new ArrayList<String>());
        GenericType g = GenericType.class.newInstance();*/
        int a = 1;
        int b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println("c == d : " + (c == d) );
        System.out.println("e == f : " + (e == f));
        System.out.println("c == (a+b) : " + (c == (a+b)));
        System.out.println("c.equals(a+b) : "+ (c.equals(a+b)));
        System.out.println("g == (a+b) : "+ (g == (a+b)));
        System.out.println("g.equals(a+b) : " + g.equals(a+b));
    }

    public static String m(List<String> list) {
        return "";
    }
}
