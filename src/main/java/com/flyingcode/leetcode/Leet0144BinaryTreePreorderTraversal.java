package com.flyingcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树前序遍历
 * 该类提供两种高效的算法，用于实现二叉树的前序遍历。
 * 算法采用递归和迭代两种技术，均实现了线性时间复杂度，空间复杂度为O(n)。
 */
public class Leet0144BinaryTreePreorderTraversal {

  /**
   * 算法设计思路：
   *
   * 递归实现：
   * 1. 前序遍历的顺序是根节点 -> 左子树 -> 右子树
   * 2. 使用递归实现，先访问根节点，将节点值加入结果列表
   * 3. 然后递归遍历左子树
   * 4. 最后递归遍历右子树
   * 5. 递归终止条件是当前节点为null
   *
   * 迭代实现：
   * 1. 利用栈来模拟递归过程
   * 2. 初始化栈，将根节点入栈
   * 3. 当栈不为空时，循环执行以下操作：
   * a. 弹出栈顶节点，访问该节点，将其值加入结果列表
   * b. 将右子节点入栈（栈是后进先出，所以右子树会在左子树之后被处理）
   * c. 将左子节点入栈
   */

  /**
   * 算法复杂度分析：
   *
   * 递归实现：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点恰好被访问一次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，递归调用栈的深度会达到n，因此空间复杂度是O(n)。
   *
   * 迭代实现：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点恰好被访问一次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，栈的深度会达到n，因此空间复杂度是O(n)。
   */

  /**
   * 实现二叉树的前序遍历
   *
   * @param root 二叉树的根节点
   * @return 前序遍历的节点值列表
   */
  public List<Integer> solution(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 调用递归辅助函数
    preorderTraversal(root, result);
    return result;
  }

  /**
   * 递归辅助函数，用于实现前序遍历
   *
   * @param node   当前遍历的节点
   * @param result 存储遍历结果的列表
   */
  private void preorderTraversal(TreeNode node, List<Integer> result) {
    // 递归终止条件：当前节点为null
    if (node == null) {
      return;
    }
    // 访问根节点，将节点值加入结果列表
    result.add(node.val);
    // 递归遍历左子树
    preorderTraversal(node.left, result);
    // 递归遍历右子树
    preorderTraversal(node.right, result);
  }

  /**
   * 实现二叉树的前序遍历（迭代方法）
   *
   * @param node 二叉树的根节点
   * @return 前序遍历的节点值列表
   */
  public List<Integer> solutionIterative(TreeNode node) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 使用双端队列来模拟递归过程，作为栈使用
    Deque<TreeNode> deque = new LinkedList<>();

    // 如果根节点不为null，将其入队（栈顶）
    if (node != null) {
      deque.push(node);
    }

    // 当队列不为空时继续遍历
    while (!deque.isEmpty()) {
      // 弹出队顶节点（栈顶），访问该节点
      TreeNode curr = deque.pop();
      result.add(curr.val);

      // 先将右子节点入队（栈顶），因为栈是后进先出，所以右子树会在左子树之后被处理
      if (curr.right != null) {
        deque.push(curr.right);
      }

      // 再将左子节点入队（栈顶）
      if (curr.left != null) {
        deque.push(curr.left);
      }
    }

    return result;
  }
}
