package com.radish.thinking.unit5;

public class Rock {
    public String s1 = "this is s1";
    public String s2;
    Rock(){
        System.out.println("I am Rock");
    }

    public static void main(String[] args) {
        Rock rock = new Rock();
        System.out.println(rock.s1);
        System.out.println(rock.s2);
    }
}
