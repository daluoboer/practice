package com.radish.easyCoding.unit6;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEquals {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        if (arrayList.equals(linkedList)) {
            System.out.println("equals is true");
        } else {
            System.out.println("equals is false");
        }

        if (linkedList.equals(arrayList)) {
            System.out.println("ling equals is true");
        } else {
            System.out.println("ling equals is false");
        }
    }
}
