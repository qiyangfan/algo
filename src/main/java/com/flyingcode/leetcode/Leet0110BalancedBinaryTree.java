package com.flyingcode.leetcode;

import com.flyingcode.structure.TreeNode;

/**
 * 平衡二叉树
 * 该类提供了两种算法, 用于判断给定的二叉树是否是平衡二叉树.
 * 算法采用递归方式实现, 实现了高效的平衡判断.
 */
public class Leet0110BalancedBinaryTree {

  /**
   * 算法设计思路:
   * 1. 平衡二叉树的定义: 每个节点的左右两个子树的高度差的绝对值不超过1
   * 2. 自顶向下法: 对每个节点, 先计算左右子树的高度, 然后判断高度差是否不超过1
   * - 时间复杂度: O(n^2), 最坏情况下需要多次重复计算子树高度
   * - 空间复杂度: O(h), 其中h是树的高度
   * 3. 自底向上法: 后序遍历树, 在计算高度的同时判断是否平衡
   * - 时间复杂度: O(n), 每个节点只被访问一次
   * - 空间复杂度: O(h), 其中h是树的高度
   * - 更高效, 因为避免了重复计算子树高度
   */

  /**
   * 算法复杂度分析:
   * - 自顶向下法:
   * 时间复杂度: O(n^2), 最坏情况下(树为线性)需要计算O(n)次高度, 每次计算O(n)时间
   * 空间复杂度: O(h), 递归调用栈的深度取决于树的高度
   * - 自底向上法:
   * 时间复杂度: O(n), 每个节点只被访问一次
   * 空间复杂度: O(h), 递归调用栈的深度取决于树的高度
   */

  /**
   * 判断给定的二叉树是否是平衡二叉树, 默认使用自底向上法
   *
   * @param root 二叉树的根节点
   * @return 如果二叉树是平衡的返回true, 否则返回false
   */
  public boolean solution(TreeNode root) {
    // 默认使用自底向上法
    return isBalancedBottomUp(root);
  }

  /**
   * 使用自顶向下法判断二叉树是否平衡
   *
   * @param root 二叉树的根节点
   * @return 如果二叉树是平衡的返回true, 否则返回false
   */
  public boolean isBalancedTopDown(TreeNode root) {
    // 空树是平衡的
    if (root == null) {
      return true;
    }
    // 计算左右子树的高度
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    // 判断当前节点是否平衡, 并递归判断左右子树是否平衡
    return Math.abs(leftHeight - rightHeight) <= 1 &&
        isBalancedTopDown(root.left) &&
        isBalancedTopDown(root.right);
  }

  /**
   * 计算二叉树的高度
   *
   * @param root 二叉树的根节点
   * @return 二叉树的高度
   */
  private int getHeight(TreeNode root) {
    // 空树的高度为0
    if (root == null) {
      return 0;
    }
    // 递归计算左右子树的高度, 取较大值加1
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  /**
   * 使用自底向上法判断二叉树是否平衡
   *
   * @param root 二叉树的根节点
   * @return 如果二叉树是平衡的返回true, 否则返回false
   */
  public boolean isBalancedBottomUp(TreeNode root) {
    // 调用辅助方法, 如果返回-1表示不平衡, 否则表示树的高度
    return checkHeight(root) != -1;
  }

  /**
   * 辅助方法: 计算树的高度并判断是否平衡
   *
   * @param root 二叉树的根节点
   * @return 如果树是平衡的返回树的高度, 否则返回-1
   */
  private int checkHeight(TreeNode root) {
    // 空树的高度为0
    if (root == null) {
      return 0;
    }
    // 递归计算左子树的高度
    int leftHeight = checkHeight(root.left);
    // 如果左子树不平衡, 直接返回-1
    if (leftHeight == -1) {
      return -1;
    }
    // 递归计算右子树的高度
    int rightHeight = checkHeight(root.right);
    // 如果右子树不平衡, 直接返回-1
    if (rightHeight == -1) {
      return -1;
    }
    // 判断当前节点是否平衡
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    // 返回当前树的高度
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
