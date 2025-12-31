package com.flyingcode.problem;

import com.flyingcode.structure.TreeNode;

/**
 * 房屋抢劫问题 - 二叉树版本
 * 该类提供一个使用后序遍历的动态规划算法, 用于解决二叉树结构的房屋抢劫问题.
 * 算法采用动态规划技术, 实现线性时间复杂度和线性空间复杂度.
 */
public class Algo038HouseRobberBinaryTreeDP {

  /**
   * 算法设计思路:
   * 1. 定义状态: 对于每个节点, 有两种状态:
   * a) 不抢劫当前节点: dp[0]
   * b) 抢劫当前节点: dp[1]
   * 2. 状态转移方程:
   * a) 不抢劫当前节点: dp[0] = max(left[0], left[1]) + max(right[0], right[1])
   * - 可以选择抢劫或不抢劫左右子节点, 取最大值之和
   * b) 抢劫当前节点: dp[1] = root.val + left[0] + right[0]
   * - 不能抢劫左右子节点, 只能加上左右子节点不抢劫时的最大金额
   * 3. 遍历顺序: 后序遍历, 从叶子节点开始计算, 逐步向上计算到根节点
   * 4. 初始化: 叶子节点的 dp[0] = 0, dp[1] = root.val
   * 5. 返回结果: max(root[0], root[1]), 即根节点抢劫或不抢劫时的最大金额
   *
   * 关键技术点: 后序遍历, 每个节点返回两种状态, 避免重复计算
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是二叉树中的节点数量.
   * 因为每个节点只需要被访问一次.
   * - 空间复杂度: O(h), 其中 h 是二叉树的高度.
   * 用于递归栈的空间, 最坏情况下二叉树退化为链表, 空间复杂度为 O(n).
   */

  /**
   * 计算二叉树结构房屋抢劫的最大金额
   *
   * @param root 二叉树的根节点, 每个节点代表一个房屋, 节点的值代表该房屋中的金额
   * @return 能够抢劫到的最大金额
   */
  public int solution(TreeNode root) {
    int[] result = robSubtree(root);
    return Math.max(result[0], result[1]);
  }

  /**
   * 计算以当前节点为根的子树的最大抢劫金额
   *
   * @param root 当前子树的根节点
   * @return 长度为2的数组, 其中:
   *         - index 0: 不抢劫当前节点时的最大金额
   *         - index 1: 抢劫当前节点时的最大金额
   */
  private int[] robSubtree(TreeNode root) {
    // 基本情况: 空节点
    if (root == null) {
      return new int[] { 0, 0 };
    }

    // 递归计算左子树
    int[] left = robSubtree(root.left);
    // 递归计算右子树
    int[] right = robSubtree(root.right);

    // 不抢劫当前节点: 可以选择抢劫或不抢劫左右子节点, 取最大值之和
    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // 抢劫当前节点: 不能抢劫左右子节点, 只能加上左右子节点不抢劫时的最大金额
    int rob = root.val + left[0] + right[0];

    // 返回当前节点的两种状态
    return new int[] { notRob, rob };
  }
}
