package com.flyingcode.binarytree.traversal.morris;

import java.util.ArrayList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树后序Morris遍历
 * 该类提供高效的算法，用于实现二叉树的后序遍历。
 * 算法采用Morris遍历技术，无需递归和栈，通过修改树的结构（添加线索）来实现O(n)的时间复杂度和O(1)的空间复杂度。
 */
public class PostorderMorrisTraversal {

  /**
   * 算法设计思路：
   * 1. 后序遍历的顺序是左子树 -> 右子树 -> 根节点
   * 2. Morris后序遍历的核心是通过建立和删除线索，利用空闲指针实现遍历
   * 3. 对于每个节点，我们先处理左子树，然后右子树，最后访问当前节点
   * 4. 当左子树处理完成后，我们逆序输出从当前节点的左子节点到其前驱节点的路径
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点最多被访问三次，逆序过程的时间复杂度为O(n)，因此总时间复杂度是线性的。
   * - 空间复杂度：O(1)。
   * 只使用了常数个额外变量，无需递归和栈，因此空间复杂度是常数级的。
   */

  /**
   * 实现二叉树的后序Morris遍历
   *
   * @param root 二叉树的根节点
   * @return 后序遍历的节点值列表
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 当前节点指针
    TreeNode curr = root;

    // 当当前节点不为null时，继续遍历
    while (curr != null) {
      // 如果当前节点的右子节点为空，访问当前节点，然后将当前节点指向其左子节点
      if (curr.right == null) {
        result.add(curr.val);
        curr = curr.left;
      } else {
        // 找到当前节点右子树的最左节点（后继节点）
        TreeNode successor = curr.right;
        while (successor.left != null && successor.left != curr) {
          successor = successor.left;
        }
        // 如果后继节点的左子节点为空，将其左子节点指向当前节点，访问当前节点，然后将当前节点指向其右子节点
        if (successor.left == null) {
          result.add(curr.val);
          successor.left = curr;
          curr = curr.right;
        } else {
          // 如果后继节点的左子节点指向当前节点，将其左子节点恢复为空，然后将当前节点指向其左子节点
          successor.left = null;
          curr = curr.left;
        }
      }
    }
    // 最后需要反转整个结果列表，因为上面的遍历顺序是根->右->左，反转后得到左->右->根
    reverseList(result);
    return result;
  }

  /**
   * 反转列表
   *
   * @param list 要反转的列表
   */
  private void reverseList(List<Integer> list) {
    int left = 0;
    int right = list.size() - 1;
    while (left < right) {
      int temp = list.get(left);
      list.set(left, list.get(right));
      list.set(right, temp);
      left++;
      right--;
    }
  }
}
