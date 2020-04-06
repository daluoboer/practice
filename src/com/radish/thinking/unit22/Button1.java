package com.radish.thinking.unit22;

import javax.swing.*;
import java.awt.*;

public class Button1 extends JFrame {
    private JButton b1 = new JButton("Button1");
    private JButton b2 = new JButton("Button2");

    public Button1() throws HeadlessException {
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button1(),200,100);
    }
}
