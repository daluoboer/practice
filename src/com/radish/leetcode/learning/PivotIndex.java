package com.radish.leetcode.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1:
 *
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 *
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 *
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class PivotIndex {
    public static void main(String[] args) {
//        System.out.println(pivotIndex(new int[]{1, 3, 0, 4}));
//        System.out.println(dominantIndex(new int[]{1,2,3,6,5}));
//        System.out.println(dominantIndex(new int[]{1}));
//        System.out.println(dominantIndex(new int[]{1,0}));
//        System.out.println(dominantIndex(new int[]{0,0,0,1}));
//        System.out.println(dominantIndex(new int[]{0,0,2,3}));
//        System.out.println(dominantIndex(new int[]{3,0,0,2}));
//        System.out.println(dominantIndex(new int[]{0,0,1,2}));
        /*int[] ints = plusOne(new int[]{1,9,9,9});
        for (int i : ints) {
            System.out.println(i);
        }*/
//        int[] diagonalOrder = findDiagonalOrder(new int[][]{{1},{2}});
        /*int[] diagonalOrder = findDiagonalOrder(new int[][]{});
//        int[] diagonalOrder = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int i : diagonalOrder) {
            System.out.println(i);
        }*/
        /*List<Integer> list = spiralOrder(new int[][]{});
        System.out.println(list);*/
        System.out.println(generate(10));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int centerIndex = -1;

        if (nums.length == 0) {
            return centerIndex;
        }

        int sumLeft = 0;
        int sumRight = sum;
        for (int i = 0; i < nums.length; i++) {
            sumRight-=nums[i];
            /*两边相等，两边和必然为偶数*/
            if ((sum - nums[i]) % 2 == 0) {
                if (sumLeft == sumRight) {
                    centerIndex = i;
                    break;
                }
            }
            sumLeft+=nums[i];
        }
        return centerIndex;
    }

    /**
     *   至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     *
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     *
     * 如果是，则返回最大元素的索引，否则返回-1。
     *
     * 示例 1:
     *
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     *
     *
     * 示例 2:
     *
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     *
     *
     * 提示:
     *
     * nums 的长度范围在[1, 50].
     * 每个 nums[i] 的整数范围在 [0, 100].
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int maxIndex = -1;
        int secondMaxIndex = -1;
        if (nums.length >= 2) {
            maxIndex = nums[0] >= nums[1] ? 0 : 1;
            secondMaxIndex = 1 - maxIndex;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[maxIndex]) {
                if (nums[maxIndex] > nums[secondMaxIndex]) {
                    secondMaxIndex = maxIndex;
                }
                maxIndex = i;
            } else if (nums[i] >= nums[secondMaxIndex]) {
                secondMaxIndex = i;
            }
        }

        if (maxIndex == secondMaxIndex || nums[maxIndex] >= nums[secondMaxIndex]*2) {
            return maxIndex;
        }
        return -1;
    }

    /**
     *  加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * 啊！我的妈！居然连long都装不下，看来这个数组不限位数呀，e...那就只能一位一位转啦，不能转化成整数再转化成数组喽
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        /*e...唯一的问题就是进位：
        * 输入[1,2,3],直接末尾加1即可
        * 但是如果输入[9,9,9],那么就要进位
        * 嗷！或者直接将数组转化为数字，再将数字转化为数组！这样就不用担心进位的问题啦
        * */
        if (digits[digits.length-1] < 9) {
            digits[digits.length-1]++;
            return digits;
        }

        /*long curNum = 0;
        for (int i = 0; i < digits.length; i++) {
            curNum += Math.pow(10,digits.length-i-1) * digits[i];
        }
        curNum++;
        int length = String.valueOf(curNum).length();
        int[] a = new int[length];
        for (int i = length-1; i >= 0; i--) {
            a[i] = (int)(curNum%10);
            curNum = curNum/10;
        }
        return a;*/
        /*看看是否要多一位。例如：99*/
        boolean isAdd = true;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] != 9) {
                isAdd = false;
                break;
            }
        }

        int[] a;

        if (isAdd) {//要新建数组
            a = new int[digits.length+1];
            a[0]=1;
            return a;
        } else {//不用新建数组
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    break;
                }
            }
            return digits;
        }
    }

    /**
     *   对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     *
     *
     *
     * 示例:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * 输出:  [1,2,4,7,5,3,6,8,9]
     *
     * 解释:
     *
     *
     *
     * 说明:
     *
     * 给定矩阵中的元素总数不会超过 100000 。
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        /*
        * [1,2]
        * [1,3]
        *
        * */
        /*[0][0]---[1][0],[0][1]---[1][1]*/

        /*当前对角线是往上还是往下*/

        /*往上时，如果y=0说明已经跑到最上面了，应该转换方向：往右挪一个开始往下，y不变，x+1，如果右边已经没有了if(x == matrix[0].length-1),则直接往下一个，x不变，y+1
        * 往下时，如果x=0说明已经跑到最左边，应该转换方向：往下做一个开始往上，x不变，y+1，如果下边已经没有了if(y == matrix.length),直接往右一个，y不变，x+1*/

        if (matrix.length == 0) return new int[0];
        /*只有一个元素*/
        if (matrix.length == 1) return matrix[0];

        int[] a = new int[matrix.length*matrix[0].length];
        boolean up = true;
        int curX = 0;
        int curY = 0;
        int curIndex = 0;
        /*如果没有到最右边*/
        while ((curX <= matrix.length-1) && (curY <= matrix[0].length-1)) {
            a[curIndex++] = matrix[curX][curY];
            if (up) {//当前正在往上走
                /*前俩：两种拐弯的情况*/
                if (curY == matrix[0].length-1) {
                    curX++;
                    up = !up;
                } else if (curX == 0) {
                    curY++;
                    up = !up;
                } else {
                    curX--;
                    curY++;
                }
            } else {//当前正在往下
                if (curX == matrix.length-1) {
                    curY++;
                    up = !up;
                } else if (curY == 0) {
                    curX++;
                    up = !up;
                } else {
                    curX++;
                    curY--;
                }
            }
        }
        return a;
    }


    /**
     * 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     *
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length <= 0) {
            return list;
        }
        /*咦这个好像很简单耶！右--下--左--上*/
        int direction = 0;//0123,分别对应右下左上
        int curX = 0;
        int curY = 0;
        int maxX = matrix.length-1;
        int maxY = matrix[0].length-1;
        int minX = 1;
        int minY = 0;
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        while (left && right && up && down) {
            switch (direction) {
                case 0:
                    if (curY > maxY) {
                        right = false;
                        break;
                    }
                    list.add(matrix[curX][curY]);
                    if (curY == maxY) {
                        maxY--;
                        curX++;
                        direction = 1;
                    } else {
                        curY++;
                    }
                    break;
                case 1:
                    if (curX > maxX) {
                        down = false;
                        break;
                    }
                    list.add(matrix[curX][curY]);
                    if (curX == maxX) {
                        maxX--;
                        curY--;
                        direction = 2;
                    } else {
                        curX++;
                    }
                    break;
                case 2:
                    if (curY < minY) {
                        left = false;
                        break;
                    }
                    list.add(matrix[curX][curY]);
                    if (curY == minY) {
                        minY++;
                        curX--;
                        direction = 3;
                    } else {
                        curY--;
                    }
                    break;
                case 3:
                    if (curX < minX) {
                        up = false;
                        break;
                    }
                    list.add(matrix[curX][curY]);
                    if (curX == minX) {
                        minX++;
                        curY++;
                        direction = 0;
                    } else {
                        curX--;
                    }
                    break;
            }
        }
        return list;
    }


    /**
     *   杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     *
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        int i = 1;
        while (i <= numRows) {
            //这里如果用数组可以少循环一半，因为元素是镜像的
            /*ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i-1) {
                    list.add(1);
                } else {
                    List<Integer> listPre = triangle.get(i - 2);
                    list.add(listPre.get(j-1) + listPre.get(j));
                }
            }
            triangle.add(list);
            i++;*/

            Integer[] ints = new Integer[i];
            for (int j = 0; j < (i+1)/2; j++) {
                if (j == 0) {
                    ints[j] = 1;
                    if (i>1){
                        ints[i-j-1] = 1;
                    }
                } else {
                    List<Integer> list = triangle.get(i - 2);
                    int sum = list.get(j-1)+list.get(j);
                    ints[j] = sum;
                    ints[i-j-1] = sum;
                }
            }
            triangle.add(Arrays.asList(ints));
            i++;
        }
        return triangle;
    }
}
