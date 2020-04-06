package com.radish.test;

public class StringTest {

    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        char c[] = {'h','e','l','l','o'};
        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));//行a
        System.out.println(c.equals(t));//行b
        System.out.println(s==new String(s));
        System.out.println(c);
        System.out.println(t);
        //为啥s和t输出都是hello，都是equals却是false呢
        //啊！因为行a是调用的String的equals方法,在对比时先判断地址是否相等，不相等，则判断是否是String类型，不是则返回true，是则对比字符串内容
        /*public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof String) {
                String anotherString = (String)anObject;
                int n = value.length;
                if (n == anotherString.value.length) {
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) {
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }*/
        //行b调用的是object的equals方法,直接比较地址~肯定是false啦
        /*public boolean equals(Object obj) {
            return (this == obj);
        }*/
    }
}
