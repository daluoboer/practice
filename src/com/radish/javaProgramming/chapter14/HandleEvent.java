package com.radish.javaProgramming.chapter14;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description HandleEvent
 * @Author Radish
 * @Date 2020-05-11 17:04:08
 */

public class HandleEvent extends JFrame {
    public HandleEvent() {
        JButton jbtOK = new JButton("OK");
        JButton jbtCancel = new JButton("Cancel");

        JPanel panel = new JPanel();
        panel.add(jbtOK);
        panel.add(jbtCancel);

        add(panel);

        OKListenerClass listener1 = new OKListenerClass();
        CancelListenerClass listener2 = new CancelListenerClass();
        jbtOK.addActionListener(listener1);
        jbtCancel.addActionListener(listener2);
    }

    public static void main(String[] args) {
        JFrame frame = new HandleEvent();
        frame.setTitle("Handle event");
        frame.setSize(200,150);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class OKListenerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("OK button clicked!");
        }
    }

    class CancelListenerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cancel button clicked!");
        }
    }
}
