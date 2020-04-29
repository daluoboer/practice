package com.radish.leetcode.clever;

/**
 * @description BulbSwitch
 *
 * 319. 灯泡开关
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 * @Author Radish
 * @Date 2020-04-29 15:34:28
 */

public class BulbSwitch {
    public static void main(String[] args) {
        int num = 10000;
//        long start = new Date().getTime();
        System.out.println("\n" + bulbSwitch1(num));
        System.out.println("\n" + bulbSwitch(num));
//        long end = new Date().getTime();
//        System.out.println((end-start));
    }

    //e....看来不是刚好平方的数就行哎，有的时候不对，哎，不管，先提交试试
    //哈？真的是！为啥呢
    public static int bulbSwitch1(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if ( sqrt*sqrt == i ) {
                result++;
            }
        }
        return result;
    }


    public static int bulbSwitch(int n) {
        //e...我觉得自己写得蛮好的~但是超时了哎~99999999
        //其实可以直接计算出每个灯泡被改变状态的次数哎！而且这明明就是二进制嘛，就是电路的开关，然后怎样利用二进制呢？算了，先不用二进制，啊这个不是脑筋急转弯吗？e...
        //啊！就是第几个灯泡就被改变了几次啊！只要看这个数是奇数还是偶数就行啦，如果是偶数就是关闭的，如果是奇数|就是开的，啊好像不对~根据true换行，好像发现了什么？？？为啥一个true俩false，然后每次的false都会增加俩呢
        //啊因为不是每个开关被开了n次啊！n=3时，第二次根本就没有走3啊，第三次才走，所以它跟2一样也切换了两次，啊！就是可以开方的数都是true！啊也不是哎.....只是false每次增加俩而已，为什毛！
        //啊！其实就是这个数有几个约数嘛！可以被几个数整除就可以被切换几次啊！
        boolean[] bulbs = new boolean[n];
        int[] nums = new int[n];
        //第i轮
        int times = 0;
        while (times < n) {
            for (int i = times++; i < n; i=i+times) {
                bulbs[i] = !bulbs[i];
                nums[i]++;
            }
        }

        int i = 1;
        for (boolean b : bulbs) {
            if (b) System.out.println();
            System.out.print(i++ + "." + b + " ");
        }

        i = 0;
        for (int j : nums) {
            if (j%2 != 0) System.out.println();
            System.out.print(i++ + ":" + j + " ");
        }

        times = 0;
        for (boolean b : bulbs) {
            if (b) {
                times++;
            }
        }

        return times;
    }
}
