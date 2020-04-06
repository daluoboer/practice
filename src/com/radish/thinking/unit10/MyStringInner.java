package com.radish.thinking.unit10;

public class MyStringInner {
    private String myStr;
    MyStringInner(String str){
        myStr = str;
    }
    class InnerString{
        public String toStringI() {
            return "这是："+myStr;
        }
    }
    public String toString(){
        return new InnerString().toStringI();
    }
}
