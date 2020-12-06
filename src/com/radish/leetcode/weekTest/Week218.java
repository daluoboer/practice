package com.radish.leetcode.weekTest;

/**
 * @author qian zhang
 * @date 2020/12/6 10:35
 */
public class Week218 {
  public static void main(String[] args) {
    Week218 w = new Week218();
    /*int[] ints = {1, 2, 3, 4};
    int i = 5;*/
    /*int[] ints = {3, 1, 3, 4, 3};
    int i = 6;*/
    int[] ints = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
    int i = 2;
    int i1 = w.maxOperations(ints, i);
    System.out.println(i1);
  }

  /**
   * 5617. 设计 Goal 解析器 显示英文描述
   * 通过的用户数508
   * 尝试过的用户数527
   * 用户总通过次数508
   * 用户总提交次数538
   * 题目难度Easy
   * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
   * <p>
   * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：command = "G()(al)"
   * 输出："Goal"
   * 解释：Goal 解析器解释命令的步骤如下所示：
   * G -> G
   * () -> o
   * (al) -> al
   * 最后连接得到的结果是 "Goal"
   * 示例 2：
   * <p>
   * 输入：command = "G()()()()(al)"
   * 输出："Gooooal"
   * 示例 3：
   * <p>
   * 输入：command = "(al)G(al)()()G"
   * 输出："alGalooG"
   * <p>
   * <p>
   * 提示：
   * <p>
   * 1 <= command.length <= 100
   * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
   *
   * @param command
   * @return
   */
  public String interpret(String command) {
    int i = 0;
    StringBuilder res = new StringBuilder();
    while (i < command.length()) {
      if (command.substring(i, i + 1).equals("G")) {
        res.append("G");
        i++;
      } else if (command.substring(i, i + 2).equals("()")) {
        res.append("o");
        i += 2;
      } else {
        res.append("al");
        i += 4;
      }
    }
    return res.toString();
  }

  /**
   * 5618. K 和数对的最大数目 显示英文描述
   * 通过的用户数15
   * 尝试过的用户数21
   * 用户总通过次数15
   * 用户总提交次数23
   * 题目难度Medium
   * 给你一个整数数组 nums 和一个整数 k 。
   * <p>
   * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
   * <p>
   * 返回你可以对数组执行的最大操作数。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [1,2,3,4], k = 5
   * 输出：2
   * 解释：开始时 nums = [1,2,3,4]：
   * - 移出 1 和 4 ，之后 nums = [2,3]
   * - 移出 2 和 3 ，之后 nums = []
   * 不再有和为 5 的数对，因此最多执行 2 次操作。
   * 示例 2：
   * <p>
   * 输入：nums = [3,1,3,4,3], k = 6
   * 输出：1
   * 解释：开始时 nums = [3,1,3,4,3]：
   * - 移出前两个 3 ，之后nums = [1,4,3]
   * 不再有和为 6 的数对，因此最多执行 1 次操作。
   * <p>
   * <p>
   * 提示：
   * <p>
   * 1 <= nums.length <= 105
   * 1 <= nums[i] <= 109
   * 1 <= k <= 109
   *
   * @param nums
   * @param k
   * @return
   */
  public int maxOperations(int[] nums, int k) {
    // 根据一个数去找有没有配对的数，二分？不行没有排序呀，那就直接遍历？或者先排序后遍历？如果排完序就直接从两端查询即可了呀～
    // 排序
    sort(nums, 0, nums.length - 1);
    // 排完序之后再去查询配对，只需要记录上次配到的位置即可，继续往前配对，其实往前配对这个过程也还可以进行二分～
    int res = 0;
    int curJ = nums.length - 1;
    for (int i = 0; i < curJ; i++) {
      if (nums[i] > k - nums[i]) {
        break;
      }
      int j = findLastObject(nums, i + 1, curJ, k - nums[i]);
      if (j > -1) {
        res++;
        curJ = j - 1;
      }
    }
    return res;
  }

  private int findLastObject(int[] nums, int l, int r, int target) {
    // 在l-r之间找到最后一个符合条件的target
    int j = findObject(nums, l, r, target);
    if (j == -1) return j;
    while (j < r && nums[j] == nums[j + 1]) {
      j++;
    }
    return j;
  }

  private int findObject(int[] nums, int l, int r, int target) {
    // 在l-r之间找到target，啊有问题！要找到最后一个符合条件的才行，
    if (l > r) return -1;
    if (target > nums[r] || target < nums[l]) return -1;
    int mid = l + (r - l) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] > target) {
      return findObject(nums, l, mid - 1, target);
    } else {
      return findObject(nums, mid + 1, r, target);
    }
  }

  private void sort(int[] nums, int l, int r) {
    if (l >= r) return;
    // 快排：挖坑填数
    int i = l, j = r;
    int cur = nums[i];
    while (i < j) {
      // 往右找一个<cur的数
      while (i < j && nums[j] > cur) {
        j--;
      }
      if (i < j) {
        nums[i] = nums[j];
        i++;
      }
      // j往左找一个>cur的数
      while (i < j && nums[i] < cur) {
        i++;
      }
      if (i < j) {
        nums[j] = nums[i];
      }
    }
    nums[i] = cur;
    sort(nums, l, i - 1);
    sort(nums, i + 1, r);
  }

  /**
   * 5620. 连接连续二进制数字 显示英文描述
   * 通过的用户数0
   * 尝试过的用户数1
   * 用户总通过次数0
   * 用户总提交次数1
   * 题目难度Medium
   * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：n = 1
   * 输出：1
   * 解释：二进制的 "1" 对应着十进制的 1 。
   * 示例 2：
   * <p>
   * 输入：n = 3
   * 输出：27
   * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
   * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
   * 示例 3：
   * <p>
   * 输入：n = 12
   * 输出：505379714
   * 解释：连接结果为 "1101110010111011110001001101010111100" 。
   * 对应的十进制数字为 118505380540 。
   * 对 109 + 7 取余后，结果为 505379714 。
   * <p>
   * <p>
   * 提示：
   * <p>
   * 1 <= n <= 105
   *
   * @param n
   * @return
   */
  public int concatenatedBinary(int n) {
    return 0;
  }
}
