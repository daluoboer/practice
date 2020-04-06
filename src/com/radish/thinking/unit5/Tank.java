package com.radish.thinking.unit5;

public class Tank {
    //0为空，1为满
    byte status = 1;
    void takeOut(){
        status = 0;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(status == 1){
            System.out.println("不空不许走！");
        }
        else{
            System.out.println("你可以走了！");
        }
    }

    public static void main(String[] args) {
        new Tank().status = 0;
        System.gc();
    }
}
