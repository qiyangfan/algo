# Test Class Writing Examples

## Important Formatting Rules

**Language & Punctuation Standards** (STRICTLY ENFORCED):
- **[MANDATORY]** Use Chinese for all test elements: test class comments, @DisplayName annotations, and assertion messages
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.) - **[ABSOLUTELY PROHIBITED]** Use Chinese punctuation marks
- **[MANDATORY]** No emoji in any test code or comments

**Examples**:
- Correct:  `@DisplayName("测试基本功能: 标准数组")` - Chinese text with English colon (:)
- Wrong:  `@DisplayName("测试基本功能: 标准数组")` - Chinese text with Chinese colon (:)
- Correct:  `assertEquals(3, result, "数组长度应该为3")` - Chinese text with English comma (,)
- Wrong:  `assertEquals(3, result, "数组长度应该为3, ")` - Chinese text with Chinese comma (,)

## Related Documentation

- **[TEST_RULES.md](TEST_RULES.md)** - Test class writing standards and rules
- **[COMMENT_EXAMPLES.md](COMMENT_EXAMPLES.md)** - Algorithm class comment examples
- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide

---

## 1. Package and Imports Structure

### 1.1 Standard Import Order

```java
package com.flyingcode.problem; // Use: problem, leetcode, sort, or swordoffer

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode; // Import data structures if needed
```

### 1.2 Class Declaration Template

```java
/**
 * 测试类: Algo025MaxIncSubseq
 * 使用JUnit 5测试最长连续递增子序列算法的正确性
 */
class Algo025MaxIncSubseqTest {
    // Test methods...
}
```

## 2. Test Method Structure (AAA Pattern)

### 2.1 Basic AAA Pattern

```java
/**
 * 测试基本功能: 标准数组有多个连续递增序列
 */
@Test
@DisplayName("测试标准数组有多个连续递增序列")
void testStandardArrayWithMultipleIncreasingSequences() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 3, 5, 4, 7 };
    int expected = 3;

    // 执行测试方法
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(expected, result, "数组[1,3,5,4,7]中最长连续递增子序列为[1,3,5], 长度为3");
}
```

## 3. Basic Functionality Test Examples

### 3.1 Standard Array Test

```java
/**
 * 测试基本功能: 标准数组有多个连续递增序列
 */
@Test
@DisplayName("测试标准数组有多个连续递增序列")
void testStandardArrayWithMultipleIncreasingSequences() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 3, 5, 4, 7 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列为[1,3,5], 长度为3");
}
```

### 3.2 Fully Increasing Array Test

```java
/**
 * 测试完全递增数组
 */
@Test
@DisplayName("测试完全递增数组")
void testFullyIncreasingArray() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2, 3, 4, 5 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(5, result, "完全递增数组[1,2,3,4,5]的最长连续递增子序列长度为5");
}
```

## 4. Boundary Condition Test Examples

### 4.1 Empty Array Test

```java
/**
 * 测试边界条件: 空数组
 */
@Test
@DisplayName("测试边界条件: 空数组")
void testEmptyArray() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = {};
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
}
```

### 4.2 Null Array Test

```java
/**
 * 测试边界条件: null数组
 */
@Test
@DisplayName("测试边界条件: null数组")
void testNullArray() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int result = algo.solution(null);

    // 验证结果
    assertEquals(0, result, "null数组的最长连续递增子序列长度为0");
}
```

### 4.3 Single Element Test

```java
/**
 * 测试单个元素
 */
@Test
@DisplayName("测试单个元素")
void testSingleElement() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(1, result, "单个元素数组的最长连续递增子序列长度为1");
}
```

## 5. Special Case Test Examples

### 5.1 All Same Elements Test

```java
/**
 * 测试特殊情况: 所有元素相同
 */
@Test
@DisplayName("测试所有元素相同")
void testAllSameElements() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 2, 2, 2, 2, 2 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(1, result, "所有元素相同的数组的最长连续递增子序列长度为1");
}
```

### 5.2 Array with Negative Numbers Test

```java
/**
 * 测试特殊情况: 包含负数的数组
 */
@Test
@DisplayName("测试包含负数的数组")
void testArrayWithNegativeNumbers() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { -2, -1, 0, 1, 2 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(5, result, "包含负数的递增数组[-2,-1,0,1,2]的最长连续递增子序列长度为5");
}
```

### 5.3 Decreasing Array Test

```java
/**
 * 测试特殊情况: 完全递减数组
 */
@Test
@DisplayName("测试完全递减数组")
void testFullyDecreasingArray() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 5, 4, 3, 2, 1 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(1, result, "完全递减数组[5,4,3,2,1]的最长连续递增子序列长度为1");
}
```

### 5.4 Two Elements Test

```java
/**
 * 测试特殊情况: 两个递增元素
 */
@Test
@DisplayName("测试两个递增元素")
void testTwoIncreasingElements() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(2, result, "两个递增元素[1,2]的长度应该是2");
}
```

## 6. Complex Scenario Test Examples

### 6.1 Long Array with Multiple Sequences

```java
/**
 * 测试复杂场景: 长数组中的多个递增序列
 */
@Test
@DisplayName("测试长数组中的多个递增序列")
void testLongArrayWithMultipleSequences() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2, 3, 1, 2, 3, 4, 5, 2, 3 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(5, result, "长数组中最长连续递增子序列为[1,2,3,4,5], 长度为5");
}
```

### 6.2 Fluctuating Pattern Test

```java
/**
 * 测试复杂场景: 波动模式数组
 */
@Test
@DisplayName("测试波动模式数组")
void testFluctuatingPattern() {
    // 准备测试数据
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2, 1, 2, 1, 2, 1, 2 };
    int result = algo.solution(nums);

    // 验证结果
    assertEquals(2, result, "波动模式数组中最长连续递增子序列长度为2");
}
```

## 7. Data Structure Test Examples

### 7.1 Binary Tree Test with Visual Documentation

```java
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
    Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    List<Integer> expected = new ArrayList<Integer>();
    expected.add(9);
    expected.add(3);
    expected.add(15);
    expected.add(20);
    expected.add(7);

    // 执行测试方法
    List<Integer> result = algo.solution(root);

    // 验证结果
    assertNotNull(result, "返回结果不应为null");
    assertEquals(expected, result, "平衡二叉树的中序遍历结果应该是[9,3,15,20,7]");
}
```

### 7.2 Null Tree Test

```java
/**
 * 测试边界条件: 空树
 */
@Test
@DisplayName("测试边界条件: 空树")
void testNullTree() {
    // 准备测试数据
    Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
    List<Integer> expected = new ArrayList<Integer>();

    // 执行测试方法
    List<Integer> result = algo.solution(null);

    // 验证结果
    assertNotNull(result, "返回结果不应为null");
    assertEquals(expected, result, "空树的中序遍历结果应该是[]");
}
```

### 7.3 Single Node Tree Test

```java
/**
 * 测试边界条件: 只有根节点的树
 */
@Test
@DisplayName("测试边界条件: 只有根节点的树")
void testOnlyRootNode() {
    // 准备测试数据
    Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
    TreeNode root = new TreeNode(5);
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(5);

    // 执行测试方法
    List<Integer> result = algo.solution(root);

    // 验证结果
    assertNotNull(result, "返回结果不应为null");
    assertEquals(expected, result, "只有根节点5的树的中序遍历结果应该是[5]");
}
```

## 8. Complete Test Class Examples

### 8.1 Simple Algorithm Test Class

```java
package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo025MaxIncSubseq
 * 使用JUnit 5测试最长连续递增子序列算法的正确性
 */
class Algo025MaxIncSubseqTest {

    /**
     * 测试基本功能: 标准数组有多个连续递增序列
     */
    @Test
    @DisplayName("测试标准数组有多个连续递增序列")
    void testStandardArrayWithMultipleIncreasingSequences() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 3, 5, 4, 7 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列为[1,3,5], 长度为3");
    }

    /**
     * 测试完全递增数组
     */
    @Test
    @DisplayName("测试完全递增数组")
    void testFullyIncreasingArray() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(5, result, "完全递增数组[1,2,3,4,5]的最长连续递增子序列长度为5");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = {};
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试边界条件: null数组
     */
    @Test
    @DisplayName("测试边界条件: null数组")
    void testNullArray() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int result = algo.solution(null);

        // 验证结果
        assertEquals(0, result, "null数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试单个元素
     */
    @Test
    @DisplayName("测试单个元素")
    void testSingleElement() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(1, result, "单个元素数组的最长连续递增子序列长度为1");
    }

    /**
     * 测试所有元素相同
     */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllSameElements() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 2, 2, 2, 2, 2 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(1, result, "所有元素相同的数组的最长连续递增子序列长度为1");
    }

    /**
     * 测试特殊情况: 包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { -2, -1, 0, 1, 2 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(5, result, "包含负数的递增数组[-2,-1,0,1,2]的最长连续递增子序列长度为5");
    }

    /**
     * 测试复杂场景: 长数组中的多个递增序列
     */
    @Test
    @DisplayName("测试长数组中的多个递增序列")
    void testLongArrayWithMultipleSequences() {
        // 准备测试数据
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 1, 2, 3, 4, 5, 2, 3 };
        int result = algo.solution(nums);

        // 验证结果
        assertEquals(5, result, "长数组中最长连续递增子序列为[1,2,3,4,5], 长度为5");
    }
}
```

### 8.2 Tree Structure Test Class

```java
package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * 测试类: Leet0094BinaryTreeInorderTraversal
 * 使用JUnit 5测试二叉树中序遍历算法的正确性
 */
class Leet0094BinaryTreeInorderTraversalTest {

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
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(2);

        // 执行测试方法
        List<Integer> result = algo.solution(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "二叉树[1,null,2,3]的中序遍历结果应该是[1,3,2]");
    }

    /**
     * 测试边界条件: 空树
     */
    @Test
    @DisplayName("测试边界条件: 空树")
    void testNullTree() {
        // 准备测试数据
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        List<Integer> expected = new ArrayList<Integer>();

        // 执行测试方法
        List<Integer> result = algo.solution(null);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "空树的中序遍历结果应该是[]");
    }

    /**
     * 测试边界条件: 只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树")
    void testOnlyRootNode() {
        // 准备测试数据
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(5);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);

        // 执行测试方法
        List<Integer> result = algo.solution(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "只有根节点5的树的中序遍历结果应该是[5]");
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
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(9);
        expected.add(3);
        expected.add(15);
        expected.add(20);
        expected.add(7);

        // 执行测试方法
        List<Integer> result = algo.solution(root);

        // 验证结果
        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "平衡二叉树的中序遍历结果应该是[9,3,15,20,7]");
    }
}
```

## 9. Reference Examples Location

Complete test class examples in project:

**problem package tests**:
- `src/test/java/com/flyingcode/problem/Algo025MaxIncSubseqTest.java`

**leetcode package tests**:
- `src/test/java/com/flyingcode/leetcode/Leet0070ClimbStairsTest.java`

**Tree structure tests**:
- `src/test/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversalTest.java`
