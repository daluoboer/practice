package com.radish.thinking.unit17;

public class SpringDetector2 {
    public static void main(String[] args) {
        try {
            SpringDetector.detectSpring(Groundhog2.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
