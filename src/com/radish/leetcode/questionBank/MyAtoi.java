package com.radish.leetcode.questionBank;

/**
 * 啊啊啊啊看错啦！复制过来本来是2的31次方，结果成了231！
 * 还有
 *  假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *  第一个条件都没有看到！！！！！第一个非空格字符！！！！
 *  很愚蠢了！不过好歹也开动你的笨脑瓜想了一下~
 *  下次再做吧
 */

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyAtoi {
    public static void main(String[] args) {
//        int i = myAtoi("-12aaaaa");
//        System.out.println(i);
        System.out.println(myAtoi("-0012"));//应该把最前面的0去掉
//        System.out.println(myAtoi("aaa+1"));
        System.out.println(myAtoi("00000002147483648"));
//        System.out.println(myAtoi("aaa+12hui"));
//        System.out.println(myAtoi("aa-aa"));
//        System.out.println(myAtoi("-"));
//        System.out.println(myAtoi("0"));
        /*System.out.println((int)'-');
        System.out.println((int)'+');
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println((char)44);*/
    }
    public static int myAtoi(String str) {
        String trim = str.trim();
        StringBuilder builder = new StringBuilder();
        if (!trim.isEmpty()) {
            int i = 0;
            int fromIndex = -1;
            int fromUsefulIndex = -1;
            int endIndex = -1;
            boolean hasHead = false;//是否已经开始查询数字
            boolean hasUsefulIndex = false;//是否找到首位非0数字
            boolean selectEnd = false;//是否已经查找完毕
            char[] chars = trim.toCharArray();
            //找头（首位字符或数字）
            while (!hasHead && i < chars.length && !selectEnd) {
                char c = chars[i];
                if (c == '-' || c == '+' || (c >= '0' && c <= '9')) {
                    fromIndex = i;
                    hasHead = true;
                    if (c > '0' && c <= '9') {
                        fromUsefulIndex = i;
                        hasUsefulIndex = true;
                    }
                }
                i++;
                if (i >= chars.length) {
                    selectEnd = true;
                }
            }
            //找头（有效数字）
            while (!hasUsefulIndex && !selectEnd) {
                char c = chars[i];
                if (c > '0' && c <= '9') {
                    fromUsefulIndex = i;
                    hasUsefulIndex = true;
                }
                i++;
                if (i >= chars.length) {
                    selectEnd = true;
                    endIndex = i - 1;
                }
            }
            //找尾
            while (!selectEnd) {
                char c = chars[i];
                if (c >= '0' && c <= '9') {
                    if (i < chars.length - 1) {
                        i++;
                    } else {
                        endIndex = i;
                        selectEnd = true;
                    }
                } else {
                    selectEnd = true;
                    endIndex = i-1;
                }
            }
            //只有一个+或-没有数字
            if (fromIndex != -1 && endIndex == fromIndex && (chars[fromIndex] == '-' || chars[fromIndex] == '+')) return 0;

            //无效返回0
            if (fromIndex == -1 || fromUsefulIndex == -1 || endIndex == -1) return 0;

            //符号位
            if (chars[fromIndex] == '-' || chars[fromIndex] == '+') {
                builder.append(chars[fromIndex]);
            }

            //拼接有效数字
            if (fromUsefulIndex != -1 && endIndex != -1) {
                for (int n = fromUsefulIndex; n <= endIndex; n++) {
                    builder.append(chars[n]);
                }
            }

            String s = builder.toString();
            //*注意内存边界*
            char[] chars1 = s.toCharArray();
            if (s.length() == 3){
                //max
                if (chars1[0] == '2') {
                    if (chars1[1] >= '3') {
                        return 230;
                    }
                }
                if (chars1[0] > '2') {
                    return 230;
                }
            }
            if (s.length() == 4) {
                if (chars1[0] == '+') {
                    if (chars1[1] == '2') {
                        if (chars1[2] >= '3') {
                            return 230;
                        }
                    }
                    if (chars1[1] > '2') {
                        return 230;
                    }
                }

                if (chars1[0] == '-') {
                    if (chars1[1] == '2') {
                        if (chars1[2] == '3') {
                            if (chars1[3] >= '1') {
                                return -231;
                            }
                        }
                        if (chars1[2] > '3') {
                            return -231;
                        }
                    }
                }

                if (chars1[0] >= '0' && chars1[0] <= '9') {
                    return 230;
                }
            }
            if (s.length() > 4) {
                if (chars1[0] == '-') {
                    return -231;
                }
                if (chars1[0] == '+') {
                    return 230;
                }
                if (chars1[0] > '0' && chars1[0] <= '9'){
                    return 230;
                }
            }
            int a = Integer.valueOf(s);
            return a;
        }
        return 0;
    }
}
