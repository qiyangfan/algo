package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Leet0226InvertBinaryTree
 * 使用JUnit 5测试翻转二叉树算法的正确性
 */
class Leet0226InvertBinaryTreeTest {

    /**
     * 测试空树: null节点翻转后仍为null
     */
    @Test
    @DisplayName("测试边界条件: 空树翻转后仍为null")
    void testNullTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = null;

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);

        // 验证结果
        assertNull(recursiveResult, "递归法: 空树翻转后应该仍为null");
        assertNull(iterativeResult, "迭代法: 空树翻转后应该仍为null");
        assertNull(solutionResult, "默认solution方法: 空树翻转后应该仍为null");
    }

    /**
     * 测试只有根节点的树: 翻转后仍为根节点
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树翻转后仍为根节点")
    void testSingleRootNode() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);

        // 验证结果
        assertEquals(1, recursiveResult.val, "递归法: 只有根节点的树翻转后值应该不变");
        assertNull(recursiveResult.left, "递归法: 只有根节点的树翻转后左子树应该为null");
        assertNull(recursiveResult.right, "递归法: 只有根节点的树翻转后右子树应该为null");

        assertEquals(1, iterativeResult.val, "迭代法: 只有根节点的树翻转后值应该不变");
        assertNull(iterativeResult.left, "迭代法: 只有根节点的树翻转后左子树应该为null");
        assertNull(iterativeResult.right, "迭代法: 只有根节点的树翻转后右子树应该为null");

        assertEquals(1, solutionResult.val, "默认solution方法: 只有根节点的树翻转后值应该不变");
        assertNull(solutionResult.left, "默认solution方法: 只有根节点的树翻转后左子树应该为null");
        assertNull(solutionResult.right, "默认solution方法: 只有根节点的树翻转后右子树应该为null");
    }

    /**
     * 测试两层二叉树翻转
     * 原始树:        1
     *             /   \
     *            2     3
     * 翻转后:        1
     *             /   \
     *            3     2
     */
    @Test
    @DisplayName("测试基本功能: 两层二叉树翻转后左右子树交换")
    void testTwoLevelBinaryTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 验证递归法结果
        assertEquals(1, recursiveResult.val, "递归法: 根节点值应该不变");
        assertEquals(3, recursiveResult.left.val, "递归法: 左子节点应该变为3");
        assertEquals(2, recursiveResult.right.val, "递归法: 右子节点应该变为2");

        // 重新准备测试数据，因为之前的树已经被修改
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 验证迭代法结果
        assertEquals(1, iterativeResult.val, "迭代法: 根节点值应该不变");
        assertEquals(3, iterativeResult.left.val, "迭代法: 左子节点应该变为3");
        assertEquals(2, iterativeResult.right.val, "迭代法: 右子节点应该变为2");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);
        // 验证默认solution方法结果
        assertEquals(1, solutionResult.val, "默认solution方法: 根节点值应该不变");
        assertEquals(3, solutionResult.left.val, "默认solution方法: 左子节点应该变为3");
        assertEquals(2, solutionResult.right.val, "默认solution方法: 右子节点应该变为2");
    }

    /**
     * 测试三层二叉树翻转
     * 原始树:        1
     *             /   \
     *            2     3
     *           / \   / \
     *          4   5 6   7
     * 翻转后:        1
     *             /   \
     *            3     2
     *           / \   / \
     *          7   6 5   4
     */
    @Test
    @DisplayName("测试基本功能: 三层二叉树翻转后每一层左右子树交换")
    void testThreeLevelBinaryTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 验证递归法结果
        assertEquals(1, recursiveResult.val, "递归法: 根节点值应该不变");
        assertEquals(3, recursiveResult.left.val, "递归法: 左子节点应该变为3");
        assertEquals(2, recursiveResult.right.val, "递归法: 右子节点应该变为2");
        assertEquals(7, recursiveResult.left.left.val, "递归法: 左子节点的左子节点应该变为7");
        assertEquals(6, recursiveResult.left.right.val, "递归法: 左子节点的右子节点应该变为6");
        assertEquals(5, recursiveResult.right.left.val, "递归法: 右子节点的左子节点应该变为5");
        assertEquals(4, recursiveResult.right.right.val, "递归法: 右子节点的右子节点应该变为4");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 验证迭代法结果
        assertEquals(1, iterativeResult.val, "迭代法: 根节点值应该不变");
        assertEquals(3, iterativeResult.left.val, "迭代法: 左子节点应该变为3");
        assertEquals(2, iterativeResult.right.val, "迭代法: 右子节点应该变为2");
        assertEquals(7, iterativeResult.left.left.val, "迭代法: 左子节点的左子节点应该变为7");
        assertEquals(6, iterativeResult.left.right.val, "迭代法: 左子节点的右子节点应该变为6");
        assertEquals(5, iterativeResult.right.left.val, "迭代法: 右子节点的左子节点应该变为5");
        assertEquals(4, iterativeResult.right.right.val, "迭代法: 右子节点的右子节点应该变为4");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);
        // 验证默认solution方法结果
        assertEquals(1, solutionResult.val, "默认solution方法: 根节点值应该不变");
        assertEquals(3, solutionResult.left.val, "默认solution方法: 左子节点应该变为3");
        assertEquals(2, solutionResult.right.val, "默认solution方法: 右子节点应该变为2");
        assertEquals(7, solutionResult.left.left.val, "默认solution方法: 左子节点的左子节点应该变为7");
        assertEquals(6, solutionResult.left.right.val, "默认solution方法: 左子节点的右子节点应该变为6");
        assertEquals(5, solutionResult.right.left.val, "默认solution方法: 右子节点的左子节点应该变为5");
        assertEquals(4, solutionResult.right.right.val, "默认solution方法: 右子节点的右子节点应该变为4");
    }

    /**
     * 测试左斜树翻转
     * 原始树:        1
     *             /
     *            2
     *           /
     *          3
     *         /
     *        4
     * 翻转后:        1
     *              \
     *               2
     *                \
     *                 3
     *                  \
     *                   4
     */
    @Test
    @DisplayName("测试特殊情况: 左斜树翻转后变为右斜树")
    void testLeftSkewedTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 验证递归法结果
        assertEquals(1, recursiveResult.val, "递归法: 根节点值应该不变");
        assertNull(recursiveResult.left, "递归法: 左子节点应该为null");
        assertEquals(2, recursiveResult.right.val, "递归法: 右子节点应该变为2");
        assertNull(recursiveResult.right.left, "递归法: 右子节点的左子节点应该为null");
        assertEquals(3, recursiveResult.right.right.val, "递归法: 右子节点的右子节点应该变为3");
        assertNull(recursiveResult.right.right.left, "递归法: 右子节点的右子节点的左子节点应该为null");
        assertEquals(4, recursiveResult.right.right.right.val, "递归法: 右子节点的右子节点的右子节点应该变为4");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 验证迭代法结果
        assertEquals(1, iterativeResult.val, "迭代法: 根节点值应该不变");
        assertNull(iterativeResult.left, "迭代法: 左子节点应该为null");
        assertEquals(2, iterativeResult.right.val, "迭代法: 右子节点应该变为2");
        assertNull(iterativeResult.right.left, "迭代法: 右子节点的左子节点应该为null");
        assertEquals(3, iterativeResult.right.right.val, "迭代法: 右子节点的右子节点应该变为3");
        assertNull(iterativeResult.right.right.left, "迭代法: 右子节点的右子节点的左子节点应该为null");
        assertEquals(4, iterativeResult.right.right.right.val, "迭代法: 右子节点的右子节点的右子节点应该变为4");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);
        // 验证默认solution方法结果
        assertEquals(1, solutionResult.val, "默认solution方法: 根节点值应该不变");
        assertNull(solutionResult.left, "默认solution方法: 左子节点应该为null");
        assertEquals(2, solutionResult.right.val, "默认solution方法: 右子节点应该变为2");
        assertNull(solutionResult.right.left, "默认solution方法: 右子节点的左子节点应该为null");
        assertEquals(3, solutionResult.right.right.val, "默认solution方法: 右子节点的右子节点应该变为3");
        assertNull(solutionResult.right.right.left, "默认solution方法: 右子节点的右子节点的左子节点应该为null");
        assertEquals(4, solutionResult.right.right.right.val, "默认solution方法: 右子节点的右子节点的右子节点应该变为4");
    }

    /**
     * 测试右斜树翻转
     * 原始树:        1
     *              \
     *               2
     *                \
     *                 3
     *                  \
     *                   4
     * 翻转后:        1
     *             /
     *            2
     *           /
     *          3
     *         /
     *        4
     */
    @Test
    @DisplayName("测试特殊情况: 右斜树翻转后变为左斜树")
    void testRightSkewedTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 验证递归法结果
        assertEquals(1, recursiveResult.val, "递归法: 根节点值应该不变");
        assertEquals(2, recursiveResult.left.val, "递归法: 左子节点应该变为2");
        assertNull(recursiveResult.right, "递归法: 右子节点应该为null");
        assertEquals(3, recursiveResult.left.left.val, "递归法: 左子节点的左子节点应该变为3");
        assertNull(recursiveResult.left.right, "递归法: 左子节点的右子节点应该为null");
        assertEquals(4, recursiveResult.left.left.left.val, "递归法: 左子节点的左子节点的左子节点应该变为4");
        assertNull(recursiveResult.left.left.right, "递归法: 左子节点的左子节点的右子节点应该为null");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 验证迭代法结果
        assertEquals(1, iterativeResult.val, "迭代法: 根节点值应该不变");
        assertEquals(2, iterativeResult.left.val, "迭代法: 左子节点应该变为2");
        assertNull(iterativeResult.right, "迭代法: 右子节点应该为null");
        assertEquals(3, iterativeResult.left.left.val, "迭代法: 左子节点的左子节点应该变为3");
        assertNull(iterativeResult.left.right, "迭代法: 左子节点的右子节点应该为null");
        assertEquals(4, iterativeResult.left.left.left.val, "迭代法: 左子节点的左子节点的左子节点应该变为4");
        assertNull(iterativeResult.left.left.right, "迭代法: 左子节点的左子节点的右子节点应该为null");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        
        // 执行测试方法 - 默认solution方法
        TreeNode solutionResult = algo.solution(root);
        // 验证默认solution方法结果
        assertEquals(1, solutionResult.val, "默认solution方法: 根节点值应该不变");
        assertEquals(2, solutionResult.left.val, "默认solution方法: 左子节点应该变为2");
        assertNull(solutionResult.right, "默认solution方法: 右子节点应该为null");
        assertEquals(3, solutionResult.left.left.val, "默认solution方法: 左子节点的左子节点应该变为3");
        assertNull(solutionResult.left.right, "默认solution方法: 左子节点的右子节点应该为null");
        assertEquals(4, solutionResult.left.left.left.val, "默认solution方法: 左子节点的左子节点的左子节点应该变为4");
        assertNull(solutionResult.left.left.right, "默认solution方法: 左子节点的左子节点的右子节点应该为null");
    }

    /**
     * 测试高度不平衡的树翻转
     * 原始树:        1
     *             /   \
     *            2     3
     *           /     /
     *          4     5
     *         /
     *        6
     * 翻转后:        1
     *             /   \
     *            3     2
     *             \     \
     *              5     4
     *                     \
     *                      6
     */
    @Test
    @DisplayName("测试特殊情况: 高度不平衡的树翻转后结构正确")
    void testUnbalancedTree() {
        // 准备测试数据
        Leet0226InvertBinaryTree algo = new Leet0226InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(5);

        // 执行测试方法 - 递归法
        TreeNode recursiveResult = algo.invertTreeRecursive(root);
        // 验证递归法结果
        assertEquals(1, recursiveResult.val, "递归法: 根节点值应该不变");
        assertEquals(3, recursiveResult.left.val, "递归法: 左子节点应该变为3");
        assertEquals(2, recursiveResult.right.val, "递归法: 右子节点应该变为2");
        assertNull(recursiveResult.left.left, "递归法: 左子节点的左子节点应该为null");
        assertEquals(5, recursiveResult.left.right.val, "递归法: 左子节点的右子节点应该变为5");
        assertNull(recursiveResult.right.left, "递归法: 右子节点的左子节点应该为null");
        assertEquals(4, recursiveResult.right.right.val, "递归法: 右子节点的右子节点应该变为4");
        assertNull(recursiveResult.right.right.left, "递归法: 右子节点的右子节点的左子节点应该为null");
        assertEquals(6, recursiveResult.right.right.right.val, "递归法: 右子节点的右子节点的右子节点应该变为6");

        // 重新准备测试数据
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(5);
        
        // 执行测试方法 - 迭代法
        TreeNode iterativeResult = algo.invertTreeIterative(root);
        // 验证迭代法结果
        assertEquals(1, iterativeResult.val, "迭代法: 根节点值应该不变");
        assertEquals(3, iterativeResult.left.val, "迭代法: 左子节点应该变为3");
        assertEquals(2, iterativeResult.right.val, "迭代法: 右子节点应该变为2");
        assertNull(iterativeResult.left.left, "迭代法: 左子节点的左子节点应该为null");
        assertEquals(5, iterativeResult.left.right.val, "迭代法: 左子节点的右子节点应该变为5");
        assertNull(iterativeResult.right.left, "迭代法: 右子节点的左子节点应该为null");
        assertEquals(4, iterativeResult.right.right.val, "迭代法: 右子节点的右子节点应该变为4");
        assertNull(iterativeResult.right.right.left, "迭代法: 右子节点的右子节点的左子节点应该为null");
        assertEquals(6, iterativeResult.right.right.right.val, "迭代法: 右子节点的右子节点的右子节点应该变为6");
    }
}