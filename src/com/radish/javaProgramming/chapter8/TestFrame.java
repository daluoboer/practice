package com.radish.javaProgramming.chapter8;

import javax.swing.*;

/**
 * @description TestFrame
 * @Author Radish
 * @Date 2020-05-11 11:15:55
 */

public class TestFrame {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Window1");
        frame1.setSize(200,150);
        frame1.setLocation(200,100);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        JFrame frame2 = new JFrame();
        frame2.setTitle("Window2");
        frame2.setSize(200,150);
        frame2.setLocation(410,100);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }
}
