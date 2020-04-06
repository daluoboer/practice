package com.radish.easyCoding.unit2;

public class Father {
    Father() {
        System.out.println("Father()");
    }
    static {
        System.out.println("Father's static");
    }
    protected void doSomething() {
        System.out.println("Father's doSomething");
        this.doSomething();
        //噢~这时候其实是调的子方法啊，不过如果是调父类，那它就是一直调用自己了，结果也是一样的
        // Exception in thread "main" java.lang.StackOverflowError
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.doSomething();
        Father.Daughter daughter = son.new Daughter();
        daughter.doSomething();
    }
    public class Daughter {
        Daughter() {
            System.out.println("Daughter()");
        }
        public void doSomething() {
            System.out.println("Daughter's doSomething");
        }
    }

}

class Son extends Father {
    Son() {
        System.out.println("Son()");
    }
    static {
        System.out.println("Son's static");
    }
    @Override
    protected void doSomething() {
        System.out.println("Son's doSomething");
        super.doSomething();
    }
}
