package com.radish.thinking.unit22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TextPane extends JFrame {
    private JButton b = new JButton("Add Text");
    private JTextPane tp = new JTextPane();
    Random random = new Random();
    public TextPane() {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<10; i++) {
                    tp.setText(tp.getText()+random.nextInt()+"\n");
                }
                tp.setText(tp.getText()+"\n");
            }
        });
        add(new JScrollPane(tp));
        add(BorderLayout.SOUTH,b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextPane(),475,425);
    }
}
