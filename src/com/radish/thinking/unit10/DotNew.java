package com.radish.thinking.unit10;

public class DotNew {
    public class Inner{}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
//                dn.new Inner();
    }
}
