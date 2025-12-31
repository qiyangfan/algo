# Code Comment Rules

## Important Formatting Rules

**MANDATORY Language & Punctuation Standards**:
- **[MANDATORY]** Use Chinese for all code comments, documentation, and descriptions
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.)
- **[ABSOLUTELY PROHIBITED]** Chinese punctuation marks (Chinese commas, periods, etc.)
- **[MANDATORY]** No emoji symbols in any code comments or documentation

## Related Documentation

- **[COMMENT_EXAMPLES.md](COMMENT_EXAMPLES.md)** - Code comment examples and templates
- **[TEST_RULES.md](TEST_RULES.md)** - Test class writing standards
- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide

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
- Report:  Report algorithm issues to relevant personnel

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

## 5. Comment Types and Requirements

### 5.1 Class-Level Comment

**Location**: Before class definition
**Format**: Javadoc `/** */`

**Required Elements**:
- Algorithm Chinese name
- Algorithm feature description
- Core technique used
- Performance characteristics

**Template Structure**:
```java
/**
 * [Algorithm Chinese Name]
 * 该类提供一个[algorithm feature]的算法, 用于[specific functionality].
 * 算法采用[core technique], 实现[performance characteristic].
 * [Optional - other important features]
 */
```

### 5.2 Algorithm Design Approach

**Location**: Inside class, before methods
**Format**: Javadoc `/** */`

**Required Elements**:
- Numbered implementation steps
- Step descriptions with Chinese text
- Optional: Key technical points section

**When to Include "关键技术点" Section**:
Include only when algorithm uses:
- Non-obvious optimization techniques (e.g., rolling array, two pointers)
- Important data structure choices (e.g., HashMap for O(1) lookup)
- Special mathematical or logical tricks (e.g., XOR, bit manipulation)
- Multiple phases with distinct strategies

**For straightforward algorithms, numbered steps are sufficient.**

### 5.3 Algorithm Complexity Analysis

**Location**: After algorithm design approach, before methods
**Format**: Javadoc `/** */`

**Required Elements**:
- Time complexity with Big O notation
- Space complexity with Big O notation
- Explanations for both

**Complexity Format**:
- Always use "O(n)" format, not "O(n)" (without spaces)
- Include input scale description (e.g., "where n is array length")
- Provide derivation or explanation for complexity

### 5.4 Method-Level Comment

**Location**: Before method definition
**Format**: Javadoc with tags

**Required Elements**:
- Functional description
- @param for each parameter
- @return for return value

**Note**: @throws is only required for methods that explicitly throw exceptions. Most algorithm methods do not need @throws.

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

## 6. Complete Algorithm Class Structure

### 6.1 Standard Algorithm Class

**Required Sections**:
1. Package declaration
2. Class-level comment
3. Algorithm design approach
4. Algorithm complexity analysis
5. Method(s) with comments
6. Inline implementation comments

### 6.2 Multi-Method Algorithm Class

**Additional Requirements**:
- Separate complexity analysis for each method
- Clear method naming indicating implementation type
- Method-specific comments explaining differences

### 6.3 Data Structure Class

**Simplified Requirements**:
- Class-level comment only
- Field descriptions
- Constructor comments
- No algorithm design or complexity analysis

## 7. Best Practices

### 7.1 Language Consistency

- All comments in **Chinese**
- Technical terms in English (O(n), BFS, DFS, Union-Find, HashMap)
- Variable/method names follow Java conventions (English)
- Complexity notation always use "O(n)" format

### 7.2 Comment Quality

- Use consistent terminology across similar algorithms
- Maintain parallel structure in numbered lists
- Focus on **why** and **how**, not just **what**
- Include "关键技术点" section only for non-obvious optimizations
- Avoid redundant comments that repeat what the code already shows

### 7.3 Naming Conventions

**Class Naming**:
- `problem/` package: `AlgoXXXProblemName` (e.g., `Algo025MaxIncSubseq`)
- `leetcode/` package: `LeetXXXXProblemName` (e.g., `Leet0070ClimbStairs`)
- `sort/` package: `AlgorithmName` (e.g., `QuickSort`, `MergeSort`)
- `swordoffer/` package: `SwordOfferXXProblemName`

**Method Naming**:
- Main entry method: `solution()` (returns algorithm result)
- Alternative implementations: `solutionIterative()`, `solutionRecursive()`
- Helper methods: descriptive names like `inorderTraversal()`, `partition()`

### 7.4 Special Algorithm Patterns

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

- **[COMMENT_EXAMPLES.md](COMMENT_EXAMPLES.md)** - Code comment examples and templates
- **[TEST_RULES.md](TEST_RULES.md)** - Test writing standards
- **[CLAUDE.md](CLAUDE.md)** - Project overview and architecture

## 9. Development Workflow

1. **Implement Algorithm Class**
   - Create class following [CLAUDE.md](CLAUDE.md)
   - Add complete comments per these standards
   - Implement `solution()` method

2. **Write Test Class**
   - Follow [TEST_RULES.md](TEST_RULES.md)
   - Create corresponding test class
   - Ensure comprehensive test coverage

3. **Run Verification**
   - Run tests to verify functionality
   - Check comment completeness
   - Submit code

## 10. Common Mistakes to Avoid

### 10.1 Punctuation Issues

- Wrong: Using Chinese punctuation marks (Chinese commas, periods, etc.)
- Correct: Using English punctuation marks

### 10.2 Comment Quality Issues

- Wrong: Comments repeat code content (e.g., `i++; // increment i`)
- Correct: Comments explain logical reasoning (e.g., `i++; // move to next position`)

### 10.3 Complexity Analysis Issues

- Wrong: O(n) (inconsistent spacing)
- Correct: O(n) (uniform format, no spaces)

### 10.4 Incomplete Comments

- Wrong: Missing algorithm design approach
- Wrong: Missing complexity analysis
- Wrong: Missing method-level Javadoc
- Correct: Complete comments for all sections

### 10.5 Language Mixing

- Wrong: Mixing Chinese and English in descriptions
- Correct: Chinese comments with English technical terms only

## 11. Reference Examples

For complete commented examples, see [COMMENT_EXAMPLES.md](COMMENT_EXAMPLES.md).

**Available Examples**:
- Simple Algorithm: `src/main/java/com/flyingcode/problem/Algo025MaxIncSubseq.java`
- Hash Table Algorithm: `src/main/java/com/flyingcode/leetcode/Leet0001TwoSum.java`
- Dynamic Programming: `src/main/java/com/flyingcode/leetcode/Leet0070ClimbStairs.java`
- Multi-Method: `src/main/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversal.java`
- Sorting Algorithm: `src/main/java/com/flyingcode/sort/QuickSort.java`
- Data Structure: `src/main/java/com/flyingcode/structure/ListNode.java`
