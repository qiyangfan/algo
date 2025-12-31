package com.flyingcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 省份数量计算 - 广度优先搜索实现
 *
 * 该类提供了基于广度优先搜索(BFS)算法的省份数量计算解决方案, 通过图的连通分量识别实现省份统计.
 *
 * 问题描述: 给定n个城市和它们的连接关系矩阵, 直接或间接相连的城市形成一个省份, 需要计算省份的总数量.
 *
 * 核心思想: 将城市连接关系建模为无向图, 省份对应图中的连通分量, 使用BFS遍历统计连通分量的个数.
 *
 * 算法特点:
 * - 迭代实现基于队列, 避免递归栈溢出风险, 空间复杂度为O(n)
 * - 适用于大规模图结构和图的连通性问题
 * - 应用场景包括朋友圈数量统计和网络分组识别
 *
 */
public class Algo029ProvinceCountBFS {

  /**
   * 算法设计思路:
   *
   * 1. 图建模: 将城市连接关系建模为无向图, 输入矩阵使用邻接矩阵表示图的边连接关系
   * 2. 连通分量识别: 省份对应图中的连通分量, 每个连通分量内的城市直接或间接相连, 形成一个独立省份
   * 3. BFS遍历策略: 对每个未访问的节点启动BFS, 使用队列逐层访问其所有可达的相邻节点
   * 4. 访问标记机制: 使用boolean数组记录每个节点的访问状态, 防止重复访问和死循环
   * 5. 省份计数: 每启动一次新的BFS遍历, 说明发现了一个新的连通分量, 省份计数加1
   */

  /**
   * 算法复杂度分析:
   *
   * - 时间复杂度: O(n*n), 其中n是城市的数量
   * 外层循环遍历所有n个城市, 每次BFS在最坏情况下需要访问所有城市并检查连接关系
   * 由于使用邻接矩阵表示图, 检查每条边的连接状态需要O(1)时间, 总共需要检查n*n个可能的连接
   * 因此总体时间复杂度为O(n^2), 适用于中等规模的图结构
   *
   * - 空间复杂度: O(n), 主要用于存储访问标记数组和BFS队列
   * 访问标记数组visited占用O(n)空间记录n个城市的访问状态
   * BFS队列在最坏情况下(如完全连通的图)需要存储O(n)个节点
   * 因此总体空间复杂度为O(n), 不包括输入矩阵的存储空间
   */
  /**
   * 计算省份数量, 使用广度优先搜索(BFS)算法统计图中连通分量的个数.
   *
   * 该方法通过遍历所有城市, 对每个未访问的城市启动BFS遍历,
   * 每次新的BFS启动代表发现一个新的省份(连通分量).
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   *                    isConnected[i][j] = 1 表示城市i和城市j直接相连
   *                    isConnected[i][j] = 0 表示城市i和城市j不直接相连
   *                    矩阵是对称的, 即isConnected[i][j] = isConnected[j][i]
   * @return 省份的数量, 即图中连通分量的个数, 范围为[0, n]
   * @throws NullPointerException 如果输入矩阵为null
   */
  public int solution(int[][] isConnected) {
    // 边界条件检查: 空矩阵或null输入直接返回0个省份
    if (isConnected == null || isConnected.length == 0) {
      return 0;
    }

    // 初始化省份计数器和城市数量
    int provinceCount = 0;
    int cityCount = isConnected.length;

    // 创建访问标记数组, 记录每个城市是否已被访问过
    // 初始值全为false, 表示所有城市都未被访问
    boolean[] visited = new boolean[cityCount];

    // 遍历所有城市, 对每个未访问的城市启动BFS遍历
    for (int i = 0; i < cityCount; i++) {
      // 如果城市i未被访问, 则启动新的BFS遍历
      if (!visited[i]) {
        // 从城市i开始, 进行BFS遍历, 标记所有与i直接或间接相连的城市为已访问
        bfs(isConnected, visited, i);

        // 增加省份计数器, 表示发现了一个新的省份
        provinceCount++;
      }
    }

    // 返回最终的省份数量
    return provinceCount;
  }

  /**
   * 广度优先搜索(BFS)辅助方法, 迭代遍历与当前城市直接或间接相连的所有城市.
   *
   * 该方法使用队列实现BFS, 从起始城市开始逐层向外扩展,
   * 访问所有与当前城市直接或间接相连的城市, 从而遍历整个连通分量.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @param visited     访问标记数组, 用于记录每个城市是否被访问过, 避免重复访问和死循环
   * @param city        当前正在访问的城市索引, 范围为[0, n-1], 作为BFS遍历的起始点
   */
  private void bfs(int[][] isConnected, boolean[] visited, int city) {
    // 创建队列, 用于存储待访问的城市
    Queue<Integer> queue = new LinkedList<>();

    // 将当前城市加入队列, 开始BFS遍历
    queue.offer(city);

    // 当队列不为空时, 继续遍历
    while (!queue.isEmpty()) {
      // 从队列头部取出一个城市, 进行访问
      int currentCity = queue.poll();

      // 遍历所有其他城市, 查找与当前城市直接相连且未被访问的城市
      for (int i = 0; i < isConnected.length; i++) {
        // 如果城市i与当前城市直接相连(isConnected[currentCity][i] == 1)
        // 且城市i尚未被访问(!visited[i]), 则将城市i加入队列, 准备后续访问
        if (isConnected[currentCity][i] == 1 && !visited[i]) {
          queue.offer(i);
          // 标记城市i为已访问, 防止重复访问
          visited[i] = true;
        }
      }
    }
    // 当队列空时, 说明当前连通分量(省份)的所有城市都已被访问
  }
}
