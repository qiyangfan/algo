package com.flyingcode.leetcode;

import com.flyingcode.structure.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 * 该类提供了两种算法, 用于实现二叉树的翻转.
 * 算法采用递归和迭代两种方式实现, 实现了高效的翻转操作.
 */
public class Leet0226InvertBinaryTree {

    /**
     * 算法设计思路:
     * 1. 翻转二叉树的定义: 交换每个节点的左右子节点
     * 2. 递归法: 利用二叉树的递归特性, 先递归翻转左右子树, 然后交换左右子节点
     *    - 递归终止条件: 节点为null时直接返回
     *    - 递归步骤: 递归翻转左子树, 递归翻转右子树, 交换左右子节点
     * 3. 迭代法: 使用广度优先搜索(BFS)遍历树的每一层, 交换每个节点的左右子节点
     *    - 使用队列存储每一层的节点
     *    - 遍历队列中的每个节点, 交换其左右子节点
     *    - 将子节点加入队列, 继续遍历下一层
     *    - 直到队列为空, 遍历结束
     */

    /**
     * 算法复杂度分析:
     * - 递归法:
     *   时间复杂度: O(n), 其中n是二叉树的节点数量. 每个节点只被访问一次.
     *   空间复杂度: O(h), 其中h是二叉树的高度. 递归调用栈的深度取决于树的高度.
     * - 迭代法:
     *   时间复杂度: O(n), 其中n是二叉树的节点数量. 每个节点只被访问一次.
     *   空间复杂度: O(w), 其中w是二叉树的最大宽度. 队列最多存储一层的节点数.
     */

    /**
     * 翻转给定的二叉树, 默认使用递归法
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树的根节点
     */
    public TreeNode solution(TreeNode root) {
        // 默认使用递归法
        return invertTreeRecursive(root);
    }

    /**
     * 使用递归法翻转二叉树
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树的根节点
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        // 递归终止条件: 节点为null时直接返回
        if (root == null) {
            return null;
        }

        // 递归翻转左子树
        TreeNode left = invertTreeRecursive(root.left);
        // 递归翻转右子树
        TreeNode right = invertTreeRecursive(root.right);

        // 交换左右子节点
        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * 使用迭代法(广度优先搜索)翻转二叉树
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树的根节点
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        // 边界条件处理: 空树直接返回null
        if (root == null) {
            return null;
        }

        // 使用队列存储每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出当前节点
            TreeNode node = queue.poll();

            // 交换左右子节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 将子节点加入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}
