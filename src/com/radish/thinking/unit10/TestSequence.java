package com.radish.thinking.unit10;

public class TestSequence {
    public static void main(String[] args) {
        MySequence mySequence = new MySequence(20);
        for(int i=0;i<20;i++){
            mySequence.add("我是第"+(i+1)+"个Object");
        }
        Selector selector = mySequence.getSelector();
    }
}
