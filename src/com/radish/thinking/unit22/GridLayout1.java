package com.radish.thinking.unit22;

import javax.swing.*;
import java.awt.*;

public class GridLayout1 extends JFrame {
    public GridLayout1() {
        setLayout(new GridLayout(7,3));
        for(int i = 0; i < 23; i++){
            add(new JButton("Button "+i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayout1(),300,300);
    }
}
