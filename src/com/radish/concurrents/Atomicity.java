package com.example.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

public class Atomicity {
    int i;
    void f1(){i++;}
    void f2(){i+=3;}
}
