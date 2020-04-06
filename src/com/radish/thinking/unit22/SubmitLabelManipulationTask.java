package com.radish.thinking.unit22;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SubmitLabelManipulationTask {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing!");
        final JLabel label = new JLabel("A label");
        frame.add(label);
        SwingConsole.run(frame,300,300);
        /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);*/
        try {
//            TimeUnit.SECONDS.sleep(1);
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                label.setText("Hey! This is Different!");
                label.setText("Hey! It is one minutes later!");
            }
        });*/
    }
}
