package com.radish.leetcode.game;

/**
 * @Description UpdateBoard
 *
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 *
 * 示例 1：
 *
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 * 示例 2：
 *
 * 输入:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 *
 *
 * 注意：
 *
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 *
 * @Author Radish
 * @Date 2020-08-20 08:46
 */
public class UpdateBoard {
    public static void main(String[] args) {
        char[][] chars = updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (char[] cs : chars) {
            System.out.println();
            for (char c : cs) {
                System.out.print(c + " ");
            }
        }
//        System.out.println((char)(0+'0'));
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        //点击的地雷，只修改地雷M为X
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        }
        if (board[click[0]][click[1]] == 'E') {
            int mineCount = 0;
            //上
            if (click[0]>0) {
                if (board[click[0]-1][click[1]] == 'M') mineCount++;
            }
            //下
            if (click[0]<board.length-1) {
                if (board[click[0]+1][click[1]] == 'M') mineCount++;
            }
            //左
            if (click[1]>0) {
                if (board[click[0]][click[1]-1] == 'M') mineCount++;
            }
            //右
            if (click[1]<board[0].length-1) {
                if (board[click[0]][click[1]+1] == 'M') mineCount++;
            }
            //上左
            if (click[0]>0 && click[1]>0) {
                if (board[click[0]-1][click[1]-1] == 'M') mineCount++;
            }
            //上右
            if (click[0]>0 && click[1]<board[0].length-1) {
                if (board[click[0]-1][click[1]+1] == 'M') mineCount++;
            }
            //下左
            if (click[0]<board.length-1 && click[1]>0) {
                if (board[click[0]+1][click[1]-1] == 'M') mineCount++;
            }
            //下右
            if (click[0]<board.length-1 && click[1]<board[0].length-1) {
                if (board[click[0]+1][click[1]+1] == 'M') mineCount++;
            }
            //点击的周围有地雷的空方块，将E改为周围地雷的数量
            if (mineCount > 0) {
                String s = String.valueOf(mineCount);
                char c = s.charAt(0);
                board[click[0]][click[1]] = c;
            } else {
                board[click[0]][click[1]] = 'B';
                //上
                if (click[0]>0) {
                    if (board[click[0]-1][click[1]] == 'E') updateBoard(board, new int[]{click[0]-1,click[1]});
                }
                //下
                if (click[0]<board.length-1) {
                    if (board[click[0]+1][click[1]] == 'E') updateBoard(board, new int[]{click[0]+1,click[1]});
                }
                //左
                if (click[1]>0) {
                    if (board[click[0]][click[1]-1] == 'E') updateBoard(board, new int[]{click[0],click[1]-1});
                }
                //右
                if (click[1]<board[0].length-1) {
                    if (board[click[0]][click[1]+1] == 'E') updateBoard(board, new int[]{click[0],click[1]+1});
                }
                //上左
                if (click[0]>0 && click[1]>0) {
                    if (board[click[0]-1][click[1]-1] == 'E') updateBoard(board, new int[]{click[0]-1,click[1]-1});
                }
                //上右
                if (click[0]>0 && click[1]<board[0].length-1) {
                    if (board[click[0]-1][click[1]+1] == 'E') updateBoard(board, new int[]{click[0]-1,click[1]+1});
                }
                //下左
                if (click[0]<board.length-1 && click[1]>0) {
                    if (board[click[0]+1][click[1]-1] == 'E') updateBoard(board, new int[]{click[0]+1,click[1]-1});
                }
                //下右
                if (click[0]<board.length-1 && click[1]<board[0].length-1) {
                    if (board[click[0]+1][click[1]+1] == 'E') updateBoard(board, new int[]{click[0]+1,click[1]+1});
                }
            }
            //点击的周围没有地雷的空方块，将E改为B，与它相邻的未挖出方块被递归地揭露
        }
        return board;
    }
}
