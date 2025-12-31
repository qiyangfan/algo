# Code Comment Guidelines

## Important Formatting Rules

**Language & Punctuation Standards**:
- **Use Chinese** for all code comments, documentation, and descriptions
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.) - **[ABSOLUTELY PROHIBITED]** Use Chinese punctuation marks
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

**Project Structure**:
- `leetcode/` - LeetCode problem solutions (naming: LeetXXXXProblemName)
- `problem/` - Algorithm practice problems (naming: AlgoXXXAlgorithmName)
- `sort/` - Sorting algorithm implementations
- `structure/` - Data structure definitions (ListNode, TreeNode, etc.)
- `swordoffer/` - Sword Offer problems

**Important Note**: Contributors are responsible for adding comments only. Do not compile code, generate class files, or write test classes.

**Responsibility Scope**:
- Correct:  Add code comments following these standards
- Wrong:  Do not compile code
- Wrong:  Do not generate class files
- Wrong:  Do not write test classes
- Report algorithm issues to relevant personnel

## 2. General Rules

### 2.1 Core Principles
- **Language & Punctuation**: Chinese text with English punctuation marks only - this is a CRITICAL requirement
- **[MANDATORY]** All Chinese comments must use English punctuation marks, no Chinese punctuation allowed
- **Symbol Usage**: Avoid special characters (², ³, ≥, ≤) - use keyboard-friendly alternatives (k*k, >=, <=)
- **No Emoji**: No emoji symbols (check marks, crosses, warning signs, etc.) in comments
- **Concise & Clear**: Avoid redundancy, explain only necessary information
- **Accurate**: Keep comments synchronized with code changes
- **No Obvious Comments**: Skip self-evident explanations like `int i = 0; // initialize i to 0`

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

### 3.3 Code Indentation
- Use **2 spaces** for indentation (following project style)
- No tab characters
- Consistent indentation across all files

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
   └─ Functional description, @param, @return

5. Implementation Step Comments
   └─ Inline comments for key logic
```

**Note**: Data structure classes (ListNode, TreeNode) only require class-level comments explaining their purpose and structure. No algorithm design or complexity analysis needed.

## 5. Comment Types and Templates

### 5.1 Class-Level Comment

**Location**: Before class definition
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * [Algorithm Chinese Name]
 * 该类提供一个[algorithm feature]的算法, 用于[specific functionality].
 * 算法采用[core technique], 实现[performance characteristic].
 * [Optional - other important features]
 */
```

**Examples**:

**Simple Algorithm**:
```java
/**
 * 最长连续递增子序列长度
 * 该类提供一个高效的算法, 用于查找未排序数组中最长的连续递增子序列的长度.
 * 算法采用单次遍历技术, 实现了线性时间复杂度, 空间复杂度为 O(1).
 */
```

**Algorithm with Special Method**:
```java
/**
 * 预测赢家: 动态规划数组实现
 * 本类提供一个算法, 用于判断在双方从数组两端轮流选择数字的游戏中, 先手玩家是否能获胜.
 * 算法使用动态规划方法, 计算在双方都采用最优策略的情况下, 先手玩家是否能保证获胜或平局.
 */
```

**Multi-Method Algorithm**:
```java
/**
 * 二叉树中序遍历
 * 该类提供两种高效的算法, 用于实现二叉树的中序遍历.
 * 算法采用递归和迭代两种技术, 均实现了线性时间复杂度, 空间复杂度为 O(n).
 */
```

**Sorting Algorithm**:
```java
/**
 * 快速排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分治策略, 选择基准元素将数组分割成两部分, 实现不稳定排序.
 */
```

### 5.2 Algorithm Design Approach

**Location**: Inside class, before methods
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * 算法设计思路:
 * 1. [Step 1 description]
 * 2. [Step 2 description]
 *    - [Sub-step or detail]
 * 3. [Step 3 description]
 * ...
 *
 * [Optional - Key Technical Points]
 * - [Technical point 1]
 * - [Technical point 2]
 */
```

**Examples**:

**Simple Algorithm**:
```java
/**
 * 算法设计思路:
 * 1. 维护两个计数器: maxLength 记录全局最长长度, currentLength 记录当前连续递增序列长度
 * 2. 从第二个元素开始遍历数组, 比较当前元素与前一个元素的大小关系
 * 3. 如果当前元素大于前一个元素, 说明连续递增序列继续, 当前长度加1
 * 4. 如果当前元素小于等于前一个元素, 说明连续递增序列中断, 重新开始计数, 当前长度重置为1
 * 5. 每次更新当前长度时, 同步更新全局最大长度, 取两者中的较大值
 */
```

**Algorithm with Key Techniques**:
```java
/**
 * 算法设计思路:
 * 1. 使用哈希表存储数组元素及其对应的索引, 实现O(1)时间复杂度的查找
 * 2. 遍历数组中的每个元素 nums[i], 计算与目标值的差值 complement = target - nums[i]
 * 3. 检查哈希表中是否存在 complement:
 *    - 若存在, 则找到解, 返回 complement 对应的索引和当前索引 i
 *    - 若不存在, 则将当前元素 nums[i] 及其索引 i 存入哈希表
 * 4. 遍历完成后, 若未找到解则返回空数组
 *
 * 关键技术点:
 * - 哈希表的使用: 空间换时间, 将查找复杂度从O(n)降低到O(1)
 * - 单次遍历: 边遍历边存储, 避免重复计算
 */
```

**Multi-Method Algorithm**:
```java
/**
 * 算法设计思路:
 *
 * 递归实现:
 * 1. 中序遍历的顺序是左子树 -> 根节点 -> 右子树
 * 2. 使用递归实现, 先递归遍历左子树
 * 3. 访问根节点, 将节点值加入结果列表
 * 4. 最后递归遍历右子树
 * 5. 递归终止条件是当前节点为null
 *
 * 迭代实现:
 * 1. 利用栈来模拟递归过程
 * 2. 初始化当前节点指针为根节点
 * 3. 当栈不为空或当前节点不为null时, 循环执行以下操作:
 *    a. 遍历左子树, 将所有左节点入栈, 直到当前节点为null
 *    b. 弹出栈顶节点, 访问该节点, 将其值加入结果列表
 *    c. 将当前节点指针指向右子节点
 */
```

### 5.3 Algorithm Complexity Analysis

**Location**: After algorithm design approach, before methods
**Format**: Javadoc `/** */`

**Template**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O([Big O notation]), 其中 n 是[input scale description].
 *   [Complexity derivation or explanation]
 * - 空间复杂度: O([Big O notation]).
 *   [Space usage description]
 */
```

**Examples**:

**Linear Time, Constant Space**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n), 其中 n 是数组的长度.
 *   因为只需要遍历数组一次, 每个元素只访问一次, 所以总操作次数是线性的.
 * - 空间复杂度: O(1), 只使用了常量级的额外空间(两个整型变量).
 *   算法是原地计算, 没有使用额外的数组或数据结构.
 */
```

**Linear Time, Linear Space**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n), 其中 n 是数组的长度.
 * 因为只需要遍历数组一次, 每个元素的哈希表操作(put和containsKey)都是O(1)时间复杂度
 * - 空间复杂度: O(n).
 * 最坏情况下, 需要将数组中的所有元素存入哈希表, 因此空间复杂度为O(n)
 */
```

**Log-Linear Time, Log Space**:
```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n log n), 其中 n 是数组长度.
 * 平均情况下, 每轮分区将数组分成两个大小相近的子数组, 递归深度为 log n, 每轮分区时间为 O(n)
 * 最坏情况下, 分区不平衡, 时间复杂度为 O(n^2)
 * - 空间复杂度: O(log n).
 * 递归调用栈的深度, 平均情况下为 log n, 最坏情况下为 O(n)
 */
```

**Multi-Method Algorithm**:
```java
/**
 * 算法复杂度分析:
 *
 * 递归实现:
 * - 时间复杂度: O(n), 其中 n 是二叉树的节点数量.
 * 每个节点恰好被访问一次, 因此总时间复杂度是线性的.
 * - 空间复杂度: O(n).
 * 最坏情况下, 当二叉树是一条链时, 递归调用栈的深度会达到n, 因此空间复杂度是O(n).
 *
 * 迭代实现:
 * - 时间复杂度: O(n), 其中 n 是二叉树的节点数量.
 * 每个节点恰好被访问一次, 因此总时间复杂度是线性的.
 * - 空间复杂度: O(n).
 * 最坏情况下, 当二叉树是一条链时, 栈的深度会达到n, 因此空间复杂度是O(n).
 */
```

### 5.4 Method-Level Comment

**Location**: Before method definition
**Format**: Javadoc with tags

**Template**:
```java
/**
 * [Method functionality description]
 *
 * @param [parameter name] [parameter description]
 * @return [return value description]
 */
```

**Note**: @throws is only required for methods that explicitly throw exceptions. Most algorithm methods do not need @throws.

**Examples**:

**Simple Method**:
```java
/**
 * 查找数组中最长连续递增子序列的长度
 *
 * 连续递增子序列是指数组中连续位置的元素严格递增的子序列.
 * 例如: 数组 [1,3,5,4,7] 中, [1,3,5] 和 [4,7] 都是连续递增子序列, 最长长度为3.
 *
 * @param nums 输入的整数数组, 可以包含负数, 零和正数, 无需排序
 * @return 最长连续递增子序列的长度; 如果数组为空或null, 返回0
 */
public int solution(int[] nums) {
    // Implementation
}
```

**Method with Constraints**:
```java
/**
 * 计算爬楼梯的不同方法数
 *
 * @param n 楼梯的阶数, 范围为1 <= n <= 45
 * @return 到达第n阶的不同方法数
 */
public int solution(int n) {
    // Implementation
}
```

**Method with Detailed Explanation**:
```java
/**
 * 在整数数组中查找两个数, 使其和等于目标值, 并返回这两个数的索引
 *
 * @param nums   整数数组, 长度范围为2 <= nums.length <= 10^4, 元素范围为-10^9 <= nums[i] <= 10^9
 * @param target 目标值, 范围为-10^9 <= target <= 10^9
 * @return 包含两个数的索引的数组, 索引范围为0 <= index1, index2 < nums.length, 且index1 < index2
 */
public int[] twoSum(int[] nums, int target) {
    // Implementation
}
```

**Helper Method**:
```java
/**
 * 递归辅助函数, 用于实现中序遍历
 *
 * @param node   当前遍历的节点
 * @param result 存储遍历结果的列表
 */
private void inorderTraversal(TreeNode node, List<Integer> result) {
    // Implementation
}
```

### 5.5 Implementation Step Comments

**Location**: Inside method, before or after key code lines
**Format**: Inline comments `//`

**Principles**:
- Comment **why**, not **what** (the code already shows what)
- Focus on key logic, boundary conditions, and algorithm steps
- Use blank lines to separate logical sections
- Multi-line comments should be placed before the code they explain

**Comment Style Guidelines**:
- Explain the purpose and reasoning behind code
- Describe algorithm steps and logic flow
- Clarify boundary condition handling
- Document variable purposes and invariants
- Note important data structure operations

**Examples**:

**Variable Initialization with Context**:
```java
// 边界条件处理: 空数组或null直接返回0
if (nums == null || nums.length == 0) {
    return 0;
}

// 全局最大长度: 记录遍历过程中找到的最长连续递增子序列长度
// 初始值为1, 因为非空数组至少有一个元素, 最小长度为1
int maxLength = 1;

// 当前连续递增序列长度: 记录当前正在遍历的连续递增序列的长度
// 初始值为1, 表示从数组的第一个元素开始计数
int currentLength = 1;
```

**Algorithm Logic Explanation**:
```java
// 从数组的第二个元素开始遍历(索引为1), 与前一元素比较
for (int i = 1; i < nums.length; i++) {
    // 判断当前元素是否大于前一个元素
    if (nums[i] > nums[i - 1]) {
        // 当前元素大于前一元素, 连续递增序列继续
        // 当前递增序列长度加1
        currentLength++;

        // 更新全局最大长度
        // 比较当前连续递增序列长度和历史最大长度, 取较大值作为新的全局最大长度
        maxLength = Math.max(maxLength, currentLength);
    } else {
        // 当前元素小于等于前一元素, 连续递增序列中断
        // 从当前元素重新开始计数, 当前长度重置为1
        currentLength = 1;
    }
}
```

**Loop Invariant**:
```java
// 当前阶的方法数 = 到达第i-1阶的方法数 + 到达第i-2阶的方法数
current = prevPrev + prev;
// 更新状态: 前前一阶变为前一阶, 前一阶变为当前阶
prevPrev = prev;
prev = current;
```

**Data Structure Operations**:
```java
// 遍历数组中的每个元素
for (int i = 0; i < nums.length; i++) {
    // 计算当前元素与目标值的差值
    int complement = target - nums[i];

    // 检查差值是否已经存在于HashMap中
    if (map.containsKey(complement)) {
        // 若存在, 则返回差值对应的索引和当前索引
        return new int[] { map.get(complement), i };
    }

    // 若不存在, 则将当前元素和其索引添加到HashMap中
    map.put(nums[i], i);
}
```

**Boundary Condition Handling**:
```java
// 边界条件: 数组为空或为null, 先手玩家无法获胜
if (nums == null || nums.length == 0) {
    return false;
}
```

## 6. Complete Algorithm Class Templates

### 6.1 Standard Algorithm Template

```java
package com.flyingcode.problem; // or leetcode, sort, swordoffer

/**
 * [Algorithm Chinese Name]
 * 该类提供一个[algorithm feature]的算法, 用于[specific functionality].
 * 算法采用[core technique], 实现[performance characteristic].
 */
public class AlgoXXXProblemName {
  // Naming format:
  // - problem package: AlgoXXXAlgorithmName (e.g., Algo025MaxIncSubseq)
  // - leetcode package: LeetXXXXProblemName (e.g., Leet0070ClimbStairs)
  // - sort package: AlgorithmName (e.g., QuickSort)

  /**
   * 算法设计思路:
   * 1. [Step 1 description]
   * 2. [Step 2 description]
   *    - [Sub-step or detail]
   * 3. [Step 3 description]
   *
   * 关键技术点:
   * - [Technical point 1]
   * - [Technical point 2]
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O([complexity]), 其中 n 是[input scale].
   *   [Complexity derivation explanation]
   * - 空间复杂度: O([complexity]).
   *   [Space usage explanation]
   */

  /**
   * [Method functionality description]
   *
   * @param [parameter name] [parameter description]
   * @return [return value description]
   */
  public int solution(int[] nums) {
    // 边界条件处理
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 算法实现
    // ...

    return result;
  }
}
```

### 6.2 Multi-Method Algorithm Template

```java
package com.flyingcode.leetcode;

/**
 * [Algorithm Chinese Name]
 * 该类提供多种算法实现, 用于[specific functionality].
 * 算法采用[core technique 1]和[core technique 2], 均实现[performance characteristic].
 */
public class LeetXXXXProblemName {

  /**
   * 算法设计思路:
   *
   * Method 1 implementation:
   * 1. [Step 1 description]
   * 2. [Step 2 description]
   *
   * Method 2 implementation:
   * 1. [Step 1 description]
   * 2. [Step 2 description]
   */

  /**
   * 算法复杂度分析:
   *
   * Method 1:
   * - 时间复杂度: O(n)
   * - 空间复杂度: O(n)
   *
   * Method 2:
   * - 时间复杂度: O(n)
   * - 空间复杂度: O(1)
   */

  /**
   * [Method 1 functionality description]
   */
  public List<Integer> solution(TreeNode root) {
    // 方法1实现
  }

  /**
   * [Method 2 functionality description]
   */
  public List<Integer> solutionIterative(TreeNode root) {
    // 方法2实现
  }
}
```

### 6.3 Data Structure Class Template

```java
package com.flyingcode.structure;

/**
 * [Data Structure Name]
 * 该类提供一个[data structure type], 用于[specific purpose].
 *
 * [Field description]
 * [Usage scenario]
 */
public class DataStructureName {
  // 字段声明
  public int val;
  public DataStructureName next;

  /**
   * 构造函数
   *
   * @param val [Parameter description]
   */
  public DataStructureName(int val) {
    this.val = val;
  }

  // 工具方法 (可选)
  // ...
}
```

## 7. Best Practices

### 7.1 Language Consistency
- All comments in **Chinese**
- Technical terms in English (O(n), BFS, DFS, Union-Find, HashMap)
- Variable/method names follow Java conventions (English)
- Complexity notation always use "O(n)" format, not "O(n)" (without spaces)

### 7.2 Comment Quality
- Use consistent terminology across similar algorithms
- Maintain parallel structure in numbered lists
- Focus on **why** and **how**, not just **what**
- Include "关键技术点" section only for non-obvious optimizations
- Avoid redundant comments that repeat what the code already shows

### 7.3 When to Add "关键技术点" Section
Include when algorithm uses:
- Non-obvious optimization techniques (e.g., rolling array, two pointers)
- Important data structure choices (e.g., HashMap for O(1) lookup)
- Special mathematical or logical tricks (e.g., XOR, bit manipulation)
- Multiple phases with distinct strategies

**For straightforward algorithms, numbered steps are sufficient.**

### 7.4 Naming Conventions

**Class Naming**:
- `problem/` package: `AlgoXXXProblemName` (e.g., `Algo025MaxIncSubseq`)
- `leetcode/` package: `LeetXXXXProblemName` (e.g., `Leet0070ClimbStairs`)
- `sort/` package: `AlgorithmName` (e.g., `QuickSort`, `MergeSort`)
- `swordoffer/` package: `SwordOfferXXProblemName`

**Method Naming**:
- Main entry method: `solution()` (returns algorithm result)
- Alternative implementations: `solutionIterative()`, `solutionRecursive()`
- Helper methods: descriptive names like `inorderTraversal()`, `partition()`

### 7.5 Special Algorithm Patterns

**Dynamic Programming Algorithms**:
- Clearly explain the DP state definition (e.g., `dp[i][j]` represents...)
- Explain state transition logic
- Mention space optimization if applicable

**Recursive Algorithms**:
- Explain base cases (termination conditions)
- Describe recursive relation
- Mention time/space complexity considering recursion depth

**Graph/Tree Algorithms**:
- Clarify traversal strategy (BFS/DFS/preorder/inorder/postorder)
- Explain data structure choices (queue for BFS, stack for DFS)
- Mention visited state handling if applicable

**Sorting Algorithms**:
- Specify if stable or unstable
- Mention best/average/worst case scenarios
- Explain partition/merge strategy if applicable

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

**Simple Algorithm**:
- `src/main/java/com/flyingcode/problem/Algo025MaxIncSubseq.java`

**Hash Table Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0001TwoSum.java`

**Dynamic Programming Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0070ClimbStairs.java`
- `src/main/java/com/flyingcode/problem/Algo032PredictWinnerDP.java`

**Multi-Method Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversal.java`

**Sorting Algorithm**:
- `src/main/java/com/flyingcode/sort/QuickSort.java`

**Data Structure**:
- `src/main/java/com/flyingcode/structure/ListNode.java`
- `src/main/java/com/flyingcode/structure/TreeNode.java`

## 11. Common Mistakes to Avoid

### 11.1 Punctuation Issues
- Wrong: Using Chinese punctuation marks (Chinese commas, periods, etc.)
- Correct: Using English punctuation marks

### 11.2 Comment Quality Issues
- Wrong: Comments repeat code content (e.g., `i++; // increment i`)
- Correct: Comments explain logical reasoning (e.g., `i++; // move to next position`)

### 11.3 Complexity Analysis Issues
- Wrong: O(n) (inconsistent spacing)
- Correct: O(n) (uniform format, no spaces)

### 11.4 Incomplete Comments
- Wrong: Missing algorithm design approach
- Wrong: Missing complexity analysis
- Wrong: Missing method-level Javadoc
- Correct: Complete comments for all sections

### 11.5 Language Mixing
- Wrong: Mixing Chinese and English in descriptions
- Correct: Chinese comments with English technical terms only
