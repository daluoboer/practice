package com.radish.thinking.unit12;

import com.radish.thinking.unit9.Apply;

class Apple{
    Integer num = 0;
}
public class TestException {
    public static void a() throws MyException {
        throw new MyException();
    }
    public static void b() throws MyException {
        throw new MyException("What happened?");
    }

    public static Integer testFunction(){
        Apple apple = new Apple();
        Integer a = 1;
        Integer b = null;
        try {
            if(b == 1){
                a++;
                apple.num++;
            }
            System.out.println("try: a="+a+" apple.num="+apple.num);
            return apple.num;
        } catch (Exception e) {
            a++;
            apple.num++;
            return apple.num;
//            System.out.println("try: a="+a+" apple.num="+apple.num);

        } finally {
            a++;
            apple.num++;
            System.out.println("finally: a="+a);
//            return a;
        }
    }
    public static void main(String[] args) {

        System.out.println("testFunction() = "+testFunction());

        /*try {
            a();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Yes,you did a()");
        }
        try {
            b();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("you did b()");
        }*/
    }
}
