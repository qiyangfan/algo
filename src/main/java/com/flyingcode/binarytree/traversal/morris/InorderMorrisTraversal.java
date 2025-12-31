package com.flyingcode.binarytree.traversal.morris;

import java.util.ArrayList;
import java.util.List;

import com.flyingcode.structure.TreeNode;

/**
 * 二叉树中序Morris遍历
 * 该类提供高效的算法，用于实现二叉树的中序遍历。
 * 算法采用Morris遍历技术，无需递归和栈，通过修改树的结构（添加线索）来实现O(n)的时间复杂度和O(1)的空间复杂度。
 */
public class InorderMorrisTraversal {

  /**
   * 算法设计思路：
   * 1. 中序遍历的顺序是左子树 -> 根节点 -> 右子树
   * 2. Morris遍历的核心思想是利用树中大量空闲指针，临时将叶子节点的右指针指向遍历路径上的下一个节点，形成线索
   * 3. 对于当前节点curr，执行以下操作：
   * a. 如果curr的左子节点为空，访问curr，将curr指向其右子节点
   * b. 如果curr的左子节点不为空，找到curr左子树的最右节点predecessor：
   * i. 如果predecessor的右子节点为空，将其右子节点指向curr，将curr指向其左子节点
   * ii. 如果predecessor的右子节点指向curr，说明左子树已遍历完毕，访问curr，将其右子节点恢复为空，将curr指向其右子节点
   * 4. 重复步骤3，直到curr为空
   */

  /**
   * 算法复杂度分析：
   * - 时间复杂度：O(n)，其中n是二叉树的节点数量。
   * 每个节点最多被访问两次，因此总时间复杂度是线性的。
   * - 空间复杂度：O(1)。
   * 只使用了常数个额外变量，无需递归和栈，因此空间复杂度是常数级的。
   */

  /**
   * 实现二叉树的中序Morris遍历
   *
   * @param root 二叉树的根节点
   * @return 中序遍历的节点值列表
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    // 初始化结果列表
    List<Integer> result = new ArrayList<>();
    // 当前节点指针，初始化为根节点
    TreeNode curr = root;
    // 当当前节点不为null时，继续遍历
    while (curr != null) {
      // 如果当前节点的左子节点为空，访问当前节点，然后将当前节点指向其右子节点
      if (curr.left == null) {
        // 访问当前节点，将节点值加入结果列表
        result.add(curr.val);
        // 将当前节点指向其右子节点
        curr = curr.right;
      } else {
        // 找到当前节点左子树的最右节点（前驱节点）
        TreeNode predecessor = curr.left;
        // 循环查找最右节点，直到predecessor的右子节点为空或指向当前节点
        while (predecessor.right != null && predecessor.right != curr) {
          predecessor = predecessor.right;
        }
        // 如果前驱节点的右子节点为空，将其右子节点指向当前节点，然后将当前节点指向其左子节点
        if (predecessor.right == null) {
          // 将前驱节点的右子节点指向当前节点，建立线索
          predecessor.right = curr;
          // 将当前节点指向其左子节点
          curr = curr.left;
        } else {
          // 如果前驱节点的右子节点指向当前节点，说明左子树已遍历完毕，访问当前节点，将其右子节点恢复为空，然后将当前节点指向其右子节点
          // 访问当前节点，将节点值加入结果列表
          result.add(curr.val);
          // 将前驱节点的右子节点恢复为空，删除线索
          predecessor.right = null;
          // 将当前节点指向其右子节点
          curr = curr.right;
        }
      }
    }
    return result;
  }
}
