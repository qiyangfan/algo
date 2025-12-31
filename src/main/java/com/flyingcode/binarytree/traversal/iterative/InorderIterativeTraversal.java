package com.flyingcode.binarytree.traversal.iterative;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树中序迭代遍历
 * 该类提供高效的算法，用于实现二叉树的中序遍历。
 * 算法采用迭代技术，使用栈数据结构模拟递归过程，实现了线性时间复杂度和O(n)的空间复杂度。
 */
public class InorderIterativeTraversal {

  /**
   * 算法设计思路：
   * 1. 中序遍历的顺序是左子树 -> 根节点 -> 右子树
   * 2. 使用栈来模拟递归过程，栈的后进先出特性可以确保遍历顺序
   * 3. 初始化当前节点指针为根节点
   * 4. 当栈不为空或当前节点不为null时，循环执行以下操作：
   * a. 将当前节点及其所有左子节点入栈，直到当前节点为null
   * b. 弹出栈顶节点，访问该节点，将节点值加入结果列表
   * c. 将当前节点指针指向弹出节点的右子节点
   * 5. 重复步骤4，直到栈为空且当前节点为null
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点只被访问一次，入栈和出栈操作的时间复杂度是O(1)，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，栈的深度会达到n，因此空间复杂度是O(n)。
   */

  /**
   * 实现二叉树的中序遍历
   *
   * @param root 二叉树的根节点
   * @return 中序遍历的节点值列表
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 使用双端队列作为栈，存储待访问的节点
    Deque<TreeNode> stack = new LinkedList<>();
    // 当前节点指针，初始化为根节点
    TreeNode curr = root;
    // 当栈不为空或当前节点不为null时，继续遍历
    while (curr != null || !stack.isEmpty()) {
      // 将当前节点及其所有左子节点入栈，直到当前节点为null
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // 弹出栈顶节点，访问该节点
      curr = stack.pop();
      // 将节点值加入结果列表
      result.add(curr.val);
      // 将当前节点指针指向弹出节点的右子节点
      curr = curr.right;
    }
    return result;
  }
}
