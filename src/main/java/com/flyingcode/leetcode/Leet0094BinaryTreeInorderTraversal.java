package com.flyingcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树中序遍历
 * 该类提供两种高效的算法，用于实现二叉树的中序遍历。
 * 算法采用递归和迭代两种技术，均实现了线性时间复杂度，空间复杂度为O(n)。
 */
public class Leet0094BinaryTreeInorderTraversal {

  /**
   * 算法设计思路：
   *
   * 递归实现：
   * 1. 中序遍历的顺序是左子树 -> 根节点 -> 右子树
   * 2. 使用递归实现，先递归遍历左子树
   * 3. 访问根节点，将节点值加入结果列表
   * 4. 最后递归遍历右子树
   * 5. 递归终止条件是当前节点为null
   *
   * 迭代实现：
   * 1. 利用栈来模拟递归过程
   * 2. 初始化当前节点指针为根节点
   * 3. 当栈不为空或当前节点不为null时，循环执行以下操作：
   * a. 遍历左子树，将所有左节点入栈，直到当前节点为null
   * b. 弹出栈顶节点，访问该节点，将其值加入结果列表
   * c. 将当前节点指针指向右子节点
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
   * 实现二叉树的中序遍历
   *
   * @param root 二叉树的根节点
   * @return 中序遍历的节点值列表
   */
  public List<Integer> solution(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 调用递归辅助函数
    inorderTraversal(root, result);
    return result;
  }

  /**
   * 递归辅助函数，用于实现中序遍历
   *
   * @param node   当前遍历的节点
   * @param result 存储遍历结果的列表
   */
  private void inorderTraversal(TreeNode node, List<Integer> result) {
    // 递归终止条件：当前节点为null
    if (node == null) {
      return;
    }
    // 递归遍历左子树
    inorderTraversal(node.left, result);
    // 访问根节点，将节点值加入结果列表
    result.add(node.val);
    // 递归遍历右子树
    inorderTraversal(node.right, result);
  }

  /**
   * 使用迭代法实现二叉树的中序遍历
   *
   * @param root 二叉树的根节点
   * @return 中序遍历的节点值列表
   */
  public List<Integer> inorderTraversalIterative(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 使用双端队列来模拟递归过程，作为栈使用
    Deque<TreeNode> deque = new LinkedList<>();
    // 当前节点指针
    TreeNode curr = root;

    // 当队列不为空或当前节点不为null时继续遍历
    while (curr != null || !deque.isEmpty()) {
      // 遍历左子树，将所有左节点入队（栈顶）
      while (curr != null) {
        deque.push(curr);
        curr = curr.left;
      }

      // 弹出队顶节点（栈顶），访问该节点
      curr = deque.pop();
      result.add(curr.val);

      // 遍历右子树
      curr = curr.right;
    }

    return result;
  }
}
