package com.radish.leetcode.strs;

/**
 * @Description BackspaceCompare
 *
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * @Author Radish
 * @Date 2020-10-19 21:37
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare b = new BackspaceCompare();
        /*String s = "rheyggodcclgstf";
        String t = "#rheyggodcclgstf";*/
        /*String s = "abx##";
        String t = "a";*/
        String s = "nzp#o#g";
        String t = "b#nzp#o#g";
        boolean b1 = b.backspaceCompare(s, t);
        System.out.println(b1);
    }
    public boolean backspaceCompare(String S, String T) {
        //从后往前遍历，如果#前不是#，删除前一个字符，否则记录下要删除的字符数，直到删除字符,啊不用删除啊！直接跟另一个字符串比较就行啊！
        int si = S.length() - 1, ti = T.length() - 1, tj = 0, sj = 0;
        while (si >= 0 && ti >= 0) {
            if (S.charAt(si) != '#' && T.charAt(ti) != '#') {
                if (S.charAt(si) != T.charAt(ti)) {
                    return false;
                } else {
                    si--;ti--;
                }
            } else {
                // 如果某一个为# 那么记录下要删除一个字符，如果前面还是#，继续往前，直到删除掉非#字符
                si = getI(S, si);
                ti = getI(T, ti);
            }

        }
        // 如果有一个字符串已经结束了，那么另一个字符串有可能是有#号，那么再将它获取一次有效index即可
        if (si * ti <= 0) {
            if (si < 0) ti = getI(T, ti);
            else si = getI(S, si);
            //此时已经将最浅的字符处理
            if (si * ti <= 0) return false;
        }
        return true;
    }

    private int getI(String s, int i) {
        //从si位开始，往前最大的有效位index
        int num = 0;
        while (i >= 0 && s.charAt(i) == '#') {
            i--;num++;
        }
        while (i >= 0 && num > 0) {
            //往前删除字母，万一删着删着又有#咋办呢？
            while (i >= 0 && num > 0 && s.charAt(i) != '#') {
                num--;i--;
            }
            //继续上一个循环啊，直到删除所有
            while (i >= 0 && s.charAt(i) == '#') {
                i--;num++;
            }
        }
        return i;
    }
}
