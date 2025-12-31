package com.flyingcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Dota2参议院问题
 * 该类提供一个双队列贪心算法, 用于计算Dota2参议院的最终胜利方.
 * 算法采用两个队列分别存储不同阵营参议员的索引位置, 通过比较索引大小模拟投票顺序, 实现高效的胜利方预测.
 */
public class Algo039Dota2SenateGreedy {

  /**
   * 算法设计思路:
   * 1. 初始化两个队列, 分别存储Radiant('R')和Dire('D')阵营参议员的索引位置
   * 2. 模拟投票过程, 每次从两个队列各取出一个参议员的索引
   * 3. 比较索引大小, 索引较小的参议员先发言
   * 4. 先发言的参议员禁言对方一名参议员, 并将自己的索引加上轮次长度重新入队, 进入下一轮投票
   * 5. 当其中一个队列为空时, 另一队获胜
   *
   * 关键技术点:
   * - 使用索引大小表示发言顺序, 较小索引代表较早发言
   * - 通过索引+轮次长度的方式, 实现参议员的下一轮投票资格
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中n是参议员的数量.
   * 每个参议员最多入队和出队一次, 总操作次数是线性的.
   * - 空间复杂度: O(n).
   * 需要两个队列存储所有参议员的索引位置.
   */

  /**
   * 计算Dota2参议院的最终胜利方
   *
   * @param senate 参议员的字符串表示, 其中 'R' 代表 Radiant 方, 'D' 代表 Dire 方
   * @return 最终胜利方, 若 Radiant 方胜利则返回 "Radiant", 若 Dire 方胜利则返回 "Dire"
   */
  public String solution(String senate) {
    int n = senate.length();
    Queue<Integer> radiantQueue = new LinkedList<>();
    Queue<Integer> direQueue = new LinkedList<>();

    // 初始化队列, 存储各个参议员的索引位置
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') {
        radiantQueue.offer(i);
      } else {
        direQueue.offer(i);
      }
    }

    // 模拟多轮投票过程, 直到一方阵营的参议员全部被禁言
    while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
      // 取出当前轮次双方阵营最先发言的参议员索引
      int radiantIndex = radiantQueue.poll();
      int direIndex = direQueue.poll();

      // 索引较小的参议员先发言
      if (radiantIndex < direIndex) {
        // R先发言, 禁言D, R获得下一轮投票资格
        // 通过加上n, 确保下一轮的索引仍然大于当前轮次的所有索引
        radiantQueue.offer(radiantIndex + n);
      } else {
        // D先发言, 禁言R, D获得下一轮投票资格
        direQueue.offer(direIndex + n);
      }
    }

    // 队列不为空的一方获胜
    return radiantQueue.isEmpty() ? "Dire" : "Radiant";
  }
}
