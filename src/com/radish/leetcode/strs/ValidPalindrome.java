package com.radish.leetcode.strs;

/**
 * @Description ValidPalindrome
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @Author Radish
 * @Date 2020-08-12 09:04
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        //咋判断它是不是回文字符串呢？就是判断反转后的字符串是不是相同，如果不相同，就将不同的那位删掉再判断是不是相同，噢！好简单呐
        //没有反转字符串的方法？就算是有反转的方法底层也是一个字符一个字符比较的，那你直接比较字符就行啦！前半部分与后半部分是否相同，如果要删一个字符肯定不删前面就是删后面的啊
        /*int length = s.length();
        char left,right;
        int disEqual = 0;
        int leftMove = 0;
        int rightMove = 0;
        for (int i = 0; i < length/2; i++) {
            left = s.charAt(i + leftMove);
            right = s.charAt(length - i - 1 + rightMove);
            if (left != right) {
                if (disEqual == 0) {
                    //如果第一次不相同
                    disEqual++;
                    //删除一个字符
                    //哎呀不能用for循环吧，因为可能有多种情况，用迭代比较好，可以将几种情况分开处理
                } else {
                    return false;
                }
            }
        }
        return true;*/

        int length = s.length();
        int i = length % 2;

        if (i == 0) {
            return valid(s.substring(0,length/2-1),s.substring(length/2,length - 1),1);
        } else {
            return valid(s.substring(0,length/2-1),s.substring(length/2+1,length - 1),1);
        }
    }

    public boolean valid(String ls,String rs,int canMove) {
        //不想写了嘤嘤嘤....要是这是面试呢，你不想找工作啦？你不想挣钱啦！
        //但是一上来就被难倒了...哭泣...啊今天周三昨天周二啊那个琉璃美人煞这两天都有更新哎~哎呀呀呀呀做完这个卷子就允许你去看
        return false;
    }
}
