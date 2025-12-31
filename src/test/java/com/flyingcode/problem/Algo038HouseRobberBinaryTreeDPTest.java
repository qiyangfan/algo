package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Algo038HouseRobberBinaryTreeDP
 * 使用 JUnit 5 测试二叉树结构房屋抢劫问题的动态规划实现的正确性
 */
class Algo038HouseRobberBinaryTreeDPTest {

  /**
   * 测试边界条件: 空树
   */
  @Test
  @DisplayName("测试边界条件: 空树")
  void testEmptyTree() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = null;

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(0, result, "空树: 没有房屋可抢劫, 获得最大金额0");
  }

  /**
   * 测试基本功能: 只有根节点的树
   */
  @Test
  @DisplayName("测试基本功能: 只有根节点的树")
  void testSingleNode() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(1);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(1, result, "只有根节点的树: 抢劫该房屋, 获得最大金额1");
  }

  /**
   * 测试基本功能: 根节点和左子节点
   */
  @Test
  @DisplayName("测试基本功能: 根节点和左子节点")
  void testRootAndLeftChild() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(2, result, "根节点和左子节点: 选择金额较大的左子节点, 获得最大金额2");
  }

  /**
   * 测试基本功能: 根节点和右子节点
   */
  @Test
  @DisplayName("测试基本功能: 根节点和右子节点")
  void testRootAndRightChild() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(2, result, "根节点和右子节点: 选择金额较大的右子节点, 获得最大金额2");
  }

  /**
   * 测试基本功能: 根节点、左子节点和右子节点
   */
  @Test
  @DisplayName("测试基本功能: 根节点、左子节点和右子节点")
  void testRootWithTwoChildren() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(5, result, "根节点、左子节点和右子节点: 选择根节点和右子节点, 获得最大金额3+2=5");
  }

  /**
   * 测试复杂场景: 完整的二叉树
   */
  @Test
  @DisplayName("测试复杂场景: 完整的二叉树")
  void testFullBinaryTree() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(1);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(7, result, "完整的二叉树: 选择根节点、左子节点的右子节点和右子节点, 获得最大金额3+3+1=7");
  }

  /**
   * 测试复杂场景: 另一个完整的二叉树
   */
  @Test
  @DisplayName("测试复杂场景: 另一个完整的二叉树")
  void testAnotherFullBinaryTree() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(1);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(9, result, "另一个完整的二叉树: 选择左子节点(4)和右子节点(5), 获得最大金额4+5=9");
  }

  /**
   * 测试特殊情况: 所有节点值相同的树
   */
  @Test
  @DisplayName("测试特殊情况: 所有节点值相同的树")
  void testAllSameValues() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(2);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(10, result, "所有节点值相同的树: 选择根节点、左右子节点的左右子节点, 获得最大金额2+2+2+2+2=10");
  }

  /**
   * 测试特殊情况: 包含0的树
   */
  @Test
  @DisplayName("测试特殊情况: 包含0的树")
  void testTreeWithZeros() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(3);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(0);
    root.right.right = new TreeNode(2);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(5, result, "包含0的树: 选择左子节点(3)和右子节点的右子节点(2), 获得最大金额3+2=5");
  }

  /**
   * 测试特殊情况: 包含负数的树
   */
  @Test
  @DisplayName("测试特殊情况: 包含负数的树")
  void testTreeWithNegativeNumbers() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(-4);
    root.left.right = new TreeNode(-5);
    root.right.left = new TreeNode(-1);
    root.right.right = new TreeNode(-2);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(3, result, "包含负数的树: 选择根节点(3), 不抢劫左右子节点(它们的值为负数), 获得最大金额3");
  }

  /**
   * 测试复杂场景: 不平衡的二叉树
   */
  @Test
  @DisplayName("测试复杂场景: 不平衡的二叉树")
  void testUnbalancedBinaryTree() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.left.left.left.left = new TreeNode(5);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(9, result, "不平衡的二叉树: 选择第1、3、5层节点, 获得最大金额2+4+3=9");
  }

  /**
   * 测试复杂场景: 完全二叉树
   */
  @Test
  @DisplayName("测试复杂场景: 完全二叉树")
  void testCompleteBinaryTree() {
    // Arrange: 准备测试数据
    Algo038HouseRobberBinaryTreeDP algo = new Algo038HouseRobberBinaryTreeDP();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(1);
    root.right.left = new TreeNode(6);

    // Act: 执行测试方法
    int result = algo.solution(root);

    // Assert: 验证结果
    assertEquals(14, result, "完全二叉树: 选择根节点、左子节点的最大值和右子节点的最大值, 获得最大金额5+3+6=14");
  }
}
