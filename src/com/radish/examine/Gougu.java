package com.radish.examine;

import java.util.*;

/**
 * @Description
 * 给定范围[N,M]所有勾股数元组
 * @Author Radish
 * @Date 2020/3/16
 */

public class Gougu {
    public static void main(String[] args) {
        //a2 + b2 = c2
        //a,b为质数，下一个质数是否符合
        //先求出质数
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            /*TreeSet<Integer> set = new TreeSet<>();
            for (int i = n; i < m; i++) {
                //求质数？
                set.add(i);
                //是否有约数
                for (int j = 2; j <= i/2; j++) {
                    if (i%2==0) {
                        set.remove(i);
                        break;
                    }
                }
            }*/
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = n; i < m; i++) {
                list.add(i);
            }
            //取三个值看是否符合勾股定理，俩较小的数和一个较大的数，当较大的数平方大于左值时，较大数取小一个
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i<list.size();i++) {
                for (int j = i+1; j < list.size();j++) {
                    for (int k = j+1; k < list.size();k++) {
                        int a = list.get(i);
                        int b = list.get(j);
                        int c = list.get(k);
                        int left = a*a + b*b;
                        int right = c*c;
                        if (left == right && valid(a,b,c)) {
                            //是否互质
                            result.add(a);
                            result.add(b);
                            result.add(c);
                        }
                        if (right>left) break;
                    }
                }
            }

            for (int i = 0; i < result.size();i++) {
                System.out.print(result.get(i)+ " ");
                if ((i+1)%3==0) {
                    System.out.println();
                }
            }
        }
    }

    public static boolean valid(int a,int b,int c) {
        //ab,ac,bc
        return valid(a,b)&&valid(a,c)&&valid(b,c);
    }

    public static boolean valid(int a,int b) {
        for (int i = 2; i <= (a>b?b:a);i++) {
            if (a%i==0 && b%i==0) {
                return false;
            }
        }
        return true;
    }
}
