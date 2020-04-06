package com.radish.thinking.unit7;

public class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }
    void dispose(){
        System.out.println("Erasing Circle");
        super.dispose();
    }
}
