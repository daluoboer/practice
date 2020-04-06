package com.radish.thinking.unit5;

import java.util.ArrayList;
import java.util.List;

public class NewVarArgs {
    static void printArray(Object... args){
        for(Object obj:args)
            System.out.print(obj+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        /*printArray(new Integer(47),new Float(3.14),new Double(11.11));
        printArray(47,3.14f,11.11);
        printArray(new A(),new A(),new A());
        printArray(new Integer[]{1,2,3,4});
        printArray();*/
        Long a = 111l;
        Long b = 111l;
        System.out.println(a==b);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(2);
        list2.add(3);
        list1.addAll(list2);
        System.out.println(list1);
    }
}
