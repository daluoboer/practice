package com.radish.leetcode.strs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description CommonChars
 *
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * @Author Radish
 * @Date 2020-10-16 10:58
 */
public class CommonChars {
    public static void main(String[] args) {
        CommonChars c = new CommonChars();
//        String[] strings = new String[]{"bella","label","roller"};
//        String[] strings = new String[]{"cool","lock","cook"};
        String[] strings = new String[]{"a"};
        List<String> list = c.commonChars(strings);
        System.out.println(list);
    }
    public List<String> commonChars(String[] A) {
        //这咋查找呢?总不能一个一个字母遍历吧!
        List<String> result = new ArrayList<>();
        //查看每一个字母出现的最低次数
        int[] times = new int[26];
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0; i < A.length; i++) {
                //字符cur在A[i]中出现的次数
                String s = A[i];
                int ll = s.length();
                int count = 0;
                for (int j = 0; j < ll; j++) {
                    if (s.charAt(j) == cur) {
                        count++;
                    }
                }
                if (i == 0) {
                    times[cur-'a'] = count;
                } else if (times[cur-'a'] > count) {
                    times[cur-'a'] = count;
                    if (count == 0) break;
                }
            }
        }

        for (int i = 0; i < times.length; i++) {
            if (times[i] > 0) {
                for (int j = 0; j < times[i]; j++) {
                    result.add(((char)(i+'a'))+"");
                }
            }
        }
        return result;
    }
}
