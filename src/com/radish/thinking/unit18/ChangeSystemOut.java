package com.radish.thinking.unit18;

import java.io.PrintStream;

public class ChangeSystemOut {
    public static void main(String[] args) {
//        PrintWriter out = new PrintWriter(System.out,true);
        PrintStream out = System.out;
        out.println("Hello,world");

    }
}
