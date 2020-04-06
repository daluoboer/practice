package com.radish.thinking.unit8;

class StaticSuper{
    public static String staticGet(){return "Base staticGet()";}
    public String dynamicGet(){return "Base dynamicGte()";}
}
class StaticSub extends StaticSuper{
    public static String staticGet(){return "Derived staticGet()";}
    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        StaticSuper staticSuper = new StaticSuper();
        System.out.println(sup.dynamicGet());
        System.out.println(sup.staticGet());//咦奇怪呀，代码提示不会提示这个方法，但是直接敲出来是可以的不会报错。
//        System.out.println(StaticSuper.staticGet());
    }
}
