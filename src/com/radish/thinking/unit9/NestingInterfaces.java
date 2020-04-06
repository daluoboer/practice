package com.radish.thinking.unit9;

import com.radish.thinking.unit7.C;

class A{
    interface B{
        void f();
    }
    public class BImp implements B{
        @Override
        public void f() {

        }
    }
    private class BImp2 implements B{
        @Override
        public void f() {

        }
    }
    public interface C{
        void f();
    }
    class CImp implements C {
        @Override
        public void f() {

        }
    }
    private class CImp2 implements C{
        @Override
        public void f() {

        }
    }
    private interface D{
        void f();
    }
    private class DImp implements D{
        @Override
        public void f() {

        }
    }
    public class DImp2 implements D{
        @Override
        public void f() {

        }
    }
    public D getD(){
        return new DImp2();
    }
    private D dRef;
    public void receiveD(D d){
        dRef = d;
        dRef.f();
    }
}
interface E{
    interface G{
        void f();
    }
    public interface H{
        void f();
    }
    void g();
}

/**
 * 其实对于内部类这些还不是很理解，因为也没怎么用到过，所以也没有想过内部类的意义是什么
 * 内部接口啥的当然也没有想过
 * 恩..唯一用到的地方就是Mybatis
 * o....还有一个没想过的是在一个文件中包含多个类或接口有什么意义，与单独放在外面的文件有什么区别
 * e....现在也不想想....行吧，那你先看看其他的
 */
public class NestingInterfaces {
    public class BImp implements A.B{
        @Override
        public void f() {

        }
    }
    class CImp implements A.C{
        @Override
        public void f() {

        }
    }
    class EImp implements E{
        @Override
        public void g() {

        }
    }
    class EGImp implements E.G{
        @Override
        public void f() {

        }
    }
    class EImp2 implements E{
        @Override
        public void g() {

        }
        class EG implements E.G{
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.getD();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
