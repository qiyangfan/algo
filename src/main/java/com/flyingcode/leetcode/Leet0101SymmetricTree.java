package com.flyingcode.leetcode;

import com.flyingcode.structure.TreeNode;

/**
 * 对称二叉树
 * 该类提供一个高效的算法, 用于判断给定的二叉树是否是对称的.
 * 算法采用递归技术, 实现了O(n)的时间复杂度和O(h)的空间复杂度.
 */
public class Leet0101SymmetricTree {

    /**
     * 算法设计思路:
     * 1. 对称二叉树的定义是: 对于树中任意两个对称节点, 它们的值相等, 且一个节点的左子树与另一个节点的右子树对称
     * 2. 递归的核心思想是比较树的左右子树是否对称
     * 3. 递归终止条件: 两个节点都为null时对称; 其中一个为null或值不相等时不对称
     * 4. 递归步骤: 比较左节点的左子树与右节点的右子树, 同时比较左节点的右子树与右节点的左子树
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O(n), 其中n是二叉树的节点数量.
     *   因为每个节点只被访问一次, 递归遍历整个树.
     * - 空间复杂度: O(h), 其中h是二叉树的高度.
     *   递归调用栈的深度取决于树的高度, 最坏情况下(树为线性)空间复杂度为O(n).
     */

    /**
     * 判断给定的二叉树是否是对称的
     *
     * @param root 二叉树的根节点
     * @return 如果二叉树是对称的返回true, 否则返回false
     */
    public boolean solution(TreeNode root) {
        // 边界条件处理: 空树是对称的
        if (root == null) {
            return true;
        }
        // 调用辅助方法比较左右子树是否对称
        return isSymmetric(root.left, root.right);
    }

    /**
     * 辅助方法: 比较两个节点是否对称
     *
     * @param left 左子树节点
     * @param right 右子树节点
     * @return 如果两个节点对称返回true, 否则返回false
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 递归终止条件1: 两个节点都为null, 对称
        if (left == null && right == null) {
            return true;
        }
        // 递归终止条件2: 其中一个节点为null或值不相等, 不对称
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 递归比较: 左节点的左子树与右节点的右子树, 左节点的右子树与右节点的左子树
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
