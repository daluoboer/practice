package com.radish.thinking.unit18;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(BufferedInputFile.src + "BasicFileOutput.java")
                )
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(BufferedInputFile.src + file)
                )
        );
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(BufferedInputFile.src + file));

    }
}
