package com.radish.thinking.unit13;

import java.math.BigInteger;
import java.util.Formatter;

public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s\n",u);
//        f.format("d: %d\n",u);
        f.format("c: %c\n",u);
        f.format("b: %b\n",u);
//        f.format("f: %f\n",u);
//        f.format("e: %e\n",u);
//        f.format("x: %x\n",u);
        f.format("h: %h\n",u);
        System.out.println();

        int v = 121;
        System.out.println("v = 121");
        f.format("s: %s\n",v);
        f.format("d: %d\n",v);
        f.format("c: %c\n",v);
        f.format("b: %b\n",v);
//        f.format("f: %f\n",v);
//        f.format("e: %e\n",v);
        f.format("x: %x\n",v);
        f.format("h: %h\n",v);
        System.out.println();

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("w = new BigInteger(\"50000000000000\")");
        f.format("s: %s\n",w);
        f.format("d: %d\n",w);
//        f.format("c: %c\n",w);
        f.format("b: %b\n",w);
//        f.format("f: %f\n",w);
//        f.format("e: %e\n",w);
        f.format("x: %x\n",w);
        f.format("h: %h\n",w);
        System.out.println();

        double x = 179.543;
        System.out.println("x = 178.543");
        f.format("s: %s\n",x);
//        f.format("d: %d\n",x);
//        f.format("c: %c\n",x);
        f.format("b: %b\n",x);
        f.format("f: %f\n",x);
        f.format("e: %e\n",x);
//        f.format("x: %x\n",x);
        f.format("h: %h\n",x);
        System.out.println();

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
        f.format("s: %s\n",y);
//        f.format("d: %d\n",y);
//        f.format("c: %c\n",y);
        f.format("b: %b\n",y);
//        f.format("f: %f\n",y);
//        f.format("e: %e\n",y);
//        f.format("x: %x\n",y);
        f.format("h: %h\n",y);
        System.out.println();

        boolean z = false;
        System.out.println("z = false");
        f.format("s: %s\n",z);
//        f.format("d: %d\n",z);
//        f.format("c: %c\n",z);
        f.format("b: %b\n",z);
//        f.format("f: %f\n",z);
//        f.format("e: %e\n",z);
//        f.format("x: %x\n",z);
        f.format("h: %h\n",z);


        Integer zz = null;
        f.format("\nb: %b\n",zz);
    }
}
