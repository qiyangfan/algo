package com.flyingcode.binarytree.traversal.recursive;

import java.util.ArrayList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树层次递归遍历
 * 该类提供高效的算法，用于实现二叉树的层次遍历。
 * 算法采用递归技术，实现了线性时间复杂度和O(h)的空间复杂度。
 */
public class LevelOrderRecursiveTraversal {

  /**
   * 算法设计思路：
   * 1. 层次遍历的顺序是按层从上到下，每层从左到右
   * 2. 使用递归实现，需要先计算树的高度
   * 3. 从第1层到最大高度，逐层递归遍历
   * 4. 每层遍历函数负责访问该层的所有节点
   * 5. 递归终止条件是当前层数超过树的高度
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点只被访问一次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(h)，其中h是二叉树的高度。
   * 递归调用栈的深度取决于树的高度，最坏情况下(树为线性)空间复杂度为O(n)。
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
    // 计算树的高度
    int height = getTreeHeight(root);
    // 从第1层到最大高度，逐层递归遍历
    for (int level = 1; level <= height; level++) {
      levelOrderTraversalRecursive(root, level, result);
    }
    return result;
  }

  /**
   * 递归辅助函数，用于实现层次遍历
   *
   * @param node   当前遍历的节点
   * @param level  当前遍历的层数
   * @param result 存储遍历结果的列表
   */
  private void levelOrderTraversalRecursive(TreeNode node, int level, List<Integer> result) {
    // 递归终止条件：当前节点为null或当前层数小于1
    if (node == null || level < 1) {
      return;
    }
    // 当层数为1时，访问当前节点
    if (level == 1) {
      result.add(node.val);
    } else {
      // 递归遍历下一层的左子树
      levelOrderTraversalRecursive(node.left, level - 1, result);
      // 递归遍历下一层的右子树
      levelOrderTraversalRecursive(node.right, level - 1, result);
    }
  }

  /**
   * 计算二叉树的高度
   *
   * @param root 二叉树的根节点
   * @return 二叉树的高度
   */
  private int getTreeHeight(TreeNode root) {
    // 空树的高度为0
    if (root == null) {
      return 0;
    }
    // 递归计算左子树的高度
    int leftHeight = getTreeHeight(root.left);
    // 递归计算右子树的高度
    int rightHeight = getTreeHeight(root.right);
    // 树的高度为左右子树高度的最大值加1
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
