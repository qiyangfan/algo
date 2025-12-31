package com.flyingcode.binarytree.traversal.recursive;

import java.util.ArrayList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树前序递归遍历
 * 该类提供高效的算法，用于实现二叉树的前序遍历。
 * 算法采用递归技术，实现了线性时间复杂度和O(h)的空间复杂度。
 */
public class PreorderRecursiveTraversal {

  /**
   * 算法设计思路：
   * 1. 前序遍历的顺序是根节点 -> 左子树 -> 右子树
   * 2. 使用递归实现，先访问根节点，将节点值加入结果列表
   * 3. 然后递归遍历左子树
   * 4. 最后递归遍历右子树
   * 5. 递归终止条件是当前节点为null
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点只被访问一次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(h)，其中h是二叉树的高度。
   * 递归调用栈的深度取决于树的高度，最坏情况下(树为线性)空间复杂度为O(n)。
   */

  /**
   * 实现二叉树的前序遍历
   *
   * @param root 二叉树的根节点
   * @return 前序遍历的节点值列表
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 调用递归辅助函数
    preorderTraversalRecursive(root, result);
    return result;
  }

  /**
   * 递归辅助函数，用于实现前序遍历
   *
   * @param node   当前遍历的节点
   * @param result 存储遍历结果的列表
   */
  private void preorderTraversalRecursive(TreeNode node, List<Integer> result) {
    // 递归终止条件：当前节点为null
    if (node == null) {
      return;
    }
    // 访问根节点，将节点值加入结果列表
    result.add(node.val);
    // 递归遍历左子树
    preorderTraversalRecursive(node.left, result);
    // 递归遍历右子树
    preorderTraversalRecursive(node.right, result);
  }
}
