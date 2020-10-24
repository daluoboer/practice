package com.radish.leetcode.dynamic;

import java.util.*;

/**
 * @Description VideoStitching
 *
 * 1024. 视频拼接
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *
 *
 * 提示：
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 *
 * @Author Radish
 * @Date 2020-10-24 09:26
 */
public class VideoStitching {
    public static void main(String[] args) {
        VideoStitching v = new VideoStitching();
        /*int[][] ints = new int[][]{{0,5},{1,6},{2,7},{3,8},{4,9},{5,10},{6,11},{7,12},{8,13},{9,14},{10,15},{11,16},{12,17},{13,18},{14,19},{15,20},{16,21},{17,22},{18,23},{19,24},{20,25},{21,26},{22,27},{23,28},{24,29},{25,30},{26,31},{27,32},{28,33},{29,34},{30,35},{31,36},{32,37},{33,38},{34,39},{35,40},{36,41},{37,42},{38,43},{39,44},{40,45},{41,46},{42,47},{43,48},{44,49},{45,50},{46,51},{47,52},{48,53},{49,54}};
        int T = 50;*/
        int[][] ints = new int[][]{{0,4},{2,8}};
        int T = 5;
        /*int[][] ints = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int T = 9;*/
        /*int[][] ints = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int T = 10;*/
        /*int[][] ints = new int[][]{{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        int T = 5;*/
        /*int[][] ints = new int[][]{{8,10},{17,39},{18,19},{8,16},{13,35},{33,39},{11,19},{18,35}};
        int T = 20;*/
        /*int[][] ints = new int[][]{{0,1},{1,2}};
        int T = 5;*/
        int i = v.videoStitching(ints, T);
        System.out.println(i);
    }

    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }

        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
    //嗯？？？这动态规划也太简单了吧！但是...答案好像不对啊，先不管了，头疼
    public int videoStitchingDynamic(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i < clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public int videoStitchingMy(int[][] clips, int T) {
        //可以先将所有的视频片段放到一个list中，然后将包含在某一个片段中的片段都移除，因为它们都是短的，最后得到的几个片段，是否包含0-n
        //但是这咋循环呢？如果删除了一个元素，那index就变了啊
        //噢！看每一个元素有没有被别人包含就行啦，没有被别人包含就放到数组中，哎，如果跟别的数范围相同呢？嗯.....就选择第一个吧
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return 0;
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        for (int i = 0; i < clips.length; i++) {
            boolean contained = false;
            for (int j = 0; j < clips.length; j++) {
                if (j != i) {
                    //如果i被j完全包含了，那么continue，如果i和j范围相同，且i>j,continue
                    if (clips[i][0] >= clips[j][0] && clips[i][1] <= clips[j][1]) {//被包含或者等于
                        //被包含，j比i范围广
                        if ((clips[j][1] - clips[j][0]) > (clips[i][1] - clips[i][0])) {
                            contained = true;
                            break;
                        }
                        //范围相同
                        if (i > j) {
                            contained = true;
                            break;
                        }
                    }
                }
            }
            if (!contained)set.add(clips[i]);
        }


        //啊这样不行哎，因为这只算了一个包含另一个的，但是其实还有两个片段包含另一个片段的三个包含另一个的不可能，因为第二个肯定就被包含了，那可以再循环一次，看看是不是相邻的三个是互相包含的关系
        //i,i+1,i+2,其中i和i+2包含了i+1
        List<int[]> list = new ArrayList<>();
        Iterator<int[]> iterator = set.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        int size = list.size();
        removeDuode(list);
        while (size > list.size()) {
            size = list.size();
            removeDuode(list);
        }

        //e...这么处理完还是有哇就是像上面那种abc情况的
        iterator = list.iterator();
        int[] result = null;
        int num = 0;
        if (iterator.hasNext()) {
            result = iterator.next();
            if (result[0] > 0) return -1;
            if (result[1] >= T) return 1;
            num++;
        }
        while (iterator.hasNext()) {
            int[] next = iterator.next();
            num++;
            if (next[0] > result[1]) return -1;
            result[1] = next[1];
            if (result[1] >= T) return num;
        }

        if (result[0] > 0 || result[1] < T) return -1;
        return list.size();
    }

    public boolean contained(int[] a, int[] b, int[] c) {
        if (c[0] <= a[1] && c[1] >= b[1]) {
            return true;
        }
        return false;
    }

    //啊这里不对呀，这光仨仨的搞了，搞一次就放行了，但是不光要这仨一组，还要跟其他的一组啊
    public void removeDuode(List<int[]> list) {
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < list.size() - 2; i++) {
            int[] a = list.get(i);
            int[] b = list.get(i + 1);
            int[] c = list.get(i + 2);
            int cIndex = i + 2;
            while (contained(a,b,c) && cIndex < list.size()) {
                list.remove(b);
                b = c;
//                cIndex++;
                if (cIndex < list.size()) {
                    c = list.get(cIndex);
                }
            }
            set.add(a);
            set.add(b);
            set.add(c);
        }
    }
}
