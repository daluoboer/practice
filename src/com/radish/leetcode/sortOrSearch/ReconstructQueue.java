package com.radish.leetcode.sortOrSearch;

import com.radish.utils.MyUtils;

/**
 * @Description ReconstructQueue
 *
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @Author Radish
 * @Date 2020-09-30 11:06
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        ReconstructQueue r = new ReconstructQueue();
//        int[][] ints = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        int[][] ints1 = r.reconstructQueue(ints);
        MyUtils.print(ints1);
    }
    public int[][] reconstructQueue(int[][] people) {
        //1.按照h顺序从小到大排序
        //2.按照当前顺序与k插入新数组
        sort(people, 0, people.length - 1);
        //people已经按照h的顺序排好啦，然后勒，再排k
        int[][] result = new int[people.length][];
        sortK(people, result);
        return result;
    }

    private void sortK(int[][] people, int[][] result) {
        //啊就是生成一个people.length的map然后存储下标，哪个被填上了，就给他移除，啊~机智或者直接用一个boo的数组啊！可以可以！
        boolean[] filled = new boolean[people.length];
        //把数组放到队列中？但其实也是一个一个遍历啊,嗷，你还得知道前面哪些位置有数据，哪些位置没有数据，以及™前面有啥后面有啥...e...那你还是遍历吧
        for (int i = 0; i < people.length; i++) {
            int[] p = people[i];
            int p1 = p[1];
            //是默认值给错了啊，应该给第一个不为true的值！
            int count = 0, j = 0;
            while (filled[j]) j++;
            //其实就是前面的空位，就是k是几就给它放到第几个空位那里~ok！
            while (count < p1 && j < filled.length) {
                if (!filled[j]) count++;
                j++;
                while (filled[j]) j++;
            }

            result[j] = p;
            filled[j] = true;
        }
    }

    //归并排序的话，浪费空间哎，因为这是二维数组，无关元素太多了，那就快排好了
    //a排序第二个数也要参与排序哎，第一个数排号之后，第一个数相同的数分为一组继续排序
    //哎呀第二个数应该从大到小排序啊~要不在填数 的时候就不好填了
    private void sort(int[][] people, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        int[] cur = people[start];
        while (i < j) {
            while (i < j) {
                //左边第一个数i拿走挖个坑
                //从右边找一个比基准数小的数，填到坑里，坑转移到j
                if (cur[0] > people[j][0] || (cur[0] == people[j][0] && cur[1] < people[j][1])) {
                    break;
                }
                j--;
            }
            if (i < j) {
                //把j位置的数填到i的坑里
                people[i++] = people[j];
            }
            while (i < j) {
                //从左边找个比基准数大的数填到右边的坑里
                if (people[i][0] > cur[0] || (people[i][0] == cur[0] && people[i][1] < cur[1])) {
                    break;
                }
                i++;
            }
            if (i < j) {
                people[j--] = people[i];
            }
        }
        people[i] = cur;
        sort(people, start, i-1);
        sort(people, i+1, end);
    }
}
