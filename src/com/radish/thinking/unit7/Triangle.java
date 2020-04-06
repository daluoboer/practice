package com.radish.thinking.unit7;

public class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }
    void dispose(){
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}
