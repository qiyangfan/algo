package com.flyingcode.problem;

/**
 * 香槟塔算法
 * 该类提供一个高效的算法, 用于计算将指定量的香槟倒入顶层杯子后, 特定位置杯子中的香槟量.
 * 算法采用模拟法, 通过逐层计算香槟的溢出和分配, 实现了线性空间复杂度的解决方案.
 */
public class Algo033ChampagneTower {

  /**
   * 算法设计思路:
   * 1. 初始化一个数组表示顶层杯子, 初始值为倒入的香槟总量
   * 2. 从顶层开始, 逐层向下计算香槟的分布:
   * - 对于当前行的每个杯子, 计算其溢出量(超过1的部分)
   * - 将溢出量平均分配给下一行的两个相邻杯子
   * - 更新下一行对应杯子的香槟量
   * 3. 重复步骤2, 直到计算到目标行
   * 4. 返回目标位置杯子中的香槟量, 确保其不超过1
   *
   * 关键技术点:
   * - 使用一维数组滚动更新, 减少空间复杂度
   * - 仅计算必要的行, 避免不必要的计算
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n*n), 其中 n 是查询的行号 query_row.
   * 因为需要计算从第0行到第query_row-1行, 每行的计算复杂度与行数成正比, 总复杂度为1+2+...+n = O(n*n).
   * - 空间复杂度: O(n).
   * 仅使用两个一维数组, 当前行和下一行, 最大长度为query_row+1, 因此空间复杂度为O(n).
   */

  /**
   * 计算指定位置杯子中的香槟量
   *
   * @param poured     倒入顶层杯子的香槟总量
   * @param queryRow   要查询的行号(从0开始)
   * @param queryGlass 要查询的杯子索引(从0开始)
   * @return 指定位置杯子中的香槟量, 范围在[0, 1]之间
   */
  public double champagneTower(int poured, int queryRow, int queryGlass) {
    // 初始化顶层杯子, 只有一个杯子, 初始值为倒入的香槟总量
    double[] currentRow = { poured };

    // 逐层计算, 直到达到目标行的上一行
    for (int i = 0; i < queryRow; i++) {
      // 创建下一行数组, 长度比当前行多1
      double[] nextRow = new double[i + 2];

      // 遍历当前行的每个杯子
      for (int j = 0; j < currentRow.length; j++) {
        // 计算当前杯子的溢出量, 只有超过1的部分才会溢出
        double overflow = Math.max(0, currentRow[j] - 1);
        // 溢出的香槟平均分配给下一行的两个相邻杯子
        nextRow[j] += overflow / 2;
        nextRow[j + 1] += overflow / 2;
      }

      // 将当前行更新为下一行, 继续计算
      currentRow = nextRow;
    }

    // 返回目标位置的香槟量, 确保不超过1(杯子最多只能装1单位的香槟)
    return Math.min(1, currentRow[queryGlass]);
  }
}
