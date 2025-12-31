package com.flyingcode.problem;

/**
 * 井字棋矩阵有效性验证
 * 该类提供一个高效的算法, 用于验证给定的井字棋盘面是否可能在合法游戏中出现.
 * 算法通过检查棋子数量规则和获胜条件来判断盘面的有效性, 实现了O(1)的时间复杂度和空间复杂度.
 */
public class Algo034TicTacToe {

  /**
   * 算法设计思路:
   * 1. 统计盘面中X(1)和O(2)的数量
   * 2. 验证数量规则: X数量必须等于O数量或比O多1
   * 3. 检查X和O是否获胜
   * 4. 验证获胜规则:
   * - 不能同时获胜
   * - X获胜时,X数量必须比O多1
   * - O获胜时,X和O数量必须相等
   * 5. 所有规则通过则返回true, 否则返回false
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(1), 因为井字棋盘面固定为3x3大小, 无论输入如何, 算法执行的操作次数是固定的.
   * 统计棋子数量需要遍历9个格子, 检查获胜情况需要检查3行、3列和2条对角线, 总共14次比较操作, 均为常数级.
   * - 空间复杂度: O(1), 只使用了常数个额外变量存储棋子数量和获胜状态, 不随输入变化.
   */

  /**
   * 验证井字棋盘面是否有效
   *
   * @param board 3x3的整数矩阵, 其中0表示空,1表示X,2表示O
   * @return 如果盘面有效返回true, 否则返回false
   */
  public boolean solution(int[][] board) {
    int xCount = 0;
    int oCount = 0;

    // 统计X和O的数量
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 1) {
          xCount++;
        } else if (cell == 2) {
          oCount++;
        }
      }
    }

    // 检查数量是否符合规则: X数量要么等于O, 要么比O多1
    if (xCount < oCount || xCount > oCount + 1) {
      return false;
    }

    // 检查是否有获胜情况
    boolean xWins = hasWinner(board, 1);
    boolean oWins = hasWinner(board, 2);

    // 不能同时获胜
    if (xWins && oWins) {
      return false;
    }

    // 如果X获胜,X数量必须比O多1(因为X先下, 获胜时必然比O多1个棋子)
    if (xWins && xCount != oCount + 1) {
      return false;
    }

    // 如果O获胜,X和O数量必须相等(因为O后下, 获胜时棋子数量必然相等)
    if (oWins && xCount != oCount) {
      return false;
    }

    // 所有规则通过, 返回true
    return true;
  }

  /**
   * 辅助方法: 检查指定玩家是否获胜
   *
   * @param board  3x3的井字棋盘面
   * @param player 玩家标识,1表示X,2表示O
   * @return 如果该玩家获胜返回true, 否则返回false
   */
  private boolean hasWinner(int[][] board, int player) {
    // 检查行: 遍历3行, 每行检查3个单元格是否相同
    for (int[] row : board) {
      if (row[0] == player && row[1] == player && row[2] == player) {
        return true;
      }
    }

    // 检查列: 遍历3列, 每列检查3个单元格是否相同
    for (int col = 0; col < 3; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    // 检查主对角线: (0,0)、(1,1)、(2,2)
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    // 检查副对角线: (0,2)、(1,1)、(2,0)
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }

    // 所有检查都未通过, 返回false
    return false;
  }
}
