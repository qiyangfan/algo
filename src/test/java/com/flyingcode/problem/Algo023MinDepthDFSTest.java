package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Algo023MinDepthDFS
 * 使用 JUnit 5 测试使用深度优先搜索计算二叉树最小深度算法的正确性
 */
class Algo023MinDepthDFSTest {

    /**
     * 测试空树的情况
     */
    @Test
    @DisplayName("测试空树: null节点应返回深度0")
    void testNullTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        int result = algo.solution(null);
        assertEquals(0, result, "空树应该返回深度0");
    }

    /**
     * 测试只有根节点的树
     */
    @Test
    @DisplayName("测试只有根节点: 单个节点的树深度为1")
    void testSingleRootNode() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        int result = algo.solution(root);
        assertEquals(1, result, "只有根节点的树深度应该是1");
    }

    /**
     * 测试完全平衡的二叉树
     * 1
     * / \
     * 2 3
     */
    @Test
    @DisplayName("测试完全平衡树: 两层完全二叉树最小深度为2")
    void testBalancedTreeTwoLevels() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = algo.solution(root);
        assertEquals(2, result, "两层完全平衡二叉树的最小深度应该是2");
    }

    /**
     * 测试三层完全平衡的二叉树(满二叉树)
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     * 所有叶子节点(4,5,6,7)的深度都是3
     */
    @Test
    @DisplayName("测试三层完全平衡树: 满二叉树最小深度为3")
    void testBalancedTreeThreeLevels() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int result = algo.solution(root);
        assertEquals(3, result, "三层完全平衡二叉树的所有叶子节点深度都是3");
    }

    /**
     * 测试只有左子树的退化情况(左倾树)
     * 1
     * /
     * 2
     * /
     * 3
     */
    @Test
    @DisplayName("测试只有左子树: 左倾退化树的最小深度")
    void testLeftSkewedTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        int result = algo.solution(root);
        assertEquals(3, result, "左倾退化树必须遍历到最底部的叶子节点");
    }

    /**
     * 测试只有右子树的退化情况(右倾树)
     * 1
     * \
     * 2
     * \
     * 3
     */
    @Test
    @DisplayName("测试只有右子树: 右倾退化树的最小深度")
    void testRightSkewedTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        int result = algo.solution(root);
        assertEquals(3, result, "右倾退化树必须遍历到最底部的叶子节点");
    }

    /**
     * 测试左右子树深度不同的情况
     * 1
     * / \
     * 2 3
     * /
     * 4
     * 左子树深度为3, 右子树深度为2
     * 最小深度应该是2(右边的叶子节点3)
     */
    @Test
    @DisplayName("测试左右深度不同: 取较浅的一侧")
    void testDifferentDepthLeftAndRight() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int result = algo.solution(root);
        assertEquals(2, result, "应该取左右子树中较浅的深度");
    }

    /**
     * 测试只有右子节点(单侧子树)的情况
     * 1
     * \
     * 2
     * / \
     * 3 4
     * 根节点的右子节点有两个子节点, 最小深度为3
     */
    @Test
    @DisplayName("测试只有右子节点有子树: 单侧情况")
    void testOnlyRightChildHasSubtree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        int result = algo.solution(root);
        assertEquals(3, result, "只有右子树时必须向右遍历到叶子节点");
    }

    /**
     * 测试较深的左子树和较浅的右子树
     * 1
     * / \
     * 2 3
     * / \
     * 4 5
     * /
     * 6
     * 左子树深度4, 右子树深度2(节点3是叶子)
     * 最小深度应该是2
     */
    @Test
    @DisplayName("测试较深左子树和较浅右子树: 最小深度为2")
    void testDeepLeftShallowRight() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        int result = algo.solution(root);
        assertEquals(2, result, "右子树的叶子节点3深度为2, 是最小深度");
    }

    /**
     * 测试复杂的二叉树
     * 1
     * / \
     * 2 3
     * / \ \
     * 4 5 6
     * /
     * 7
     * 叶子节点:4(深度3),6(深度3),7(深度4)
     * 最小深度应该是3
     */
    @Test
    @DisplayName("测试复杂二叉树: 找到最近的叶子节点")
    void testComplexTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        int result = algo.solution(root);
        assertEquals(3, result, "最近的叶子节点是4或6, 深度为3");
    }

    /**
     * 测试左边很深但右边很浅的极端情况
     * 1
     * / \
     * 2 3
     * /
     * 4
     * /
     * 5
     * 左子树深度4, 右子树深度2
     * 最小深度应该是2
     */
    @Test
    @DisplayName("测试左边深右边浅: 最小深度由较浅侧决定")
    void testLeftDeepRightShallowExtreme() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        int result = algo.solution(root);
        assertEquals(2, result, "右子树的叶子节点3深度为2, 是最小深度");
    }

    /**
     * 测试三层左倾树
     * 1
     * /
     * 2
     * /
     * 3
     */
    @Test
    @DisplayName("测试三层左倾树: 深度为3")
    void testThreeLevelLeftSkewed() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        int result = algo.solution(root);
        assertEquals(3, result, "三层左倾树的深度为3");
    }

    /**
     * 测试两个节点的情况(只有左子节点)
     * 1
     * /
     * 2
     */
    @Test
    @DisplayName("测试两个节点左子树: 深度为2")
    void testTwoNodesLeftChild() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int result = algo.solution(root);
        assertEquals(2, result, "只有左子节点的树深度为2");
    }

    /**
     * 测试两个节点的情况(只有右子节点)
     * 1
     * \
     * 2
     */
    @Test
    @DisplayName("测试两个节点右子树: 深度为2")
    void testTwoNodesRightChild() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        int result = algo.solution(root);
        assertEquals(2, result, "只有右子节点的树深度为2");
    }

    /**
     * 测试四个节点的完全二叉树
     * 1
     * / \
     * 2 3
     * /
     * 4
     * 叶子节点有: 4(深度3),3(深度2)
     * 最小深度应该是2
     */
    @Test
    @DisplayName("测试四个节点树: 最小深度为2")
    void testFourNodesTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int result = algo.solution(root);
        assertEquals(2, result, "节点3是最近的叶子节点, 深度为2");
    }

    /**
     * 测试所有节点都在一侧的极端情况
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     */
    @Test
    @DisplayName("测试极端右倾树: 五个节点的退化树")
    void testExtremeRightSkewed() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        int result = algo.solution(root);
        assertEquals(5, result, "极端右倾树需要遍历所有节点, 深度为5");
    }

    /**
     * 测试对称的完全二叉树
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     * 所有叶子节点深度都是3
     */
    @Test
    @DisplayName("测试对称完全二叉树: 所有叶子深度相同")
    void testSymmetricCompleteTree() {
        Algo023MinDepthDFS algo = new Algo023MinDepthDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int result = algo.solution(root);
        assertEquals(3, result, "对称完全二叉树所有叶子深度都是3");
    }
}
