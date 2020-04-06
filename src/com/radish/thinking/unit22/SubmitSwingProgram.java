package com.radish.thinking.unit22;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SubmitSwingProgram extends JFrame {
    JLabel label;

    public SubmitSwingProgram() throws HeadlessException {
        super("Hello Swing");
        label = new JLabel("A label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setVisible(true);
    }
    static SubmitSwingProgram ssp;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp = new SubmitSwingProgram();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hey! This is different!");
            }
        });
    }
}
