package com.radish.thinking.unit22;

import javax.swing.*;
import java.awt.*;

public class FlowLayout1 extends JFrame {
    public FlowLayout1() {
        setLayout(new FlowLayout());
        for(int i = 0; i < 20; i++){
            add(new JButton("Button "+i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new FlowLayout1(),500,300);
    }
}
