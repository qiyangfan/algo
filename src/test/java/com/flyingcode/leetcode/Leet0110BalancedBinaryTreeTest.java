package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Leet0110BalancedBinaryTree
 * 使用JUnit 5测试平衡二叉树算法的正确性
 */
class Leet0110BalancedBinaryTreeTest {

    /**
     * 测试空树: null节点应该是平衡的
     */
    @Test
    @DisplayName("测试边界条件: 空树应该返回true")
    void testNullTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = null;

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 空树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 空树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 空树应该是平衡的");
    }

    /**
     * 测试只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树应该返回true")
    void testSingleRootNode() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 只有根节点的树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 只有根节点的树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 只有根节点的树应该是平衡的");
    }

    /**
     * 测试平衡二叉树: 两层平衡树
     * 1
     * / \
     * 2 3
     */
    @Test
    @DisplayName("测试基本功能: 两层平衡二叉树应该返回true")
    void testTwoLevelBalancedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 两层平衡二叉树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 两层平衡二叉树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 两层平衡二叉树应该是平衡的");
    }

    /**
     * 测试平衡二叉树: 三层平衡树
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     */
    @Test
    @DisplayName("测试基本功能: 三层平衡二叉树应该返回true")
    void testThreeLevelBalancedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 三层平衡二叉树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 三层平衡二叉树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 三层平衡二叉树应该是平衡的");
    }

    /**
     * 测试非平衡二叉树: 左斜树
     * 1
     * /
     * 2
     * /
     * 3
     * /
     * 4
     */
    @Test
    @DisplayName("测试特殊情况: 左斜树应该返回false")
    void testLeftSkewedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertFalse(topDownResult, "自顶向下法: 左斜树应该是非平衡的");
        assertFalse(bottomUpResult, "自底向上法: 左斜树应该是非平衡的");
        assertFalse(solutionResult, "默认solution方法: 左斜树应该是非平衡的");
    }

    /**
     * 测试非平衡二叉树: 右斜树
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     */
    @Test
    @DisplayName("测试特殊情况: 右斜树应该返回false")
    void testRightSkewedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertFalse(topDownResult, "自顶向下法: 右斜树应该是非平衡的");
        assertFalse(bottomUpResult, "自底向上法: 右斜树应该是非平衡的");
        assertFalse(solutionResult, "默认solution方法: 右斜树应该是非平衡的");
    }

    /**
     * 测试非平衡二叉树: 高度差为2
     * 1
     * / \
     * 2 3
     * / \
     * 4 5
     * /
     * 6
     */
    @Test
    @DisplayName("测试特殊情况: 高度差为2的树应该返回false")
    void testHeightDifferenceTwoTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertFalse(topDownResult, "自顶向下法: 高度差为2的树应该是非平衡的");
        assertFalse(bottomUpResult, "自底向上法: 高度差为2的树应该是非平衡的");
        assertFalse(solutionResult, "默认solution方法: 高度差为2的树应该是非平衡的");
    }

    /**
     * 测试平衡二叉树: 高度差为1
     * 1
     * / \
     * 2 3
     * /
     * 4
     */
    @Test
    @DisplayName("测试特殊情况: 高度差为1的树应该返回true")
    void testHeightDifferenceOneTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 高度差为1的树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 高度差为1的树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 高度差为1的树应该是平衡的");
    }

    /**
     * 测试复杂非平衡二叉树: 只有某个子树不平衡
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     * /
     * 8
     * /
     * 9
     */
    @Test
    @DisplayName("测试复杂场景: 只有某个子树不平衡的树应该返回false")
    void testComplexUnbalancedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertFalse(topDownResult, "自顶向下法: 只有某个子树不平衡的树应该是非平衡的");
        assertFalse(bottomUpResult, "自底向上法: 只有某个子树不平衡的树应该是非平衡的");
        assertFalse(solutionResult, "默认solution方法: 只有某个子树不平衡的树应该是非平衡的");
    }

    /**
     * 测试四层平衡二叉树
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     * / \ / \ / \ / \
     * 8 9 10 11 12 13 14 15
     */
    @Test
    @DisplayName("测试基本功能: 四层平衡二叉树应该返回true")
    void testFourLevelBalancedTree() {
        // 准备测试数据
        Leet0110BalancedBinaryTree algo = new Leet0110BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        // 执行测试方法 - 自顶向下法
        boolean topDownResult = algo.isBalancedTopDown(root);
        // 执行测试方法 - 自底向上法
        boolean bottomUpResult = algo.isBalancedBottomUp(root);
        // 执行测试方法 - 默认solution方法
        boolean solutionResult = algo.solution(root);

        // 验证结果
        assertTrue(topDownResult, "自顶向下法: 四层平衡二叉树应该是平衡的");
        assertTrue(bottomUpResult, "自底向上法: 四层平衡二叉树应该是平衡的");
        assertTrue(solutionResult, "默认solution方法: 四层平衡二叉树应该是平衡的");
    }
}
