package com.radish.thinking.unit2.test;

public class Test8 {
    public static Integer i = 10;
    private static Integer j = 5;
    public static Integer getJ(){
        return j++;
    }

    public static void main(String[] args) {
        Test8 t1 = new Test8();
        Test8 t2 = new Test8();
        System.out.println("t1.i="+t1.i+" t2.i="+t2.i+" Test8.i="+Test8.i);
        Test8.i++;
        System.out.println("t1.i="+t1.i+" t2.i="+t2.i+" Test8.i="+Test8.i);
        System.out.println("t1.j="+t1.getJ()+" t2.j="+t2.getJ()+" Test8.j="+Test8.getJ());
    }
}
