# Test Class Writing Guidelines

## Important Formatting Rules

**Language & Punctuation Standards** (MANDATORY - STRICTLY ENFORCED):
- **[强制要求] 所有输出必须使用中文**：包括测试类注释、@DisplayName和断言消息
- **[强制要求] 所有标点必须使用英文**：包括逗号、句号、冒号等，绝对禁止使用中文标点
- **[强制要求] 禁止使用emoji**：任何测试代码或注释中都不允许使用emoji符号

**Examples**:
- Correct:  `@DisplayName("测试基本功能: 标准数组")` - 中文文本配合英文冒号(:)
- Wrong:  `@DisplayName("测试基本功能: 标准数组")` - 使用了中文冒号(:)
- Correct:  `assertEquals(3, result, "数组长度应该为3")` - 中文文本配合英文逗号(,)
- Wrong:  `assertEquals(3, result, "数组长度应该为3, ")` - 使用了中文逗号(,)

## Related Documentation

- **[CLAUDE.md](CLAUDE.md)** - Project overview and development guide
- **[COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md)** - Algorithm class comment standards

---

## 1. Overview

This document defines standards for writing Java test classes using JUnit 5. All test classes must follow these standards to ensure consistency, maintainability, and comprehensive coverage.

**Core Principle**: Test classes should focus on verifying algorithm correctness and boundary conditions. Each test case must be independent, clear, and self-explanatory.

## 2. General Rules

### 2.1 Test Independence
- Each test method runs independently
- No dependency on execution order or other test results
- Create new object instances for each test

### 2.2 Naming Conventions
- Test class: `TestedClassName + Test`
- Test methods: `test + specificTestScenario`
- Use descriptive, self-documenting names

### 2.3 Language & Punctuation
- **Chinese text with English punctuation** in all test elements
- Clear assertion messages explaining expected results

### 2.4 Coverage Standards
- Basic functionality tests
- Boundary condition tests
- Special case tests
- Complex scenario tests

## 3. Test Class Structure

### 3.1 Package and Imports

**Location**: Beginning of file

**Standard Order**:
1. Package declaration
2. Static imports (assertion methods)
3. JUnit 5 annotations
4. Tested classes and data structures

**Example**:
```java
package com.flyingcode.problem; // 根据实际情况使用: problem 或 leetcode

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode; // 根据需要导入数据结构
import com.flyingcode.[package-name].[TestedClassName]; // 导入被测试的算法类
```

### 3.2 Class Declaration

**Code Style**:
- Package-private (no `public` modifier)
- Package-private test methods (no `public` modifier)

**Class-Level Comment Template**:
```java
/**
 * Test Class: [TestedClassName]
 * Uses JUnit 5 to test the correctness of [algorithm/functionality description]
 */
class [TestedClassName]Test {
    // Test methods...
}
// 测试类命名规则:
// - problem 包算法: AlgoXXXClassNameTest (如 Algo025MaxLengthContinuousIncreasingSubsequenceArrayTest)
// - leetcode 包算法: LeetXXXXProblemNameTest (如 Leet0070ClimbStairsTest)
// - 统一遵循: TestedClassName + Test 格式
```

### 3.3 Test Method Structure

**AAA Pattern** (Arrange-Act-Assert):
```java
@Test
@DisplayName("测试场景描述")
void testSpecificScenario() {
    // 准备测试数据
    [TestedClassName] algo = new [TestedClassName]();
    [InputType] input = [inputValue];

    // 执行测试方法
    [ReturnType] result = algo.solution(input);

    // 验证结果
    assertEquals([expectedValue], result, "清晰的断言消息说明预期结果");
}
// 占位符说明:
// - [TestedClassName]: 被测试的算法类名 (如 Algo025MaxLengthContinuousIncreasingSubsequenceArray 或 Leet0070ClimbStairs)
// - [InputType]: 输入参数类型 (如 int[], int, TreeNode 等)
// - [inputValue]: 具体的测试输入值
// - [ReturnType]: 方法返回类型
// - [expectedValue]: 预期的测试结果
```

## 4. Test Case Design

### 4.1 Basic Functionality Tests (2-3 tests)

**Purpose**: 验证算法在标准条件下的正确性

**Examples**:
```java
/**
 * 测试基本功能: 包含多个元素的标准数组
 */
@Test
@DisplayName("测试基本功能: 包含多个元素的标准数组")
void testStandardArray() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { 1, 3, 5, 4, 7 };
    int result = algo.solution(nums);
    assertEquals(3, result, "预期结果说明");
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
    AlgoXXX algo = new AlgoXXX();
    int[] nums = {};
    int result = algo.solution(nums);
    assertEquals(0, result, "空数组应该返回0");
}

/**
 * 测试边界条件: null数组
 */
@Test
@DisplayName("测试边界条件: null数组")
void testNullArray() {
    AlgoXXX algo = new AlgoXXX();
    int result = algo.solution(null);
    assertEquals(0, result, "null数组应该返回0");
}

/**
 * 测试单元素数组
 */
@Test
@DisplayName("测试单元素数组")
void testSingleElement() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { 1 };
    int result = algo.solution(nums);
    assertEquals(1, result, "单元素数组应该返回1");
}
```

### 4.3 Special Case Tests (3-4 tests)

**Common Special Cases**:
- All elements identical
- Completely increasing/decreasing
- Contains negative numbers, zeros
- Duplicate elements

**Examples**:
```java
/**
 * 测试特殊情况: 所有元素相同
 */
@Test
@DisplayName("测试特殊情况: 所有元素相同")
void testAllSameElements() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { 2, 2, 2, 2, 2 };
    int result = algo.solution(nums);
    assertEquals(1, result, "所有元素相同的数组应该返回1");
}

/**
 * 测试特殊情况: 完全递增的数组
 */
@Test
@DisplayName("测试特殊情况: 完全递增的数组")
void testFullyIncreasingArray() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { 1, 2, 3, 4, 5 };
    int result = algo.solution(nums);
    assertEquals(5, result, "完全递增的数组应该返回5");
}

/**
 * 测试特殊情况: 包含负数的数组
 */
@Test
@DisplayName("测试特殊情况: 包含负数的数组")
void testArrayWithNegativeNumbers() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { -2, -1, 0, 1, 2 };
    int result = algo.solution(nums);
    assertEquals(5, result, "包含负数的数组应该正常工作");
}
```

### 4.4 Complex Scenario Tests (2-3 tests)

**Common Complex Scenarios**:
- Long arrays
- Multiple solutions
- Extreme condition combinations
- Fluctuating patterns

**Examples**:
```java
/**
 * 测试复杂场景: 长数组中的多个序列
 */
@Test
@DisplayName("测试复杂场景: 长数组中的多个序列")
void testLongArrayWithMultipleSequences() {
    AlgoXXX algo = new AlgoXXX();
    int[] nums = { 1, 2, 3, 1, 2, 3, 4, 5, 2, 3 };
    int result = algo.solution(nums);
    assertEquals(5, result, "最长序列应该被正确识别");
}
```

### 4.5 Data Structure Tests (Trees, Linked Lists)

**Visual Documentation**: Use ASCII art

**Example**:
```java
/**
 * 测试三层平衡二叉树
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 */
@Test
@DisplayName("测试三层平衡二叉树")
void testBalancedTree() {
    AlgoXXX algo = new AlgoXXX();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    int result = algo.solution(root);
    assertEquals(3, result, "平衡树的深度应该是3");
}
```

## 5. Assertion Standards

### 5.1 Assertion Method Selection

| Method | Use Case |
|--------|----------|
| `assertEquals(expected, actual)` | Basic type equality |
| `assertArrayEquals(expected, actual)` | Array equality |
| `assertTrue(condition)` | Verify condition is true |
| `assertFalse(condition)` | Verify condition is false |
| `assertNull(actual)` | Verify is null |
| `assertNotNull(actual)` | Verify is not null |

### 5.2 Assertion Message Standards

**Must Include**:
- Clear description of expected results
- Test scenario context
- Debugging information

**Good Examples**:
```java
assertEquals(3, result, "数组[1,3,5,4,7]中最长连续递增子序列是[1,3,5], 长度为3");
assertEquals(0, result, "空数组应该返回0");
assertEquals(2, result, "两个递增元素[1,2]的长度应该是2");
```

**Bad Examples**:
```java
assertEquals(3, result);  // 缺少描述
assertEquals(3, result, "失败");  // 消息不清晰
assertEquals(3, result, "应该是3");  // 缺少上下文
```

## 6. Test Organization

### 6.1 Recommended Order

1. Basic functionality tests
2. Boundary condition tests
3. Special case tests
4. Complex scenario tests
5. Extreme case tests

### 6.2 Test Quantity Guidelines

- **Minimum**: 5 tests
  - 1 basic functionality
  - 2-3 boundary conditions
  - 1-2 special cases

- **Recommended**: 8-15 tests
  - 2-3 basic functionality
  - 3-4 boundary conditions
  - 3-4 special cases
  - 2-3 complex scenarios

- **Complete**: 15+ tests
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
 * Test Class: Algo025MaxLengthContinuousIncreasingSubsequenceArray
 * Uses JUnit 5 to test the correctness of the longest continuous increasing subsequence algorithm
 */
class Algo025MaxLengthContinuousIncreasingSubsequenceArrayTest {

    /**
     * Test basic functionality: standard array with multiple increasing sequences
     */
    @Test
    @DisplayName("Test standard array with multiple increasing sequences")
    void testStandardArray() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int[] nums = { 1, 3, 5, 4, 7 };
        int result = algo.solution(nums);
        assertEquals(3, result, "The longest continuous increasing subsequence in array [1,3,5,4,7] is [1,3,5], length is 3");
    }

    /**
     * Test boundary condition: empty array
     */
    @Test
    @DisplayName("Test boundary condition: empty array")
    void testEmptyArray() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(0, result, "Empty array should return 0");
    }

    /**
     * Test boundary condition: null array
     */
    @Test
    @DisplayName("Test boundary condition: null array")
    void testNullArray() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int result = algo.solution(null);
        assertEquals(0, result, "Null array should return 0");
    }

    /**
     * Test single element
     */
    @Test
    @DisplayName("Test single element")
    void testSingleElement() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int[] nums = { 1 };
        int result = algo.solution(nums);
        assertEquals(1, result, "Single element array should return 1");
    }

    /**
     * Test completely increasing array
     */
    @Test
    @DisplayName("Test completely increasing array")
    void testFullyIncreasingArray() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(5, result, "Completely increasing array [1,2,3,4,5] should have length 5");
    }

    /**
     * Test all elements identical
     */
    @Test
    @DisplayName("Test all elements identical")
    void testAllSameElements() {
        Algo025MaxLengthContinuousIncreasingSubsequenceArray algo = new Algo025MaxLengthContinuousIncreasingSubsequenceArray();
        int[] nums = { 2, 2, 2, 2, 2 };
        int result = algo.solution(nums);
        assertEquals(1, result, "All identical elements should have length 1");
    }
}
```

### 7.2 Tree Structure Test

```java
package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.TreeNode;

/**
 * Test Class: Algo024MinDepthBinaryTreeBreadthFirstSearch
 * Uses JUnit 5 to test the binary tree minimum depth calculation using BFS
 */
class Algo024MinDepthBinaryTreeBreadthFirstSearchTest {

    /**
     * Test empty tree case
     */
    @Test
    @DisplayName("Test empty tree: null node should return depth 0")
    void testNullTree() {
        Algo024MinDepthBinaryTreeBreadthFirstSearch algo = new Algo024MinDepthBinaryTreeBreadthFirstSearch();
        int result = algo.solution(null);
        assertEquals(0, result, "Empty tree should return depth 0");
    }

    /**
     * Test tree with only root node
     */
    @Test
    @DisplayName("Test only root node: single node tree depth is 1")
    void testSingleRootNode() {
        Algo024MinDepthBinaryTreeBreadthFirstSearch algo = new Algo024MinDepthBinaryTreeBreadthFirstSearch();
        TreeNode root = new TreeNode(1);
        int result = algo.solution(root);
        assertEquals(1, result, "Single node tree should have depth 1");
    }

    /**
     * Test balanced binary tree
     *       1
     *      / \
     *     2   3
     */
    @Test
    @DisplayName("Test balanced tree: two-level complete binary tree")
    void testBalancedTree() {
        Algo024MinDepthBinaryTreeBreadthFirstSearch algo = new Algo024MinDepthBinaryTreeBreadthFirstSearch();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = algo.solution(root);
        assertEquals(2, result, "Two-level balanced tree should have depth 2");
    }
}
```

## 8. Running and Verification

### 8.1 Run Single Test Class
```bash
mvn test -Dtest=AlgoXXXTest  # 运行 problem 包测试类
mvn test -Dtest=LeetXXXXTest  # 运行 leetcode 包测试类
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
Wrong:  **Problem**: `test1()`, `testMethod()`
Correct:  **Solution**: `testEmptyArray()`, `testWithNegativeNumbers()`

### 9.2 Missing Assertion Messages
Wrong:  **Problem**: `assertEquals(3, result)`
Correct:  **Solution**: `assertEquals(3, result, "Expected result is 3 because...")`

### 9.3 Insufficient Coverage
Wrong:  **Problem**: Only normal cases tested
Correct:  **Solution**: Add boundary, special, and complex scenario tests

### 9.4 Interdependent Tests
Wrong:  **Problem**: Tests share state or depend on execution order
Correct:  **Solution**: Ensure each test is independent with new instances

## 10. Best Practices Summary

1. **AAA Pattern**: Arrange-Act-Assert structure
2. **Clear Messages**: Descriptive assertion messages
3. **Independence**: Each test runs alone
4. **Coverage**: Test boundaries, special cases, complex scenarios
5. **Visual Docs**: Use ASCII art for data structures
6. **Language**: Chinese with English punctuation
7. **No Emoji**: Keep code professional
8. **Package-Private**: No public modifier needed

## 11. Documentation System Integration

Complete project documentation:
- **[CLAUDE.md](CLAUDE.md)** - Project structure and architecture
- **[COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md)** - Algorithm comment standards
- **[This Document]** - Test writing standards

## 12. Development Workflow

1. **Implement Algorithm** (follow [COMMENT_GUIDELINES.md](COMMENT_GUIDELINES.md))
2. **Write Test Class** (follow these guidelines)
3. **Run Verification** (`mvn test`)
4. **Quality Check** (ensure all tests pass)
5. **Submit Code** (with complete comments and tests)

---

**Reference**: See existing test classes for complete examples:
- **problem 包测试类**: `src/test/java/com/flyingcode/problem/`
- **leetcode 包测试类**: 遵循相同规范, 命名格式为 `LeetXXXXProblemNameTest`
