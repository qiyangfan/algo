package com.flyingcode.search;

/**
 * 树表查找
 * 该类提供一个基于二叉搜索树的树表查找算法，用于在整数数组中查找目标值.
 * 算法将数组构建为二叉搜索树，然后在树中进行查找，平均时间复杂度为 O(log n)，空间复杂度为 O(n).
 */
public class TreeTableSearch {

  /**
   * 算法设计思路:
   * 1. 将输入数组构建为二叉搜索树
   * 2. 在二叉搜索树中查找目标值:
   * a. 从根节点开始查找
   * b. 如果当前节点值等于目标值，返回当前节点值
   * c. 如果当前节点值大于目标值，在左子树中查找
   * d. 如果当前节点值小于目标值，在右子树中查找
   * e. 如果到达叶子节点仍未找到，返回-1
   *
   * 关键技术点:
   * - 二叉搜索树: 左子树所有节点值小于根节点，右子树所有节点值大于根节点
   * - 递归构建: 递归方式构建二叉搜索树
   * - 递归查找: 递归方式在二叉搜索树中查找目标值
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n)，其中 n 是数组的长度.
   * 构建二叉搜索树需要遍历整个数组，时间复杂度为 O(n)
   * 查找操作的平均时间复杂度为 O(log n)，最坏情况下为 O(n)（树退化为链表时）
   * - 空间复杂度: O(n).
   * 需要额外的二叉搜索树存储空间，大小与数组长度相当
   */

  /**
   * 二叉搜索树的节点结构
   */
  private static class TreeNode {
    int value; // 节点值
    TreeNode left; // 左子节点
    TreeNode right; // 右子节点

    TreeNode(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  /**
   * 在整数数组中查找目标值的索引
   *
   * @param arr    输入的整数数组，用于构建二叉搜索树
   * @param target 要查找的目标值
   * @return 如果找到目标值，返回目标值；否则返回-1
   */
  public int search(int[] arr, int target) {
    // 边界条件处理: 空数组或null数组直接返回-1
    if (arr == null || arr.length == 0) {
      return -1;
    }

    // 构建二叉搜索树
    TreeNode root = buildBST(arr);

    // 在二叉搜索树中查找目标值
    TreeNode resultNode = searchBST(root, target);

    // 如果找到，返回目标值；否则返回-1
    return resultNode != null ? resultNode.value : -1;
  }

  /**
   * 构建二叉搜索树
   *
   * @param arr 输入的整数数组
   * @return 构建好的二叉搜索树的根节点
   */
  private TreeNode buildBST(int[] arr) {
    // 创建根节点
    TreeNode root = new TreeNode(arr[0]);

    // 遍历数组，将剩余元素插入到二叉搜索树中
    for (int i = 1; i < arr.length; i++) {
      insertIntoBST(root, arr[i]);
    }

    return root;
  }

  /**
   * 将元素插入到二叉搜索树中
   *
   * @param root  二叉搜索树的根节点
   * @param value 要插入的元素值
   */
  private void insertIntoBST(TreeNode root, int value) {
    // 如果当前节点值大于要插入的值，插入到左子树
    if (root.value > value) {
      if (root.left == null) {
        root.left = new TreeNode(value);
      } else {
        insertIntoBST(root.left, value);
      }
    }
    // 如果当前节点值小于要插入的值，插入到右子树
    else if (root.value < value) {
      if (root.right == null) {
        root.right = new TreeNode(value);
      } else {
        insertIntoBST(root.right, value);
      }
    }
    // 如果当前节点值等于要插入的值，不进行插入（二叉搜索树中不允许重复值）
  }

  /**
   * 在二叉搜索树中查找目标值
   *
   * @param root   二叉搜索树的根节点
   * @param target 要查找的目标值
   * @return 如果找到，返回对应的节点；否则返回null
   */
  private TreeNode searchBST(TreeNode root, int target) {
    // 如果当前节点为null，返回null
    if (root == null) {
      return null;
    }

    // 如果当前节点值等于目标值，返回当前节点
    if (root.value == target) {
      return root;
    }
    // 如果当前节点值大于目标值，在左子树中查找
    else if (root.value > target) {
      return searchBST(root.left, target);
    }
    // 如果当前节点值小于目标值，在右子树中查找
    else {
      return searchBST(root.right, target);
    }
  }
}
