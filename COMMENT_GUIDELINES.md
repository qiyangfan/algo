# Code Comment Guidelines

## Important Formatting Rules

**Language & Punctuation Standards**:
- **Use Chinese** for all code comments, documentation, and descriptions
- **[强制要求]** 使用英文标点符号 在所有文本中（逗号、句号、冒号、分号等）- **[绝对禁止]** 使用中文标点符号
- This is a CRITICAL requirement - all Chinese comments must use English punctuation marks exclusively!
- **No emoji**: Do not use emoji symbols in any code comments or documentation


## Important Language Notice

Although this guideline document is written in English, all code comments generated according to these guidelines MUST be written in Chinese.

## Related Documentation

- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide
- **[TEST_GUIDELINES.md](TEST_GUIDELINES.md)** - Test class writing standards

---

## 1. Overview

This document defines standards for Java code comments in this LeetCode algorithm practice project. All code must strictly follow these standards to ensure consistency and readability.

**Important Note**: Contributors are responsible for adding comments only. Do not compile code, generate class files, or write test classes.

## 2. General Rules

### 2.1 Core Principles
- **Language & Punctuation**: Chinese text with English punctuation marks only - this is a CRITICAL requirement
- **[强制要求]** 所有中文注释必须使用英文标点符号, 不得使用任何中文标点
- **Symbol Usage**: Avoid special characters (², ³, ≥, ≤) - use keyboard-friendly alternatives (k*k, >=, <=)
- **No Emoji**: No emoji symbols (check marks, crosses, warning signs, etc.) in comments
- **Concise & Clear**: Avoid redundancy, explain only necessary information
- **Accurate**: Keep comments synchronized with code changes
- **No Obvious Comments**: Skip self-evident explanations like `int i = 0; // initialize i to 0`

### 2.2 Scope of Responsibility
- Correct:  Add code comments following these standards
- Wrong:  Do not compile code
- Wrong:  Do not generate class files
- Wrong:  Do not write test classes
- Report algorithm issues to relevant personnel

## 3. Comment Structure Standards

### 3.1 Javadoc Format
```java
/**
 * Multi-line comment
 * Each line starts with *
 * Separate paragraphs with blank lines
 */
```

### 3.2 Inline Comment Format
```java
// Single-line comment with space after //

int n = nums.length;  // End-of-line comment

/* Multi-line block comment
 * for complex explanations
 */
```

## 4. Algorithm Class Comment Structure

Complete algorithm class comments follow this order:

```
1. Class-Level Comment
   └─ Algorithm title, purpose, core technique, characteristics

2. Algorithm Design Approach (算法设计思路)
   └─ Numbered implementation steps, key techniques

3. Algorithm Complexity Analysis (算法复杂度分析)
   └─ Time complexity, space complexity with explanations

4. Method-Level Comment
   └─ Functional description, @param, @return, @throws

5. Implementation Step Comments
   └─ Inline comments for key logic
```

## 5. Comment Types and Templates

### 5.1 Class-Level Comment

**Location**: Before class definition
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * [算法中文名称]
 * 该类提供一个[算法特点]的算法, 用于[具体功能描述].
 * 算法采用[核心技术], 实现[性能特点].
 * [可选 - 其他重要特点]
 */
```

**Example**:
```java
/**
 * 最长连续递增子序列长度
 * 该类提供一个高效的算法, 用于查找未排序数组中最长的连续递增子序列的长度.
 * 算法采用单次遍历技术, 实现了线性时间复杂度, 空间复杂度为 O(1).
 */
```

### 5.2 Algorithm Design Approach

**Location**: Inside class, before methods
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * 算法设计思路:
 * 1. [第一步描述]
 * 2. [第二步描述]
 *    - [子步骤或细节]
 * 3. [第三步描述]
 * ...
 *
 * [可选 - 关键技术点]
 * - [技术点1]
 * - [技术点2]
 */
```

**Example**:
```java
/**
 * 算法设计思路:
 * 1. 维护两个计数器: maxLength记录全局最长长度, currentLength记录当前连续递增序列长度
 * 2. 从第二个元素开始遍历数组, 比较当前元素与前一个元素的大小关系
 * 3. 如果当前元素大于前一个元素, 说明连续递增序列继续, 当前长度加1
 * 4. 如果当前元素小于等于前一个元素, 说明连续递增序列中断, 重新开始计数, 当前长度重置为1
 * 5. 每次更新当前长度时, 同步更新全局最大长度, 取两者中的较大值
 */
```

### 5.3 Algorithm Complexity Analysis

**Location**: After algorithm design approach, before methods
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O([大O表示]), 其中 n 是[输入规模说明].
 *   [复杂度推导或解释]
 * - 空间复杂度: O([大O表示]).
 *   [空间使用说明]
 */
```

**Example**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n), 其中 n 是数组的长度.
 *   因为只需要遍历数组一次, 每个元素只访问一次, 所以总操作次数是线性的.
 * - 空间复杂度: O(1), 只使用了常量级的额外空间(两个整型变量).
 *   算法是原地计算, 没有使用额外的数组或数据结构.
 */
```

### 5.4 Method-Level Comment

**Location**: Before method definition
**Format**: Javadoc with tags

**Template**:
```java
/**
 * [方法功能描述]
 *
 * @param [参数名] [参数说明]
 * @return [返回值说明]
 * @throws [异常类型] [异常说明]
 */
```

**Example**:
```java
/**
 * Removes duplicates from a sorted array in-place and returns the new length
 *
 * @param nums the input sorted integer array, note that this array will be modified in-place
 * @return the new length of the array after removing duplicates
 * @throws NullPointerException if the input array is null
 */
public static int solution(int[] nums) {
    // Method implementation...
}
```

### 5.5 Implementation Step Comments

**Location**: Inside method, before or after key code lines
**Format**: Inline comments `//`

**Example**:
```java
// Get array length
int n = nums.length;

// Boundary condition handling: empty array returns 0 directly
if (n == 0) {
    return 0;
}

// Slow pointer: always points to the position of the last processed non-duplicate element
// Initial value is 0, indicating the first element of the array is guaranteed to be non-duplicate
int slow = 0;
```

## 6. Complete Algorithm Class Template

```java
package com.flyingcode.[package-name]; // 根据实际包名替换: problem 或 leetcode

/**
 * [算法中文名称]
 * 该类提供一个[算法特点]的算法, 用于[具体功能描述].
 * 算法采用[核心技术], 实现[性能特点].
 */
public class [ClassName] {
// ClassName 命名格式:
// - problem 包: AlgoXXXAlgorithmName (如 Algo025MaxLengthContinuousIncreasingSubsequenceArray)
// - leetcode 包: LeetXXXXProblemName (如 Leet0070ClimbStairs)

    /**
     * 算法设计思路:
     * 1. [步骤1描述]
     * 2. [步骤2描述]
     * 3. [步骤3描述]
     * ...
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O([复杂度]), 其中 n 是[输入规模].
     *   [复杂度推导说明]
     * - 空间复杂度: O([复杂度]).
     *   [空间使用说明]
     */

    /**
     * [方法功能描述]
     *
     * @param [参数名] [参数说明]
     * @return [返回值说明]
     */
    public [return-type] solution([parameters]) {
        // Implementation with inline comments
    }
}
```

## 7. Best Practices

### 7.1 Language Consistency
- All comments in **Chinese**
- Technical terms in English (O(n), BFS, DFS, Union-Find)
- Variable/method names follow Java conventions (English)

### 7.2 Comment Quality
- Use consistent terminology across similar algorithms
- Maintain parallel structure in numbered lists
- Uniform complexity notation (always "O(n)", not "O(n)")
- Include "关键技术点" section only for non-obvious optimizations

### 7.3 When to Add "关键技术点" Section
Include when algorithm uses:
- Non-obvious optimization techniques
- Important data structure choices
- Special mathematical or logical tricks
- Multiple phases with distinct strategies

**For straightforward algorithms, numbered steps are sufficient.**

## 8. Supporting Documentation System

The project provides complete documentation:

- **[CLAUDE.md](CLAUDE.md)** - Project overview and architecture
- **[TEST_GUIDELINES.md](TEST_GUIDELINES.md)** - Test writing standards
- **[This Document]** - Code comment standards

## 9. Development Workflow

1. **Implement Algorithm Class**
   - Create class following [CLAUDE.md](CLAUDE.md)
   - Add complete comments per these standards
   - Implement `solution()` method

2. **Write Test Class**
   - Follow [TEST_GUIDELINES.md](TEST_GUIDELINES.md)
   - Create corresponding test class
   - Ensure comprehensive test coverage

3. **Run Verification**
   - Run tests to verify functionality
   - Check comment completeness
   - Submit code

## 10. Reference Examples

Complete commented examples in project:
- **problem 包示例**: `src/main/java/com/flyingcode/problem/Algo025MaxLengthContinuousIncreasingSubsequenceArray.java`
- **leetcode 包示例**: `src/main/java/com/flyingcode/leetcode/Leet0070ClimbStairs.java`
- 所有算法类都遵循此标准
