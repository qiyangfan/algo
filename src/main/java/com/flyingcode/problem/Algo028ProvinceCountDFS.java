package com.flyingcode.problem;

/**
 * 省份数量计算 - 深度优先搜索实现
 *
 * 该类提供了基于深度优先搜索(DFS)算法的省份数量计算解决方案, 通过图的连通分量识别实现省份统计.
 *
 * 问题描述: 给定n个城市和它们的连接关系矩阵, 直接或间接相连的城市形成一个省份, 需要计算省份的总数量.
 *
 * 核心思想: 将城市连接关系建模为无向图, 省份对应图中的连通分量, 使用DFS遍历统计连通分量的个数.
 *
 * 算法特点:
 * - 递归实现简洁直观, 空间复杂度为O(n)
 * - 适用于中等规模的图结构和图的连通性问题
 * - 应用场景包括朋友圈数量统计和网络分组识别
 *
 */
public class Algo028ProvinceCountDFS {

  /**
   * 算法设计思路:
   *
   * 1. 图建模: 将城市连接关系建模为无向图, 输入矩阵使用邻接矩阵表示图的边连接关系
   * 2. 连通分量识别: 省份对应图中的连通分量, 每个连通分量内的城市直接或间接相连, 形成一个独立省份
   * 3. DFS遍历策略: 对每个未访问的节点启动DFS, 递归访问其所有可达的相邻节点
   * 4. 访问标记机制: 使用boolean数组记录每个节点的访问状态, 防止重复访问和死循环
   * 5. 省份计数: 每启动一次新的DFS遍历, 说明发现了一个新的连通分量, 省份计数加1
   */

  /**
   * 算法复杂度分析:
   *
   * - 时间复杂度: O(n*n), 其中n是城市的数量
   * 外层循环遍历所有n个城市, 每次DFS在最坏情况下需要访问所有城市并检查连接关系
   * 由于使用邻接矩阵表示图, 检查每条边的连接状态需要O(1)时间, 总共需要检查n*n个可能的连接
   * 因此总体时间复杂度为O(n^2), 适用于中等规模的图结构
   *
   * - 空间复杂度: O(n), 主要用于存储访问标记数组和DFS递归调用栈
   * 访问标记数组visited占用O(n)空间记录n个城市的访问状态
   * DFS递归调用栈在最坏情况下(如线性连通的图)深度为O(n)
   * 因此总体空间复杂度为O(n), 不包括输入矩阵的存储空间
   */

  /**
   * 计算省份数量, 使用深度优先搜索(DFS)算法统计图中连通分量的个数.
   *
   * <p>
   * 该方法通过遍历所有城市, 对每个未访问的城市启动DFS遍历,
   * 每次新的DFS启动代表发现一个新的省份(连通分量).
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

    // 遍历所有城市, 对每个未访问的城市启动DFS遍历
    for (int i = 0; i < cityCount; i++) {
      // 如果城市i未被访问, 说明它属于一个新的连通分量(省份)
      if (!visited[i]) {
        // 启动DFS遍历, 标记该省份内的所有城市为已访问
        dfs(isConnected, visited, i);
        // 每完成一次DFS, 发现一个新的省份, 计数加1
        provinceCount++;
      }
    }

    return provinceCount;
  }

  /**
   * 深度优先搜索(DFS)辅助方法, 递归遍历与当前城市直接或间接相连的所有城市.
   *
   * 该方法标记当前城市为已访问, 然后递归访问所有与当前城市直接相连
   * 且未被访问的城市, 从而遍历整个连通分量.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @param visited     访问标记数组, 用于记录每个城市是否被访问过, 避免重复访问和死循环
   * @param city        当前正在访问的城市索引, 范围为[0, n-1]
   */
  private void dfs(int[][] isConnected, boolean[] visited, int city) {
    // 标记当前城市为已访问, 防止后续重复访问
    visited[city] = true;

    // 遍历所有其他城市, 查找与当前城市直接相连且未被访问的城市
    for (int i = 0; i < isConnected.length; i++) {
      // 如果城市i与当前城市直接相连(isConnected[city][i] == 1)
      // 且城市i尚未被访问(!visited[i]), 则递归访问城市i
      if (isConnected[city][i] == 1 && !visited[i]) {
        dfs(isConnected, visited, i);
      }
    }
    // 递归返回后, 所有与当前城市直接或间接相连的城市都已被标记为访问
  }
}
