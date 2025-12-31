package com.flyingcode.binarytree.traversal.iterative;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树前序迭代遍历
 * 该类提供高效的算法，用于实现二叉树的前序遍历。
 * 算法采用迭代技术，使用栈数据结构模拟递归过程，实现了线性时间复杂度和O(n)的空间复杂度。
 */
public class PreorderIterativeTraversal {

  /**
   * 算法设计思路：
   * 1. 前序遍历的顺序是根节点 -> 左子树 -> 右子树
   * 2. 使用栈来模拟递归过程，栈的后进先出特性可以确保遍历顺序
   * 3. 将根节点入栈，然后循环执行以下操作：
   * a. 弹出栈顶节点，访问该节点，将节点值加入结果列表
   * b. 将右子节点入栈（因为栈是后进先出，所以右子节点先入栈，左子节点后入栈，这样左子节点会先被访问）
   * c. 将左子节点入栈
   * 4. 重复步骤3，直到栈为空
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点只被访问一次，入栈和出栈操作的时间复杂度是O(1)，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，栈的深度会达到n，因此空间复杂度是O(n)。
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
    // 如果根节点为null，直接返回空列表
    if (root == null) {
      return result;
    }
    // 使用双端队列作为栈，存储待访问的节点
    Deque<TreeNode> stack = new LinkedList<>();
    // 将根节点入栈
    stack.push(root);
    // 当栈不为空时，继续遍历
    while (!stack.isEmpty()) {
      // 弹出栈顶节点，访问该节点
      TreeNode curr = stack.pop();
      // 将节点值加入结果列表
      result.add(curr.val);
      // 先将右子节点入栈，因为栈是后进先出，所以右子树会在左子树之后被处理
      if (curr.right != null) {
        stack.push(curr.right);
      }
      // 再将左子节点入栈
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
    return result;
  }
}
