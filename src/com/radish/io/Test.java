package com.radish.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */

public class Test {
    public static void main(String[] args) {
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream(new File("111.txt"));
            out.write(1);
            in = new FileInputStream("111.txt");
            int read = in.read();
            System.out.println(read);
            File file = new File("111.txt");
            out.close();
            in.close();
            if (file.exists()) {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //
        /*ReentrantLock lock = new ReentrantLock();
        String s = "hhhhh";
        byte[] bytes = s.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bytes));
//        FileOutputStream a = new FileOutputStream("a");

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(s.getBytes())));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
