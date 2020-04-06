package com.radish.thinking.unit5;

public class Test5_10 {
    boolean t = false;
    void goTest(){
        t = true;
    }

    @Override
    protected void finalize() throws Throwable {
        if(!t){
            System.out.println("你没有测试啊！");
        }
        super.finalize();
    }

    public static void main(String[] args) {
        Test5_10 t = new Test5_10();
//        t.goTest();
//        new Test5_10();
        System.gc();
    }
}
