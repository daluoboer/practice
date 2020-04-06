package com.radish.thinking.unit10;

public class MyOuter {
    class MyInner{
        private String innerStr;
        MyInner(String str){
            innerStr = str;
        }
        String getMyInner(){
            return innerStr;
        }
    }
    public MyInner getInner(String inner){
        return new MyInner(inner);
    }

    public static void main(String[] args) {
        MyOuter outer = new MyOuter();
        MyInner inner = outer.getInner("什么呀");
        System.out.println(inner.getMyInner());
    }
}
