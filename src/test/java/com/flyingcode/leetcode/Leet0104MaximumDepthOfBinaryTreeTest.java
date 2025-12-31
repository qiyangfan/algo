package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Leet0104MaximumDepthOfBinaryTree
 * 使用JUnit 5测试二叉树的最大深度算法的正确性
 */
class Leet0104MaximumDepthOfBinaryTreeTest {

    /**
     * 测试空树: null节点的深度应该是0
     */
    @Test
    @DisplayName("测试边界条件: 空树的深度应该是0")
    void testNullTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = null;

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(0, recursiveResult, "递归法: 空树的深度应该是0");
        assertEquals(0, iterativeResult, "迭代法: 空树的深度应该是0");
    }

    /**
     * 测试只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树深度应该是1")
    void testSingleRootNode() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(1, recursiveResult, "递归法: 只有根节点的树深度应该是1");
        assertEquals(1, iterativeResult, "迭代法: 只有根节点的树深度应该是1");
    }

    /**
     * 测试两层平衡二叉树
     * 1
     * / \
     * 2 3
     */
    @Test
    @DisplayName("测试基本功能: 两层平衡二叉树深度应该是2")
    void testTwoLevelBalancedTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(2, recursiveResult, "递归法: 两层平衡二叉树深度应该是2");
        assertEquals(2, iterativeResult, "迭代法: 两层平衡二叉树深度应该是2");
    }

    /**
     * 测试三层平衡二叉树
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     */
    @Test
    @DisplayName("测试基本功能: 三层平衡二叉树深度应该是3")
    void testThreeLevelBalancedTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(3, recursiveResult, "递归法: 三层平衡二叉树深度应该是3");
        assertEquals(3, iterativeResult, "迭代法: 三层平衡二叉树深度应该是3");
    }

    /**
     * 测试左斜树: 所有节点都在左子树
     * 1
     * /
     * 2
     * /
     * 3
     */
    @Test
    @DisplayName("测试特殊情况: 左斜树的深度应该等于节点数")
    void testLeftSkewedTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(3, recursiveResult, "递归法: 左斜树的深度应该等于节点数");
        assertEquals(3, iterativeResult, "迭代法: 左斜树的深度应该等于节点数");
    }

    /**
     * 测试右斜树: 所有节点都在右子树
     * 1
     * \
     * 2
     * \
     * 3
     */
    @Test
    @DisplayName("测试特殊情况: 右斜树的深度应该等于节点数")
    void testRightSkewedTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(3, recursiveResult, "递归法: 右斜树的深度应该等于节点数");
        assertEquals(3, iterativeResult, "迭代法: 右斜树的深度应该等于节点数");
    }

    /**
     * 测试不对称树: 左子树深度大于右子树
     * 1
     * / \
     * 2 3
     * / \ \
     * 4 5 6
     * /
     * 7
     */
    @Test
    @DisplayName("测试特殊情况: 不对称树的深度由最深子树决定")
    void testAsymmetricTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);

        // 验证结果
        assertEquals(4, recursiveResult, "递归法: 不对称树的深度由最深子树决定");
        assertEquals(4, iterativeResult, "迭代法: 不对称树的深度由最深子树决定");
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
    @DisplayName("测试基本功能: 四层平衡二叉树深度应该是4")
    void testFourLevelBalancedTree() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
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

        // 执行测试方法 - 递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 迭代法
        int iterativeResult = algo.maxDepthIterative(root);
        // 执行测试方法 - 默认solution方法
        int solutionResult = algo.solution(root);

        // 验证结果
        assertEquals(4, recursiveResult, "递归法: 四层平衡二叉树深度应该是4");
        assertEquals(4, iterativeResult, "迭代法: 四层平衡二叉树深度应该是4");
        assertEquals(4, solutionResult, "默认solution方法: 四层平衡二叉树深度应该是4");
    }

    /**
     * 测试默认solution方法是否正确调用递归法
     */
    @Test
    @DisplayName("测试默认方法: solution方法应该调用递归法")
    void testSolutionMethod() {
        // 准备测试数据
        Leet0104MaximumDepthOfBinaryTree algo = new Leet0104MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // 执行测试方法 - 直接调用递归法
        int recursiveResult = algo.maxDepthRecursive(root);
        // 执行测试方法 - 默认solution方法
        int solutionResult = algo.solution(root);

        // 验证结果
        assertEquals(3, recursiveResult, "递归法: 树的深度应该是3");
        assertEquals(3, solutionResult, "默认solution方法: 树的深度应该是3");
        assertEquals(recursiveResult, solutionResult, "默认solution方法应该与递归法结果一致");
    }
}
