package com.radish.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description JudgePoint24
 *
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 * @Author Radish
 * @Date 2020-08-22 14:06
 */
public class JudgePoint24 {
    public static void main(String[] args) {
        /*boolean b = judgePoint24(new int[]{1, 3, 4, 6});
        System.out.println(b);*/
        boolean a = true;
        a ^= false;
        System.out.println(a);
        a ^= true;
        System.out.println(a);
    }

    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    /**
     * 官方题解
     * @param nums
     * @return
     */
    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public static boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }


    /**
     * 这是人家写的
     * @param nums
     * @return
     */
    public boolean judgePoint24_1(int[] nums) {
        double a = nums[0]; double b = nums[1];
        double c = nums[2]; double d = nums[3];
        return judge(a, b, c, d);
    }

    public boolean judge(double a, double b, double c, double d){
        return
                // a b
                judge(a + b, c, d) ||
                        judge(a * b, c, d) ||
                        judge(a - b, c, d) ||
                        judge(b - a, c, d) ||
                        judge(a / b, c, d) ||
                        judge(b / a, c, d) ||
                        // b c
                        judge(c + b, a, d) ||
                        judge(c * b, a, d) ||
                        judge(c - b, a, d) ||
                        judge(b - c, a, d) ||
                        judge(c / b, a, d) ||
                        judge(b / c, a, d) ||
                        // c d
                        judge(c + d, a, b) ||
                        judge(c * d, a, b) ||
                        judge(c - d, a, b) ||
                        judge(d - c, a, b) ||
                        judge(c / d, a, b) ||
                        judge(d / c, a, b) ||
                        // b d
                        judge(b + d, a, c) ||
                        judge(b * d, a, c) ||
                        judge(b - d, a, c) ||
                        judge(d - b, a, c) ||
                        judge(b / d, a, c) ||
                        judge(d / b, a, c) ||
                        // a c
                        judge(a + c, b, d) ||
                        judge(a * c, b, d) ||
                        judge(a - c, b, d) ||
                        judge(c - a, b, d) ||
                        judge(a / c, b, d) ||
                        judge(c / a, b, d) ||
                        // a d
                        judge(a + d, b, c) ||
                        judge(a * d, b, c) ||
                        judge(a - d, b, c) ||
                        judge(d - a, b, c) ||
                        judge(a / d, b, c) ||
                        judge(d / a, b, c) ;

    }
    public boolean judge(double a, double b, double c){// 24 , 3 , 8
        return
                // a b
                judge(a + b, c) ||
                        judge(a * b, c) ||
                        judge(a - b, c) ||
                        judge(b - a, c) ||
                        judge(a / b, c) ||
                        judge(b / a, c) ||
                        // b c
                        judge(c + b, a) ||
                        judge(c * b, a) ||
                        judge(c - b, a) ||
                        judge(b - c, a) ||
                        judge(c / b, a) ||
                        judge(b / c, a) ||
                        // a c
                        judge(c + a, b) ||
                        judge(c * a, b) ||
                        judge(c - a, b) ||
                        judge(a - c, b) ||
                        judge(c / a, b) ||
                        judge(a / c, b);
    }

    public boolean judge(double a, double b){
        return
                //注意精度
                Math.abs(a + b - 24) < 0.001 ||
                        Math.abs(a - b - 24) < 0.001 ||
                        Math.abs(b - a - 24) < 0.001 ||
                        Math.abs(a * b - 24) < 0.001 ||
                        Math.abs(a / b - 24) < 0.001 ||
                        Math.abs(b / a - 24) < 0.001;
    }


    /**
     * 这个也是人家写的
     * @param nums
     * @return
     */
    public boolean judgePoint24_2(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve2(list);
    }

    boolean solve2(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);
                if (valid) return true;
            }
        }
        return false;
    }
}
