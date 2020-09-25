package com.radish.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description Easy
 * @Author Radish
 * @Date 2020-09-23 13:46
 */
public class Easy {
//    public static int a = 0;
    public static void main(String[] args) {
        Byte b = new Byte("127");
        new Byte((byte)1);
        Short s = new Short("1");
        new Short((short)1);
        Integer a = new Integer("1");
        new Integer(1);
        Long l = new Long("1");
        new Long(1);
        Character c = new Character('1');
        new Character((char)1);
        Float f = new Float("1");
        new Float(1);
        Double d = new Double("1");
        new Double(1);
        Boolean bool = new Boolean("0");
        new Boolean(true);

        System.out.println(b + " -- Byte : " + Math.log(Byte.MAX_VALUE + 1)/Math.log(2)/8);
        System.out.println(s + " -- Short : " + Math.log(Short.MAX_VALUE + 1)/Math.log(2)/8);
        System.out.println(a + " -- Integer : " + Math.log(Integer.MAX_VALUE)/Math.log(2)/8);
        System.out.println(l + " -- Long : " + Math.log(Long.MAX_VALUE)/Math.log(2)/8);
        System.out.println(c + " -- Character : " + Math.log(Character.MAX_VALUE - Character.MIN_VALUE + 1)/Math.log(2)/8);
        System.out.println(f + " -- Float : " + Math.log(Float.MAX_VALUE + 1)/Math.log(2)/8);
        System.out.println(d + " -- Double : " + Math.log(Double.MAX_VALUE)/Math.log(2)/8);
        System.out.println(bool);
        System.out.println(Math.pow(10.0, 308));
        System.out.println(Math.pow(2,1023));
        System.out.println(Double.MAX_VALUE);
        System.out.println(Boolean.TYPE + " " + Boolean.TRUE + " " + Boolean.FALSE);
        List<Integer> ts = new ArrayList<>();
        ts.add(1);
        ts.add(10);
        ts.add(3);
        Collections.sort(ts);
        System.out.println(ts);

        /*Easy e = new Easy();
        e.getA();*/

//        int a = 0;
//        double b = 1;
//        a++;
//        a = a + 1;
//        a--;
//        b--;
    }
    public synchronized void getA() {
//        System.out.println("A");
//        Object o = new Object();
        synchronized (this) {
//            System.out.println("B");
        }
    }
}
