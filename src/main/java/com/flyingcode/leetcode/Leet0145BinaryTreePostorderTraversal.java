package com.flyingcode.leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树后序遍历
 * 该类提供两种高效的算法，用于实现二叉树的后序遍历。
 * 算法采用递归和迭代两种技术，均实现了线性时间复杂度，空间复杂度为O(n)。
 */
public class Leet0145BinaryTreePostorderTraversal {

  /**
   * 算法设计思路：
   *
   * 递归实现：
   * 1. 后序遍历的顺序是左子树 -> 右子树 -> 根节点
   * 2. 使用递归实现，先递归遍历左子树
   * 3. 然后递归遍历右子树
   * 4. 最后访问根节点，将节点值加入结果列表
   * 5. 递归终止条件是当前节点为null
   *
   * 迭代实现：
   * 1. 利用栈来模拟递归过程，存储节点和其访问状态
   * 2. 初始化栈，将根节点入栈，标记为未访问
   * 3. 当栈不为空时，循环执行以下操作：
   * a. 弹出栈顶节点和其访问状态
   * b. 如果节点已访问，将其值加入结果列表
   * c. 如果节点未访问，按照后序遍历的逆序重新入栈：
   * i. 根节点（标记为已访问）
   * ii. 右子节点（标记为未访问）
   * iii. 左子节点（标记为未访问）
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
   * 每个节点恰好被访问两次（入栈和出栈），因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，栈的深度会达到n，因此空间复杂度是O(n)。
   */

  /**
   * 实现二叉树的后序遍历
   *
   * @param root 二叉树的根节点
   * @return 后序遍历的节点值列表
   */
  public List<Integer> solution(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 调用递归辅助函数
    postorderTraversal(root, result);
    return result;
  }

  /**
   * 递归辅助函数，用于实现后序遍历
   *
   * @param node   当前遍历的节点
   * @param result 存储遍历结果的列表
   */
  private void postorderTraversal(TreeNode node, List<Integer> result) {
    // 递归终止条件：当前节点为null
    if (node == null) {
      return;
    }
    // 递归遍历左子树
    postorderTraversal(node.left, result);
    // 递归遍历右子树
    postorderTraversal(node.right, result);
    // 访问根节点，将节点值加入结果列表
    result.add(node.val);
  }

  /**
   * 实现二叉树的后序遍历（迭代方法）
   *
   * @param node 二叉树的根节点
   * @return 后序遍历的节点值列表
   */
  public List<Integer> solutionIterative(TreeNode node) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 使用双端队列来模拟递归过程，作为栈使用，存储节点和其访问状态
    Deque<Map.Entry<TreeNode, Boolean>> deque = new LinkedList<>();

    // 如果根节点不为null，将其入队（栈顶），标记为未访问
    if (node != null) {
      deque.push(new AbstractMap.SimpleEntry<>(node, false));
    }

    // 当队列不为空时继续遍历
    while (!deque.isEmpty()) {
      // 弹出队顶节点（栈顶）和其访问状态
      Map.Entry<TreeNode, Boolean> entry = deque.pop();
      TreeNode curr = entry.getKey();
      boolean visited = entry.getValue();

      if (visited) {
        // 如果节点已访问，将其值加入结果列表
        result.add(curr.val);
      } else {
        // 如果节点未访问，按照后序遍历的逆序将节点重新入队（栈顶）：根节点（标记为已访问）、右子节点（标记为未访问）、左子节点（标记为未访问）
        deque.push(new AbstractMap.SimpleEntry<>(curr, true));

        // 右子节点入队（栈顶），标记为未访问
        if (curr.right != null) {
          deque.push(new AbstractMap.SimpleEntry<>(curr.right, false));
        }

        // 左子节点入队（栈顶），标记为未访问
        if (curr.left != null) {
          deque.push(new AbstractMap.SimpleEntry<>(curr.left, false));
        }
      }
    }

    return result;
  }
}
