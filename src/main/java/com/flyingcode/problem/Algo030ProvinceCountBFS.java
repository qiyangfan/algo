package com.flyingcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 省份数量 - BFS简化版
 * 使用广度优先搜索统计图中连通分量的个数.
 *
 * 算法设计思路:
 * 1. 初始化一个visited数组，用于记录每个城市是否已被访问过
 * 2. 遍历所有城市，遇到未访问的城市时，省份计数器加1
 * 3. 从该城市出发，使用BFS遍历所有直接或间接相连的城市，并标记为已访问
 * 4. 继续遍历，直到所有城市都被访问过
 * 5. 最终返回省份计数器的值
 *
 * 算法复杂度分析:
 * - 时间复杂度: O(n^2)，其中n是城市数量。外层循环遍历所有城市(O(n))，
 *   内层BFS最坏情况需要遍历邻接矩阵的所有元素(O(n^2))。
 * - 空间复杂度: O(n)，用于visited数组和队列，最坏情况下队列可能存储n个城市。
 *
 * 与原版对比:
 * - 移除了冗余的并查集数据结构(parent数组和rank数组)
 * - 只用visited数组标记访问状态，逻辑更清晰
 * - 与海岛题(Lc0200NumberOfIslands)的解法思路完全一致
 */
public class Algo030ProvinceCountBFS {

  /**
   * 计算省份数量，使用广度优先搜索统计图中连通分量的个数.
   *
   * 该方法通过遍历所有城市，对每个未访问的城市启动BFS遍历，
   * 标记所有与当前城市直接或间接相连的城市为已访问，
   * 最终统计发现的新连通分量数量，即省份数量.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵，
   *                    isConnected[i][j] = 1 表示城市i和城市j直接相连，
   *                    isConnected[i][j] = 0 表示不相连
   * @return 省份数量，即图中连通分量的个数
   */
  public int solution(int[][] isConnected) {
    // 边界条件检查: 空矩阵或null输入直接返回0个省份
    if (isConnected == null || isConnected.length == 0) {
      return 0;
    }

    // 城市数量
    int n = isConnected.length;
    // 访问标记数组，用于记录每个城市是否被访问过，避免重复访问和死循环
    boolean[] visited = new boolean[n];
    // 省份数量计数器
    int provinceCount = 0;

    // 遍历所有城市
    for (int i = 0; i < n; i++) {
      // 如果城市i未被访问，则发现了一个新的省份
      if (!visited[i]) {
        // 从城市i开始进行BFS遍历，标记所有与i直接或间接相连的城市为已访问
        bfs(isConnected, visited, i);
        // 省份计数器加1，表示发现了一个新的省份
        provinceCount++;
      }
    }

    // 返回最终的省份数量
    return provinceCount;
  }

  /**
   * 使用广度优先搜索(BFS)标记与起始城市直接或间接相连的所有城市为已访问.
   *
   * 该方法使用队列迭代实现广度优先搜索，从起始城市开始，
   * 遍历所有与当前城市直接相连的城市，如果城市未被访问，
   * 则将其标记为已访问，并加入队列继续处理其相连的城市.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @param visited     访问标记数组，用于记录每个城市是否被访问过
   * @param start       起始城市索引，范围为[0, n-1]，作为BFS遍历的起始点
   */
  private void bfs(int[][] isConnected, boolean[] visited, int start) {
    // 使用队列存储待处理的城市，实现广度优先搜索
    Queue<Integer> queue = new LinkedList<>();
    // 将起始城市加入队列
    queue.offer(start);
    // 标记起始城市为已访问
    visited[start] = true;

    // 遍历队列中的所有城市，直到队列为空
    while (!queue.isEmpty()) {
      // 取出队列头部的城市
      int city = queue.poll();

      // 遍历所有可能的城市，寻找与当前城市直接相连的邻居
      for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
        // 判断条件: 城市neighbor与当前城市city直接相连，且neighbor未被访问过
        if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
          // 标记邻居城市为已访问，避免重复访问
          visited[neighbor] = true;
          // 将邻居城市加入队列，继续处理其相连的城市
          queue.offer(neighbor);
        }
      }
    }
    // 当队列遍历完毕，所有与起始城市直接或间接相连的城市都已被标记为已访问
  }

}
