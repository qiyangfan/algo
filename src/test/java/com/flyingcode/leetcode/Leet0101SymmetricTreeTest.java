package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Leet0101SymmetricTree
 * 使用JUnit 5测试对称二叉树算法的正确性
 */
class Leet0101SymmetricTreeTest {

    /**
     * 测试空树: null节点应该是对称的
     */
    @Test
    @DisplayName("测试边界条件: 空树应该返回true")
    void testNullTree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = null;

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertTrue(result, "空树应该是对称的");
    }

    /**
     * 测试只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树应该返回true")
    void testSingleRootNode() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertTrue(result, "只有根节点的树应该是对称的");
    }

    /**
     * 测试两层对称二叉树
     * 1
     * / \
     * 2 2
     */
    @Test
    @DisplayName("测试基本功能: 两层对称二叉树应该返回true")
    void testTwoLevelSymmetricTree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertTrue(result, "两层对称二叉树应该是对称的");
    }

    /**
     * 测试两层非对称二叉树
     * 1
     * / \
     * 2 3
     */
    @Test
    @DisplayName("测试基本功能: 两层非对称二叉树应该返回false")
    void testTwoLevelNonSymmetricTree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertFalse(result, "两层非对称二叉树应该不是对称的");
    }

    /**
     * 测试三层对称二叉树
     * 1
     * / \
     * 2 2
     * / \ / \
     * 3 4 4 3
     */
    @Test
    @DisplayName("测试基本功能: 三层对称二叉树应该返回true")
    void testThreeLevelSymmetricTree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertTrue(result, "三层对称二叉树应该是对称的");
    }

    /**
     * 测试三层非对称二叉树
     * 1
     * / \
     * 2 2
     * / \ / \
     * 3 4 3 4
     */
    @Test
    @DisplayName("测试基本功能: 三层非对称二叉树应该返回false")
    void testThreeLevelNonSymmetricTree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertFalse(result, "三层非对称二叉树应该不是对称的");
    }

    /**
     * 测试左右子树深度不同的树
     * 1
     * / \
     * 2 2
     * \ \
     * 3 3
     */
    @Test
    @DisplayName("测试特殊情况: 左右子树深度不同的对称树应该返回true")
    void testSymmetricTreeWithDifferentDepths() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertFalse(result, "左右子树深度不同且结构不对称的树应该不是对称的");
    }

    /**
     * 测试包含null节点的对称树
     * 1
     * / \
     * 2 2
     * / \
     * 3 3
     */
    @Test
    @DisplayName("测试特殊情况: 包含null节点的对称树应该返回true")
    void testSymmetricTreeWithNullNodes() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertTrue(result, "包含null节点的对称树应该是对称的");
    }

    /**
     * 测试缺少一个子树的非对称树
     * 1
     * / \
     * 2 2
     * /
     * 3
     */
    @Test
    @DisplayName("测试特殊情况: 缺少一个子树的非对称树应该返回false")
    void testNonSymmetricTreeWithMissingSubtree() {
        // 准备测试数据
        Leet0101SymmetricTree algo = new Leet0101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        // 执行测试方法
        boolean result = algo.solution(root);

        // 验证结果
        assertFalse(result, "缺少一个子树的非对称树应该不是对称的");
    }
}
