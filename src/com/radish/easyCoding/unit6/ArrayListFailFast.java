package com.radish.easyCoding.unit6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListFailFast {
    public static void main(String[] args) {
        List<Long> copy = new CopyOnWriteArrayList<>();

        Date startDate = new Date();
        Long start = System.nanoTime();
        for (int i = 0; i < 20*10000; i++) {
            copy.add(System.nanoTime());
        }
        Date endDate = new Date();
        List<Long> array = new ArrayList<>();
        for (int i = 0; i < 20*10000; i++) {
            array.add(System.nanoTime());
        }
        copy.addAll(array);
        Date endDate2 = new Date();
        System.out.println("执行耗时"+(endDate.getTime()-startDate.getTime())+"毫秒");
        System.out.println("执行耗时"+(endDate2.getTime()-endDate.getTime())+"毫秒");
    }
    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            synchronized ("a") {//对象
                String item = iterator.next();
                if ("b"=="b") {//删除元素的条件
                    iterator.remove();
                }
            }
        }

        System.out.println(list);
    }*/
}
