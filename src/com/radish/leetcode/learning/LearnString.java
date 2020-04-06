package com.radish.leetcode.learning;

public class LearnString {
    public static void main(String[] args) {
        // "static void main" must be defined in a public class.

        // initialize
        /*String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
        System.out.println("-----------------------------------------------");*/
        /*String s1 = "Hello World";
        // 1. concatenate
        s1 += "!";
        System.out.println(s1);
        // 2. find
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));*/
        /*String s = "Hello World";
        char[] str = s.toCharArray();
        str[5] = ',';
        System.out.println(str);*/
        /*int n = 10000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("hello");
        }
        String s = str.toString();*/

//        System.out.println(addBinary("1","1"));
        /*System.out.println((int)'1');
        System.out.println((int)'0');*/

//        System.out.println(strStr("1231","5"));

//        System.out.println(longestCommonPrefix(new String[]{"abc","c"}));
        /*char[] cs = new char[]{'a','b'};
        reverseString(cs);
        System.out.print('[');
        for (char c : cs) {
            System.out.print(c);
        }
        System.out.print(']');*/
        System.out.println(arrayPairSum(new int[]{-1,0}));
    }

    /**
     * 二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * <p>
     * 输入为非空字符串且只包含数字 1 和 0。
     * <p>
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int lengthA = charsA.length;
        int lengthB = charsB.length;
        /*如果有一个为空那就返回不为空的那个*/
        if (lengthA == 0 || lengthB == 0) {
            return lengthA == 0 ? b : a;
        }

        /*创建几位呢？要不要进位呢？有点像之前那个99+1进位那个耶*/
        int minLength = lengthA < lengthB ? lengthA : lengthB;
        int maxLength = minLength == lengthA ? lengthB : lengthA;
        int toAdd = 0;
        char[] result = new char[maxLength];//多创建一位，预防进位-->不能多创建！因为idea中可以，但是浏览器的编译器会把result[0]转化为字符串"\u0000"
        for (int i = 0; i < minLength; i++) {
            int curA = charsA[lengthA - i - 1] == '0' ? 0 : 1;
            int curB = charsB[lengthB - i - 1] == '0' ? 0 : 1;
            int sum = curA + curB + toAdd;
            if (sum >= 2) {
                toAdd = 1;
            } else {
                toAdd = 0;
            }
            result[maxLength - i - 1] = sum % 2 == 1 ? '1' : '0';
        }

        int add = 0;
        if (lengthA > lengthB) {
            add = setResultValue(maxLength - minLength, toAdd, charsA, result);
        } else {
            add = setResultValue(maxLength - minLength, toAdd, charsB, result);
        }

        String resultStr = new String(result);

        if (add == 1) return '1' + resultStr;
        return resultStr;
    }

    public static int setResultValue(int diffLength, int toAdd, char[] from, char[] to) {
        if (to.length < diffLength || from.length < diffLength) return 0;
        for (int i = diffLength - 1; i >= 0; i--) {
            int sum = (from[i] == '0' ? 0 : 1) + toAdd;
            if (sum >= 2) {
                toAdd = 1;
            } else {
                toAdd = 0;
            }
            to[i] = sum % 2 == 1 ? '1' : '0';
        }
        return toAdd;
    }


    /**
     * 实现 strStr()
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == "") return 0;
        if (haystack == "" || haystack.length() < needle.length()) return -1;
//        if (!haystack.contains(needle)) return -1;-->还是不要这样写了...因为它里头就是用的indexOf()...
        /*只循环到最后一个==needle长度的就行*/
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String substring = haystack.substring(i, needle.length() + i);
            if (substring.equals(needle)) return i;
        }
        return -1;
    }


    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {//嗷！看人家写的有的是调用string自己的方法，可以啊，不过你这个也行啦
        //获取最短字符串
        //遍历字符串
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int shortIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[shortIndex].length()) {
                shortIndex = i;
            }
        }
        String shortStr = strs[shortIndex];
        for (int i = shortStr.length(); i > 0; i--) {//i为公共前缀length，从最长的开始
            String publicStr = shortStr.substring(0, i);
            boolean flag = true;
            for (int j = 0; j < strs.length && flag; j++) {//j为str.length()
                if (j == shortIndex) continue;//不用跟自己比
                if (!publicStr.equals(strs[j].substring(0, i))) {
                    flag = false;
                }
            }
            if (flag) {
                return publicStr;
            }
        }
        return "";
    }


    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     * <p>
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * @param s
     */
    public static void reverseString(char[] s) {//哇！这也太聪明了吧！双指针咋这么神奇！原本反转字符串多麻烦啊！（如果用你自己的方法），厉害厉害！
        if (s.length <= 1) return;
        int head = 0;
        int tail = s.length - 1;
        char c;
        while (head < tail) {
            c = s[head];
            s[head] = s[tail];
            s[tail] = c;
            head++;tail--;
        }
    }


    /**
     *   数组拆分 I
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * 示例 1:
     *
     * 输入: [1,4,3,2]
     *
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).      -->为啥啊，嗷！min(1,3)+min(2,4),min(1,4)+min(2,3)
     * 提示:
     *
     * n 是正整数,范围在 [1, 10000].
     * 数组中的元素范围在 [-10000, 10000].
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        //就是把比较小的一半给取和~
        //先排序，然后取和取到n~
        //咦你咋看的！不是取和！
        //重新审题嗷~
        //就是取的min应该尽量最大，咋取？这跟双指针有啥关系呢？
        //应该较大的值尽量在后面~还是排序嘛，然后取index为单数的sum即可，为啥？还得再想一想，现在有点像蒙的...

        /*e...在浏览器上执行超出时间限制了...那只能换个排序了啊*/
        /*for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
