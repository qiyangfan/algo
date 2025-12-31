package com.flyingcode.binarytree.traversal.iterative;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树后序迭代遍历
 * 该类提供高效的算法，用于实现二叉树的后序遍历。
 * 算法采用迭代技术，使用栈数据结构模拟递归过程，并使用访问状态标记来区分首次访问和二次访问，实现了线性时间复杂度和O(n)的空间复杂度。
 */
public class PostorderIterativeTraversal {

  /**
   * 算法设计思路：
   * 1. 后序遍历的顺序是左子树 -> 右子树 -> 根节点
   * 2. 使用栈来模拟递归过程，栈中存储节点和访问状态（是否已访问）
   * 3. 初始化时将根节点入栈，标记为未访问
   * 4. 当栈不为空时，循环执行以下操作：
   * a. 弹出栈顶元素，获取当前节点和访问状态
   * b. 如果节点已访问，将节点值加入结果列表
   * c. 如果节点未访问，重新将节点入栈，标记为已访问，然后将右子节点入栈（标记为未访问），最后将左子节点入栈（标记为未访问）
   * 5. 重复步骤4，直到栈为空
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点被入栈和出栈各两次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(n)。
   * 最坏情况下，当二叉树是一条链时，栈的深度会达到n，因此空间复杂度是O(n)。
   */

  /**
   * 实现二叉树的后序遍历
   *
   * @param root 二叉树的根节点
   * @return 后序遍历的节点值列表
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 如果根节点为null，直接返回空列表
    if (root == null) {
      return result;
    }
    // 使用双端队列作为栈，存储节点和访问状态
    Deque<Map.Entry<TreeNode, Boolean>> stack = new LinkedList<>();
    // 将根节点入栈，标记为未访问
    stack.push(new AbstractMap.SimpleEntry<>(root, false));
    // 当栈不为空时，继续遍历
    while (!stack.isEmpty()) {
      // 弹出栈顶元素，获取当前节点和访问状态
      Map.Entry<TreeNode, Boolean> entry = stack.pop();
      TreeNode curr = entry.getKey();
      boolean visited = entry.getValue();
      // 如果节点已访问，将节点值加入结果列表
      if (visited) {
        result.add(curr.val);
      } else {
        // 重新将节点入栈，标记为已访问
        stack.push(new AbstractMap.SimpleEntry<>(curr, true));
        // 将右子节点入栈，标记为未访问（因为栈是后进先出，所以右子节点先入栈，左子节点后入栈，这样左子节点会先被访问）
        if (curr.right != null) {
          stack.push(new AbstractMap.SimpleEntry<>(curr.right, false));
        }
        // 将左子节点入栈，标记为未访问
        if (curr.left != null) {
          stack.push(new AbstractMap.SimpleEntry<>(curr.left, false));
        }
      }
    }
    return result;
  }
}
