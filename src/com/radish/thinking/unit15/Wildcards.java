package com.radish.thinking.unit15;

//书上说的是Holder类，但是并没有写过这个类啊，那用其他类就没啥意义了啊，这一点先不看了
public class Wildcards {
    static void rawArgs(Holder3 holder, Object arg) {
        Object o = holder.get();
    }
    static void unboundedArg(Holder3<?> holder3,Object arg) {
        Object o = holder3.get();
    }
    static <T> T exact1(Holder3<T> holder3) {
        T t = holder3.get();
        return t;
    }
    static <T> T exact2(Holder3<T> holder3,T arg) {
        holder3.set(arg);
        T t = holder3.get();
        return t;
    }
    static <T> T wildSubtype(Holder3<? extends T> holder3,T arg) {
//        holder3.set(arg);
        T t = holder3.get();
        return t;
    }

    public static void main(String[] args) {
        Holder3 raw = new Holder3<Long>(1l);
        raw = new Holder3(2l);

    }
}
