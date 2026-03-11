package com.flyingcode.problem;

/**
 * 省份数量 - DFS版本
 * 使用深度优先搜索统计图中连通分量的个数.
 *
 * 算法设计思路:
 * 1. 初始化一个visited数组，用于记录每个城市是否已被访问过
 * 2. 遍历所有城市，遇到未访问的城市时，省份计数器加1
 * 3. 从该城市出发，使用DFS递归遍历所有直接或间接相连的城市，并标记为已访问
 * 4. 继续遍历，直到所有城市都被访问过
 * 5. 最终返回省份计数器的值
 *
 * 算法复杂度分析:
 * - 时间复杂度: O(n^2)，其中n是城市数量。外层循环遍历所有城市(O(n))，
 *   内层DFS最坏情况需要遍历邻接矩阵的所有元素(O(n^2))。
 * - 空间复杂度: O(n)，用于visited数组和递归调用栈。
 *
 * 与海岛题对比:
 * - 解法思路完全一致: 遍历 → 未访问？计数+1 → DFS标记整块
 * - 唯一区别: 找邻居的方式不同（省份靠邻接矩阵判断，海岛靠空间相邻）
 * - 代码结构高度相似，便于统一记忆
 */
public class Algo030ProvinceCountDFS {

  /**
   * 计算省份数量，使用深度优先搜索统计图中连通分量的个数.
   *
   * 该方法通过遍历所有城市，对每个未访问的城市启动DFS递归遍历，
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
        // 从城市i开始进行DFS递归遍历，标记所有与i直接或间接相连的城市为已访问
        dfs(isConnected, visited, i);
        // 省份计数器加1，表示发现了一个新的省份
        provinceCount++;
      }
    }

    // 返回最终的省份数量
    return provinceCount;
  }

  /**
   * 使用深度优先搜索(DFS)递归标记与起始城市直接或间接相连的所有城市为已访问.
   *
   * 该方法通过递归实现深度优先搜索，从当前城市开始，
   * 遍历所有与当前城市直接相连的邻居，如果邻居未被访问，
   * 则将其标记为已访问，并递归处理其相连的城市.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @param visited     访问标记数组，用于记录每个城市是否被访问过
   * @param city        当前正在处理的城市索引，范围为[0, n-1]
   */
  private void dfs(int[][] isConnected, boolean[] visited, int city) {
    // 遍历所有可能的城市，寻找与当前城市直接相连的邻居
    for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
      // 判断条件: 城市neighbor与当前城市city直接相连，且neighbor未被访问过
      if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
        // 标记邻居城市为已访问，避免重复访问
        visited[neighbor] = true;
        // 递归处理邻居城市，继续深度搜索
        dfs(isConnected, visited, neighbor);
      }
    }
  }

}
