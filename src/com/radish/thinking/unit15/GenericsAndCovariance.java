package com.radish.thinking.unit15;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());
//        flist.add(new Jonathan());
//        flist.add(new Fruit());
//        flist.add(null);
//        flist.add(null);
        Fruit fruit = flist.get(0);
    }
}
