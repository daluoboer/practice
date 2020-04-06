package com.radish.thinking.unit10;

public class DotThis10_3 {
    void f(){
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis10_3 Outer(){
            return DotThis10_3.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis10_3 dt = new DotThis10_3();
        DotThis10_3.Inner dti = dt.inner();
        dti.Outer().f();
    }
}
