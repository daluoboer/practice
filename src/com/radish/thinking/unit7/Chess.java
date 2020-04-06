package com.radish.thinking.unit7;

public class Chess extends BoardGame {
    public Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
