package com.radish.leetcode.strs;

/**
 * @Description CountSubstrings
 *
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * @Author Radish
 * @Date 2020-08-19 16:10
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstringsFast("aaa"));
    }

    /**
     * 方法一：中心拓展
     * 思路与算法
     *
     * 计算有多少个回文子串的最朴素方法就是枚举出所有的回文子串，而枚举出所有的回文字串又有两种思路，分别是：
     *
     * 枚举出所有的子串，然后再判断这些子串是否是回文；
     * 枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
     * 假设字符串的长度为 nn。我们可以看出前者会用 O(n^2)O(n
     * 2
     *  ) 的时间枚举出所有的子串 s[l_i \cdots r_i]s[l
     * i
     * ​
     *  ⋯r
     * i
     * ​
     *  ]，然后再用 O(r_i - l_i + 1)O(r
     * i
     * ​
     *  −l
     * i
     * ​
     *  +1) 的时间检测当前的子串是否是回文，整个算法的时间复杂度是 O(n^3)O(n
     * 3
     *  )。而后者枚举回文中心的是 O(n)O(n) 的，对于每个回文中心拓展的次数也是 O(n)O(n) 的，所以时间复杂度是 O(n^2)O(n
     * 2
     *  )。所以我们选择第二种方法来枚举所有的回文子串。
     *
     * 在实现的时候，我们需要处理一个问题，即如何有序地枚举所有可能的回文中心，我们需要考虑回文长度是奇数和回文长度是偶数的两种情况。如果回文长度是奇数，那么回文中心是一个字符；如果回文长度是偶数，那么中心是两个字符。当然你可以做两次循环来分别枚举奇数长度和偶数长度的回文，但是我们也可以用一个循环搞定。我们不妨写一组出来观察观察，假设 n = 4n=4，我们可以把可能的回文中心列出来：
     *
     * 编号 ii	回文中心左起始位置 l_il
     * i
     * ​
     *  	回文中心右起始位置 r_ir
     * i
     * ​
     *
     * 0	0	0
     * 1	0	1
     * 2	1	1
     * 3	1	2
     * 4	2	2
     * 5	2	3
     * 6	3	3
     * 由此我们可以看出长度为 nn 的字符串会生成 2n-12n−1 组回文中心 [l_i, r_i][l
     * i
     * ​
     *  ,r
     * i
     * ​
     *  ]，其中 l_i = \lfloor \frac{i}{2} \rfloorl
     * i
     * ​
     *  =⌊
     * 2
     * i
     * ​
     *  ⌋，r_i = l_i + (i \bmod 2)r
     * i
     * ​
     *  =l
     * i
     * ​
     *  +(imod2)。这样我们只要从 00 到 2n - 22n−2 遍历 ii，就可以得到所有可能的回文中心，这样就把奇数长度和偶数长度两种情况统一起来了。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    //wow~厉害哎！！！
    public static int countSubstringsFast(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i/2, r = i/2 + i%2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

    //没错，暴力法超时了
    public static int countSubstrings(String s) {
        //遍历字符串的所有字串，查看它是不是回文串，就是排列组合咩？
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println(s.substring(i,j));
                if (isIt(s.substring(i,j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isIt(String str){
        if (str == null || str.equals("")) return false;
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            String a = str.substring(i,i+1);
            String b = str.substring(length-i-1,length-i);
            if (!a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
