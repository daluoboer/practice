package com.radish.easyCoding.unit6;

import java.util.ArrayList;
import java.util.List;

public class SubListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);

        System.out.println(masterList);
        System.out.println(branchList);
//        masterList.remove(0);
//        masterList.add("ten");
//        masterList.clear();
        System.out.println(masterList);

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (Object t : branchList) {
            System.out.println(t);
        }

        System.out.println(masterList);

        masterList.add(1);

        System.out.println(masterList);
//        对主列表进行更改之后无法再对子列表进行任何操作：Exception in thread "main" java.util.ConcurrentModificationException
//        System.out.println(branchList);
    }
}
