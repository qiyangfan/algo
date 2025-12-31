package com.flyingcode.leetcode;

import com.flyingcode.structure.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 该类提供了两种算法, 用于计算给定二叉树的最大深度.
 * 算法采用递归和迭代两种方式实现, 实现了高效的深度计算.
 */
public class Leet0104MaximumDepthOfBinaryTree {

  /**
   * 算法设计思路:
   * 1. 递归法: 利用二叉树的递归特性, 树的最大深度等于左右子树的最大深度加1
   * - 递归终止条件: 节点为null时深度为0
   * - 递归步骤: 分别计算左子树和右子树的最大深度, 取较大值加1
   * 2. 迭代法: 使用广度优先搜索(BFS)遍历树的每一层, 记录层数
   * - 使用队列存储每一层的节点
   * - 每遍历完一层, 深度加1
   * - 直到队列为空, 遍历结束
   */

  /**
   * 算法复杂度分析:
   * - 递归法:
   * 时间复杂度: O(n), 其中n是二叉树的节点数量. 因为每个节点只被访问一次.
   * 空间复杂度: O(h), 其中h是二叉树的高度. 递归调用栈的深度取决于树的高度, 最坏情况下(树为线性)空间复杂度为O(n).
   * - 迭代法:
   * 时间复杂度: O(n), 其中n是二叉树的节点数量. 因为每个节点只被访问一次.
   * 空间复杂度: O(w), 其中w是二叉树的最大宽度. 队列最多存储一层的节点数, 最坏情况下(满二叉树)空间复杂度为O(n/2).
   */

  /**
   * 计算给定二叉树的最大深度, 默认使用递归法
   *
   * @param root 二叉树的根节点
   * @return 二叉树的最大深度
   */
  public int solution(TreeNode root) {
    // 默认使用递归法
    return maxDepthRecursive(root);
  }

  /**
     * 使用递归法计算二叉树的最大深度
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度
     */
    public int maxDepthRecursive(TreeNode root) {
        // 递归终止条件: 节点为null时深度为0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树的最大深度
        int leftDepth = maxDepthRecursive(root.left);
        // 递归计算右子树的最大深度
        int rightDepth = maxDepthRecursive(root.right);
        // 树的最大深度等于左右子树的最大深度加1
        return Math.max(leftDepth, rightDepth) + 1;
    }

  /**
     * 使用迭代法(广度优先搜索)计算二叉树的最大深度
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度
     */
    public int maxDepthIterative(TreeNode root) {
        // 边界条件处理: 空树深度为0
        if (root == null) {
            return 0;
        }

        // 使用队列存储每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int levelSize = queue.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 将子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 每遍历完一层, 深度加1
            depth++;
        }

        return depth;
    }
}
