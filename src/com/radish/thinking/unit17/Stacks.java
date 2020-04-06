package com.radish.thinking.unit17;

import java.util.LinkedList;
import java.util.Stack;

enum Month {JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER}
public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values())
            stack.push(m.toString());
        System.out.println("stack = " + stack);
        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("popping elements : ");
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values())
            lstack.addFirst(m.toString());
        System.out.println("\nlstack = " + lstack);
        while (!lstack.isEmpty())
            System.out.print(lstack.removeFirst() + " ");
        com.radish.thinking.unit11.Stack<String> stack2 = new com.radish.thinking.unit11.Stack<>();
        for (Month m : Month.values())
            stack2.push(m.toString());
        System.out.println("\nstack2 = " + stack2);
        while (!stack2.empty())
            System.out.print(stack2.pop() + " ");
    }
}
