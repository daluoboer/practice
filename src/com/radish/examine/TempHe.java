package com.example.examine;

import java.util.Stack;


public class TempHe {
    public static void main(String[] args) {
        int[] days = dailyTemperatures(new int[]{1, 15, 30, 2, 7});
        for (int i : days) {
            System.out.print(i + ", ");
        }


    }
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; i ++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        //处理剩余找不到更高问题的索引数据。
        while(!stack.isEmpty()){
            result[stack.peek()] = 0;
            stack.pop();
        }
        return result;
    }
}
