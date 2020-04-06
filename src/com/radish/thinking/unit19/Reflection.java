package com.radish.thinking.unit19;

import com.radish.thinking.unit18.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore {HERE,THERE}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("--------- Analyzing " + enumClass + " ----------");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        /*Set<Integer> set1 = new HashSet<>();
        set1.add(1);
//        set1.add(2);
        Set<Integer> set2 = new HashSet<>();
//        set2.add(1);
        set2.add(2);
        System.out.println(set1.removeAll(set2));
        System.out.println(set1);
        *//*啊！就是移除了元素就是true，如果没有移除元素就是false*/
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.removeAll(enumMethods));
        System.out.println(exploreMethods);
        OSExecute.command("javap src/com/radish/thinking/unit19/Explore");
    }
}
