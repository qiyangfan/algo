package com.flyingcode.binarytree.traversal.morris;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: InorderMorrisTraversal
 * 使用JUnit 5测试二叉树中序Morris遍历算法的正确性
 */
class InorderMorrisTraversalTest {

    /**
     * 测试基本功能: 包含多个节点的标准二叉树
     * 树结构:
     *   1
     *    \
     *     2
     *    /
     *   3
     */
    @Test
    @DisplayName("测试基本功能: 包含多个节点的标准二叉树")
    void testStandardBinaryTree() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(2);

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "二叉树[1,null,2,3]的中序Morris遍历结果应该是[1,3,2]");
    }

    /**
     * 测试边界条件: 空树
     */
    @Test
    @DisplayName("测试边界条件: 空树")
    void testNullTree() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        List<Integer> expected = new ArrayList<>();

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(null);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "空树的中序Morris遍历结果应该是[]");
    }

    /**
     * 测试边界条件: 只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树")
    void testOnlyRootNode() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        TreeNode root = new TreeNode(5);
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "只有根节点5的树的中序Morris遍历结果应该是[5]");
    }

    /**
     * 测试平衡二叉树
     * 树结构:
     *       3
     *      / \
     *     9  20
     *       /  \
     *      15   7
     */
    @Test
    @DisplayName("测试平衡二叉树")
    void testBalancedBinaryTree() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Integer> expected = new ArrayList<>();
        expected.add(9);
        expected.add(3);
        expected.add(15);
        expected.add(20);
        expected.add(7);

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "平衡二叉树的中序Morris遍历结果应该是[9,3,15,20,7]");
    }

    /**
     * 测试特殊情况: 左斜树
     * 树结构:
     *       4
     *      /
     *     3
     *    /
     *   2
     *  /
     * 1
     */
    @Test
    @DisplayName("测试特殊情况: 左斜树")
    void testLeftSkewedTree() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "左斜树的中序Morris遍历结果应该是[1,2,3,4]");
    }

    /**
     * 测试特殊情况: 右斜树
     * 树结构:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     */
    @Test
    @DisplayName("测试特殊情况: 右斜树")
    void testRightSkewedTree() {
        // 准备测试数据
        InorderMorrisTraversal traversal = new InorderMorrisTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        // 执行测试方法
        List<Integer> result = traversal.inorderTraversal(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "右斜树的中序Morris遍历结果应该是[1,2,3,4]");
    }
}