package com.radish.io;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */

public class Test {
    public static void main(String[] args) {
        //
        ReentrantLock lock = new ReentrantLock();
        String s = "hhhhh";
        byte[] bytes = s.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bytes));
//        FileOutputStream a = new FileOutputStream("a");

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(s.getBytes())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
