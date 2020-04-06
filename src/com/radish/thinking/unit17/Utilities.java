package com.radish.thinking.unit17;

import java.util.*;

public class Utilities {
    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" ")
    );

    public static void main(String[] args) {
        /*Integer i2=Integer.valueOf(100);
        System.out.println(i2);

        Integer i3=Integer.valueOf("100");
        System.out.println(i3);


        System.out.println(Integer.valueOf(127)==Integer.valueOf(127));
        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
        System.out.println(Integer.valueOf(127)==Integer.valueOf("127"));
        *//*valueOf会返回一个Integer（整型）对象，当被处理的字符串在-128和127（包含边界）之间时，
        返回的对象是预先缓存的。这就是为什么第一行的调用会返回true-127这个整型对象是被缓存的（所以两次valueOf返回的是同一个对象）
        ——第二行的调用返回false是因为128没有被缓存，所以每次调用，都会生成一个新的整型对象，因此两个128整型对象是不同的对象。
         *//*

        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
        System.out.println(Integer.valueOf(128)==Integer.valueOf(128));

        System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));
        System.out.println(Integer.parseInt("127")==Integer.valueOf("127"));

//        System.out.println(Integer.valueOf("11111111111111111111111111111111111111111",1));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);*/
        System.out.println(list);
        System.out.println("'list' disjoint (Four)?: " + Collections.disjoint(list,Collections.singletonList("Four")));
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max w/ comparator: " + Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list,String.CASE_INSENSITIVE_ORDER));
        List<String> subList = Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSubList: " + Collections.indexOfSubList(list,subList));
        System.out.println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list,subList));
        Collections.replaceAll(list,"one","Yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        Collections.rotate(list,3);
        System.out.println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list,source);
        System.out.println("copy: " + list);
        Collections.swap(list,0,list.size() - 1);
        System.out.println("swap: " + list);
        Collections.shuffle(list,new Random(47));
        System.out.println("shuffled: " + list);
        Collections.fill(list,"pop");
        System.out.println("fill: " + list);
        System.out.println("frequency of 'pop': " + Collections.frequency(list,"pop"));
        List<String> dups = Collections.nCopies(3,"snap");
        System.out.println("dups: " + dups);
        System.out.println("'list' disjoint 'dups'?: " + Collections.disjoint(list,dups));
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while (e.hasMoreElements())
            v.addElement(e.nextElement());
        ArrayList<String> arrayList = Collections.list(v.elements());
        System.out.println("arrayList: " + arrayList);
    }
}
