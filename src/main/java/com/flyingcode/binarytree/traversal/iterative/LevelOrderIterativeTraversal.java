package com.flyingcode.binarytree.traversal.iterative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树层次迭代遍历
 * 该类提供高效的算法，用于实现二叉树的层次遍历。
 * 算法采用迭代技术，使用队列数据结构按层访问节点，实现了线性时间复杂度和O(n)的空间复杂度。
 */
public class LevelOrderIterativeTraversal {

  /**
   * 算法设计思路：
   * 1. 层次遍历的顺序是按层从上到下，每层从左到右
   * 2. 使用队列来存储待访问的节点，队列的先进先出特性可以确保按层访问
   * 3. 初始化时将根节点入队
   * 4. 当队列不为空时，循环执行以下操作：
   * a. 记录当前队列的大小（即当前层的节点数量）
   * b. 遍历当前层的所有节点：
   * i. 出队一个节点，访问该节点，将节点值加入结果列表
   * ii. 将该节点的左子节点入队（如果不为null）
   * iii. 将该节点的右子节点入队（如果不为null）
   * 5. 重复步骤4，直到队列为空
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点只被访问一次，入队和出队操作的时间复杂度是O(1)，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是满二叉树时，队列中最多同时存储n/2个节点，因此空间复杂度是O(n)。
   */

  /**
   * 实现二叉树的层次遍历
   *
   * @param root 二叉树的根节点
   * @return 层次遍历的节点值列表
   */
  public List<Integer> levelOrderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 如果根节点为null，直接返回空列表
    if (root == null) {
      return result;
    }
    // 使用队列存储待访问的节点
    Queue<TreeNode> queue = new LinkedList<>();
    // 将根节点入队
    queue.offer(root);
    // 当队列不为空时，继续遍历
    while (!queue.isEmpty()) {
      // 记录当前队列的大小，即当前层的节点数量
      int levelSize = queue.size();
      // 遍历当前层的所有节点
      for (int i = 0; i < levelSize; i++) {
        // 出队一个节点，访问该节点
        TreeNode curr = queue.poll();
        // 将节点值加入结果列表
        result.add(curr.val);
        // 将左子节点入队（如果不为null）
        if (curr.left != null) {
          queue.offer(curr.left);
        }
        // 将右子节点入队（如果不为null）
        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }
    return result;
  }
}
