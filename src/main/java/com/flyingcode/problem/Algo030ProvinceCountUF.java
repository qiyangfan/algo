package com.flyingcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 省份数量
 * 该类提供一个使用并查集(Union-Find)算法来计算省份数量的解决方案.
 * 算法通过合并相连的城市到同一个连通分量, 最终统计独立的连通分量数量,
 * 即省份数量. 采用路径压缩和按秩合并两种优化技术, 提高了算法的效率.
 *
 * 算法设计思路:
 * 1. 初始化并查集数据结构, 每个城市的父节点初始指向自身, 秩(树高度)初始为1
 * 2. 遍历所有城市, 对每个未访问的城市启动广度优先搜索
 * 3. 在搜索过程中, 对所有与当前城市直接相连的未访问城市执行并查集合并操作
 * 4. 使用按秩合并策略: 将较矮的树连接到较高的树, 保持树的高度较小
 * 5. 使用路径压缩优化: 在查找根节点时, 将节点直接连接到根节点, 减少后续查找时间
 * 6. 每发现一个未访问的城市, 省份计数器加1
 * 7. 最终返回省份计数器, 即连通分量的数量
 *
 * 算法复杂度分析:
 * - 时间复杂度: O(n^2 * α(n)), 其中 n 是城市的数量, α(n) 是反Ackermann函数.
 *   外层循环遍历所有城市(O(n)), 内层BFS访问所有相连城市(O(n^2)),
 *   并查集操作接近O(1)因为α(n)增长极慢(对于所有实际n, α(n) ≤ 5).
 * - 空间复杂度: O(n), 使用了三个长度为n的数组(visited, parent, rank),
 *   以及一个最坏情况下可能存储n个城市的队列.
 */
public class Algo030ProvinceCountUF {
  /**
   * 计算省份数量, 使用并查集(Union-Find)算法统计图中连通分量的个数.
   *
   * 该方法通过遍历所有城市, 对每个未访问的城市启动并查集合并操作,
   * 合并所有与当前城市直接或间接相连的城市, 最终统计并查集中独立的根节点数量,
   * 即省份数量.
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @return 省份数量, 即图中连通分量的个数
   */
  public int solution(int[][] isConnected) {
    // 边界条件检查: 空矩阵或null输入直接返回0个省份
    if (isConnected == null || isConnected.length == 0) {
      return 0;
    }

    // 城市数量
    int cityCount = isConnected.length;
    // 访问标记数组, 用于记录每个城市是否被访问过, 避免重复访问和死循环
    boolean[] visited = new boolean[cityCount];
    // 并查集数组, 用于存储每个城市所属的连通分量(省份)
    int[] parent = new int[cityCount];
    // 秩数组, 用于存储每个连通分量的树高度, 优化合并操作
    int[] rank = new int[cityCount];
    // 初始化并查集和秩数组, 每个城市的父节点设为自身, 秩设为1
    for (int i = 0; i < cityCount; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    // 省份数量计数器
    int provinceCount = 0;
    // 遍历所有城市
    for (int i = 0; i < cityCount; i++) {
      // 如果城市i未被访问, 则启动新的并查集合并操作
      if (!visited[i]) {
        // 标记当前城市为已访问
        visited[i] = true;
        // 从城市i开始, 进行并查集合并, 标记所有与i直接或间接相连的城市为已访问
        unionFind(isConnected, visited, parent, rank, i);
        // 增加省份计数器, 表示发现了一个新的省份
        provinceCount++;
      }
    }
    // 返回最终的省份数量
    return provinceCount;
  }

  /**
   * 查找元素的根节点, 并进行路径压缩优化.
   *
   * 路径压缩: 在查找过程中, 将每个节点直接连接到其根节点, 减少后续查找的路径长度.
   *
   * @param parent 并查集数组, 存储每个元素的父节点
   * @param city   要查找的城市索引
   * @return 该城市所属连通分量的根节点索引
   */
  private int find(int[] parent, int city) {
    // 路径压缩优化: 迭代查找根节点并将当前节点直接连接到根节点
    // 找到根节点
    int root = city;
    while (parent[root] != root) {
      root = parent[root];
    }
    // 路径压缩: 将所有节点直接连接到根节点
    while (parent[city] != root) {
      int parentNode = parent[city];
      parent[city] = root;
      city = parentNode;
    }
    return root;
  }

  /**
   * 将两个城市合并到同一个连通分量中, 并使用按秩合并优化.
   *
   * 按秩合并: 总是将较矮的树连接到较高的树的根节点, 保持树的高度较小.
   *
   * @param parent 并查集数组, 存储每个元素的父节点
   * @param city1  第一个城市索引
   * @param city2  第二个城市索引
   * @param rank   秩数组, 存储每个连通分量的树高度
   */
  private void union(int[] parent, int city1, int city2, int[] rank) {
    int root1 = find(parent, city1);
    int root2 = find(parent, city2);

    // 如果已经是同一个根节点, 则不需要合并
    if (root1 == root2) {
      return;
    }

    // 按秩合并: 将较矮的树连接到较高的树的根节点
    if (rank[root1] < rank[root2]) {
      parent[root1] = root2;
    } else {
      parent[root2] = root1;
      // 如果秩相等, 合并后根节点的秩加1
      if (rank[root1] == rank[root2]) {
        rank[root1]++;
      }
    }
  }

  /**
   * 并查集合并操作辅助方法, 使用广度优先搜索合并与当前城市直接或间接相连的所有城市.
   *
   * 该方法使用队列迭代实现广度优先搜索, 从当前城市开始, 遍历所有与当前城市
   * 直接或间接相连的城市, 如果城市未被访问, 则将其标记为已访问, 并将其加入
   * 当前城市的连通分量(省份).
   *
   * @param isConnected 表示城市之间连接关系的n*n维邻接矩阵
   * @param visited     访问标记数组, 用于记录每个城市是否被访问过, 避免重复访问和死循环
   * @param parent      并查集数组, 用于存储每个城市所属的连通分量(省份)
   * @param rank        秩数组, 用于存储每个连通分量的树高度, 优化合并操作
   * @param city        当前正在访问的城市索引, 范围为[0, n-1], 作为并查集合并的起始点
   */
  private void unionFind(int[][] isConnected, boolean[] visited, int[] parent, int[] rank, int city) {
    // 使用队列存储待处理的城市, 迭代实现广度优先搜索
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(city);

    // 遍历队列中的所有城市
    while (!queue.isEmpty()) {
      int currentCity = queue.poll();
      // 遍历所有与当前城市直接相连的城市
      for (int i = 0; i < isConnected.length; i++) {
        // 如果城市j与当前城市直接相连, 且未被访问
        if (isConnected[currentCity][i] == 1 && !visited[i]) {
          // 标记城市i为已访问
          visited[i] = true;
          // 将城市i加入当前城市的连通分量(省份)
          union(parent, currentCity, i, rank);
          // 将城市i加入队列, 继续处理其直接相连的城市
          queue.offer(i);
        }
      }
    }
  }

}
