package com.radish.examine;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 *
 * 过多久升温
 *
 * 栈
 *
 * @Author Radish
 * @Date 2020/4/3
 */

public class Temp2 {
    public static void main(String[] args) {
        int[] days = getDays(new int[]{1, 15, 30, 2, 7});
        for (int i : days) {
            System.out.print(i + ", ");
        }


    }

    public static int[] getDays(int[] temps) {
        int[] days = new int[temps.length];
        //过几天温度会升高
        //用栈来处理，如果还有下一天，入栈
        //LinkedList也实现了队列耶~下次也可以试一下哒
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                //当栈不空，并且当前元素大于栈时，弹栈
                days[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return days;
    }


}
