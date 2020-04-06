package com.radish.thinking.unit2;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;

public class StaticTest {
    static int i = 47;

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();

        System.out.println(st1.i);
        st1.i ++;
        System.out.println(st2.i);
        System.out.println(StaticTest.i);
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        int i = 0;
        Console console = System.console();
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date());
        System.exit(-1);
        System.gc();
    }
}
