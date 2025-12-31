# Test Class Writing Guidelines

## Important Formatting Rules

**Language & Punctuation Standards** (MANDATORY - STRICTLY ENFORCED):
- **[MANDATORY]** Use Chinese for all test elements: test class comments, @DisplayName annotations, and assertion messages
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.) - **[ABSOLUTELY PROHIBITED]** Use Chinese punctuation marks
- **[MANDATORY]** No emoji in any test code or comments

**Examples**:
- Correct:  `@DisplayName("测试基本功能: 标准数组")` - Chinese text with English colon (:)
- Wrong:  `@DisplayName("测试基本功能: 标准数组")` - Chinese text with Chinese colon (:)
- Correct:  `assertEquals(3, result, "数组长度应该为3")` - Chinese text with English comma (,)
- Wrong:  `assertEquals(3, result, "数组长度应该为3, ")` - Chinese text with Chinese comma (,)

## Related Documentation

- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide
- **[COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md)** - Algorithm class comment standards

---

## 1. Overview

This document defines standards for writing Java test classes using JUnit 5. All test classes must follow these standards to ensure consistency, maintainability, and comprehensive coverage.

**Core Principle**: Test classes should focus on verifying algorithm correctness and boundary conditions. Each test case must be independent, clear, and self-explanatory.

**Test Location**: `src/test/java/com/flyingcode/[package]/` (mirror source structure)

## 2. General Rules

### 2.1 Test Independence
- Each test method runs independently
- No dependency on execution order or other test results
- Create new object instances for each test

### 2.2 Naming Conventions
- Test class: `TestedClassName + Test`
- Test methods: `test + specificTestScenario` (camelCase)
- Use descriptive, self-documenting names

**Examples**:
- `Algo025MaxIncSubseqTest`
- `Leet0070ClimbStairsTest`
- `testStandardArray()`, `testEmptyArray()`, `testWithNegativeNumbers()`

### 2.3 Language & Punctuation
- **Chinese text with English punctuation** in all test elements
- Clear assertion messages explaining expected results
- Consistent terminology across test cases

### 2.4 Coverage Standards
- Basic functionality tests (2-3 tests)
- Boundary condition tests (3-4 tests)
- Special case tests (3-4 tests)
- Complex scenario tests (2-3 tests)

**Minimum**: 8-10 tests per algorithm class
**Recommended**: 12-15 tests for comprehensive coverage

## 3. Test Class Structure

### 3.1 Package and Imports

**Location**: Beginning of file

**Standard Order**:
1. Package declaration
2. Static imports (assertion methods)
3. JUnit 5 annotations
4. Java standard library imports
5. Tested classes and data structures

**Example**:
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

### 3.2 Class Declaration

**Code Style**:
- Package-private (no `public` modifier)
- Package-private test methods (no `public` modifier)
- 2-space indentation

**Class-Level Comment Template**:
```java
/**
 * 测试类: [TestedClassName]
 * 使用JUnit 5测试[算法/功能描述]的正确性
 */
class [TestedClassName]Test {
    // Test methods...
}
```

**Naming Rules**:
- `problem` package: `AlgoXXXClassNameTest` (e.g., `Algo025MaxIncSubseqTest`)
- `leetcode` package: `LeetXXXXProblemNameTest` (e.g., `Leet0070ClimbStairsTest`)
- Format: `TestedClassName + Test`

### 3.3 Test Method Structure

**AAA Pattern** (Arrange-Act-Assert):
```java
/**
 * 测试[测试场景描述]
 */
@Test
@DisplayName("测试[测试场景描述]")
void testSpecificScenario() {
    // 准备测试数据
    [TestedClassName] algo = new [TestedClassName]();
    [InputType] input = [inputValue];
    [ExpectedType] expected = [expectedValue];

    // 执行测试方法
    [ReturnType] result = algo.solution(input);

    // 验证结果
    assertEquals(expected, result, "[清晰的断言消息说明预期结果]");
}
```

**Comments**:
- Use Chinese comments for AAA sections
- Use English punctuation marks
- Keep comments concise and clear

## 4. Test Case Design

### 4.1 Basic Functionality Tests (2-3 tests)

**Purpose**: Verify algorithm correctness under standard conditions

**Example**:
```java
/**
 * 测试基本功能: 标准数组有多个连续递增序列
 */
@Test
@DisplayName("测试标准数组有多个连续递增序列")
void testStandardArrayWithMultipleIncreasingSequences() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 3, 5, 4, 7 };
    int result = algo.solution(nums);
    assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列为[1,3,5], 长度为3");
}
```

### 4.2 Boundary Condition Tests (3-4 tests)

**Common Boundaries**:
- Empty array/collection
- null input
- Single element
- Minimum/maximum values

**Examples**:
```java
/**
 * 测试边界条件: 空数组
 */
@Test
@DisplayName("测试边界条件: 空数组")
void testEmptyArray() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = {};
    int result = algo.solution(nums);
    assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
}

/**
 * 测试边界条件: null数组
 */
@Test
@DisplayName("测试边界条件: null数组")
void testNullArray() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int result = algo.solution(null);
    assertEquals(0, result, "null数组的最长连续递增子序列长度为0");
}

/**
 * 测试单个元素
 */
@Test
@DisplayName("测试单个元素")
void testSingleElement() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1 };
    int result = algo.solution(nums);
    assertEquals(1, result, "单个元素数组的最长连续递增子序列长度为1");
}
```

### 4.3 Special Case Tests (3-4 tests)

**Common Special Cases**:
- All elements identical
- Completely increasing/decreasing
- Contains negative numbers, zeros
- Duplicate elements
- Skewed data structures (for trees/graphs)

**Examples**:
```java
/**
 * 测试特殊情况: 所有元素相同
 */
@Test
@DisplayName("测试所有元素相同")
void testAllSameElements() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 2, 2, 2, 2, 2 };
    int result = algo.solution(nums);
    assertEquals(1, result, "所有元素相同的数组的最长连续递增子序列长度为1");
}

/**
 * 测试特殊情况: 完全递增数组
 */
@Test
@DisplayName("测试完全递增数组")
void testFullyIncreasingArray() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2, 3, 4, 5 };
    int result = algo.solution(nums);
    assertEquals(5, result, "完全递增数组[1,2,3,4,5]的最长连续递增子序列长度为5");
}

/**
 * 测试特殊情况: 包含负数的数组
 */
@Test
@DisplayName("测试包含负数的数组")
void testArrayWithNegativeNumbers() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { -2, -1, 0, 1, 2 };
    int result = algo.solution(nums);
    assertEquals(5, result, "包含负数的递增数组[-2,-1,0,1,2]的最长连续递增子序列长度为5");
}
```

### 4.4 Complex Scenario Tests (2-3 tests)

**Common Complex Scenarios**:
- Long arrays/large inputs
- Multiple solutions/paths
- Extreme condition combinations
- Fluctuating patterns

**Example**:
```java
/**
 * 测试复杂场景: 长数组中的多个递增序列
 */
@Test
@DisplayName("测试长数组中的多个递增序列")
void testLongArrayWithMultipleSequences() {
    Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
    int[] nums = { 1, 2, 3, 1, 2, 3, 4, 5, 2, 3 };
    int result = algo.solution(nums);
    assertEquals(5, result, "长数组中最长连续递增子序列为[1,2,3,4,5], 长度为5");
}
```

### 4.5 Data Structure Tests (Trees, Linked Lists)

**Visual Documentation**: Use clear comments to describe structure

**Example**:
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

    List<Integer> result = algo.solution(root);

    assertNotNull(result, "返回结果不应为null");
    assertEquals(expected, result, "平衡二叉树的中序遍历结果应该是[9,3,15,20,7]");
}
```

## 5. Assertion Standards

### 5.1 Assertion Method Selection

| Method | Use Case | Example |
|--------|----------|---------|
| `assertEquals(expected, actual, message)` | Basic type equality | `assertEquals(3, result, "长度应该为3")` |
| `assertArrayEquals(expected, actual, message)` | Array equality | `assertArrayEquals(expected, result, "数组应该匹配")` |
| `assertTrue(condition, message)` | Verify condition is true | `assertTrue(result.isEmpty(), "结果应该为空")` |
| `assertFalse(condition, message)` | Verify condition is false | `assertFalse(result.isEmpty(), "结果不应为空")` |
| `assertNull(actual, message)` | Verify is null | `assertNull(result, "结果应该是null")` |
| `assertNotNull(actual, message)` | Verify is not null | `assertNotNull(result, "结果不应为null")` |

### 5.2 Assertion Message Standards

**Must Include**:
- Clear description of expected results
- Test scenario context
- Input data reference when helpful

**Good Examples**:
```java
assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列是[1,3,5], 长度为3");
assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
assertEquals(2, result, "两个递增元素[1,2]的长度应该是2");
```

**Bad Examples**:
```java
assertEquals(3, result);  // Missing description
assertEquals(3, result, "失败");  // Message not clear
assertEquals(3, result, "应该是3");  // Missing context
```

### 5.3 Multiple Assertions Strategy

For complex results (lists, trees), use progressive assertions:
```java
assertNotNull(result, "返回结果不应为null");
assertEquals(expected.size(), result.size(), "结果列表长度不匹配");
assertEquals(expected, result, "中序遍历结果应该匹配");
```

## 6. Test Organization

### 6.1 Recommended Order

1. Basic functionality tests
2. Boundary condition tests
3. Special case tests
4. Complex scenario tests
5. Edge case tests

### 6.2 Test Quantity Guidelines

**Minimum**: 8-10 tests
- 2-3 basic functionality
- 3-4 boundary conditions
- 2-3 special cases

**Recommended**: 12-15 tests
- 2-3 basic functionality
- 3-4 boundary conditions
- 3-4 special cases
- 2-3 complex scenarios
- 1-2 edge cases

**Complete**: 15+ tests
- Suitable for complex algorithms
- Cover all scenario combinations

## 7. Complete Test Class Examples

### 7.1 Simple Algorithm Test

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
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 3, 5, 4, 7 };
        int result = algo.solution(nums);
        assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列为[1,3,5], 长度为3");
    }

    /**
     * 测试完全递增数组
     */
    @Test
    @DisplayName("测试完全递增数组")
    void testFullyIncreasingArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(5, result, "完全递增数组[1,2,3,4,5]的最长连续递增子序列长度为5");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试边界条件: null数组
     */
    @Test
    @DisplayName("测试边界条件: null数组")
    void testNullArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int result = algo.solution(null);
        assertEquals(0, result, "null数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试单个元素
     */
    @Test
    @DisplayName("测试单个元素")
    void testSingleElement() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1 };
        int result = algo.solution(nums);
        assertEquals(1, result, "单个元素数组的最长连续递增子序列长度为1");
    }

    /**
     * 测试所有元素相同
     */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllSameElements() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 2, 2, 2, 2, 2 };
        int result = algo.solution(nums);
        assertEquals(1, result, "所有元素相同的数组的最长连续递增子序列长度为1");
    }
}
```

### 7.2 Tree Structure Test

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
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(2);

        List<Integer> result = algo.solution(root);

        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "二叉树[1,null,2,3]的中序遍历结果应该是[1,3,2]");
    }

    /**
     * 测试边界条件: 空树
     */
    @Test
    @DisplayName("测试边界条件: 空树")
    void testNullTree() {
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        List<Integer> expected = new ArrayList<Integer>();

        List<Integer> result = algo.solution(null);

        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "空树的中序遍历结果应该是[]");
    }

    /**
     * 测试边界条件: 只有根节点的树
     */
    @Test
    @DisplayName("测试边界条件: 只有根节点的树")
    void testOnlyRootNode() {
        Leet0094BinaryTreeInorderTraversal algo = new Leet0094BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(5);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);

        List<Integer> result = algo.solution(root);

        assertNotNull(result, "返回结果不应为null");
        assertEquals(expected, result, "只有根节点5的树的中序遍历结果应该是[5]");
    }
}
```

## 8. Running and Verification

### 8.1 Run Single Test Class
```bash
mvn test -Dtest=AlgoXXXTest  # Run problem package test class
mvn test -Dtest=LeetXXXXTest  # Run leetcode package test class
```

### 8.2 Run All Tests
```bash
mvn test
```

### 8.3 Success Criteria
- All tests pass (0 Failures, 0 Errors)
- Test coverage >= 80%
- Execution time < 1 second per test class

## 9. Common Issues and Solutions

### 9.1 Unclear Naming
Wrong:  **Problem**: `test1()`, `testMethod()`, `testA()`
Correct:  **Solution**: `testEmptyArray()`, `testWithNegativeNumbers()`, `testSingleElement()`

### 9.2 Missing Assertion Messages
Wrong:  **Problem**: `assertEquals(3, result)`
Correct:  **Solution**: `assertEquals(3, result, "预期结果为3, 因为...")`

### 9.3 Insufficient Coverage
Wrong:  **Problem**: Only normal cases tested, no boundary conditions
Correct:  **Solution**: Add null, empty, single element, and special case tests

### 9.4 Interdependent Tests
Wrong:  **Problem**: Tests share state or depend on execution order
Correct:  **Solution**: Create new instances in each test method

### 9.5 Wrong Punctuation
Wrong:  **Problem**: `@DisplayName("测试数组: 输入")` using Chinese punctuation
Correct:  **Solution**: `@DisplayName("测试数组: 输入")` using English punctuation

## 10. Best Practices Summary

1. **AAA Pattern**: Arrange-Act-Assert structure with Chinese comments
2. **Clear Messages**: Descriptive assertion messages in Chinese with English punctuation
3. **Independence**: Each test runs independently with new instances
4. **Coverage**: Test boundaries, special cases, and complex scenarios
5. **Visual Docs**: Use comments to describe data structures
6. **Language**: Chinese text with English punctuation (critical requirement)
7. **No Emoji**: Keep code professional and clean
8. **Package-Private**: No public modifier needed for test classes or methods
9. **Consistent Naming**: Follow `TestedClassName + Test` pattern
10. **Comprehensive**: Aim for 12-15 tests covering all scenarios

## 11. Documentation System Integration

Complete project documentation:
- **[CLAUDE.md](CLAUDE.md)** - Project structure and architecture
- **[COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md)** - Algorithm comment standards
- **[This Document]** - Test writing standards

## 12. Development Workflow

1. **Implement Algorithm** (follow [COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md))
2. **Write Test Class** (follow these guidelines)
3. **Run Verification** (`mvn test -Dtest=YourClassNameTest`)
4. **Quality Check** (ensure all tests pass with clear messages)
5. **Submit Code** (with complete comments and comprehensive tests)

---

**Reference Examples**:
- **problem package tests**: `src/test/java/com/flyingcode/problem/Algo025MaxIncSubseqTest.java`
- **leetcode package tests**: `src/test/java/com/flyingcode/leetcode/Leet0070ClimbStairsTest.java`
- **Tree structure tests**: `src/test/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversalTest.java`
