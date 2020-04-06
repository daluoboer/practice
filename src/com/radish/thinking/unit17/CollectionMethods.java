package com.radish.thinking.unit17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println("c = " + c);
        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        System.out.println("array = " + array);
        System.out.println("str = " + str);
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collection.min(c) = " + Collections.min(c));
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println("\nafter c2.addAll(Countries.names(6); c.addAll(c2)); then c = " + c);
        c.remove(Countries.DATA[0][0]);
        System.out.println("\nafter c.remove(Countries.DATA[0][0]), then c = " + c);
        c.remove(Countries.DATA[1][0]);
        System.out.println("\nafter c.remove(Countries.DATA[1][0]), then c = " + c);
        c.removeAll(c2);
        System.out.println("\nafter c.removeAll(c2), then c = " + c);
        c.addAll(c2);
        System.out.println("\nafter c.addAll(c2), then c = " + c);
        String val = Countries.DATA[3][0];
        System.out.println("\nc.contains(" + val + ") = " + c.contains(val));
        c.remove(val);
        System.out.println("\nc2 = " + c2);
        System.out.println("\nc.containsAll(c2) = " + c.containsAll(c2));
        Collection<String> c3 = ((List<String>)c).subList(3,5);
        System.out.println("c = " + c);
        System.out.println("\nc3 = ((List<String>)c).subList(3,5): " + c3);
        c2.remove("BENIN");
        //保留交集
        c2.retainAll(c3);
        System.out.println("\nc2 = " + c2);
        c2.removeAll(c3);
        System.out.println("\nc2.isEmpty() = " + c2.isEmpty());
        c = new ArrayList<>();
        c.addAll(Countries.names());
        System.out.println("\nc = " + c);
        c.clear();
        System.out.println("\nafter c.clear(): " + c);
    }
}
