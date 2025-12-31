# Test Class Writing Rules

## Important Formatting Rules

**MANDATORY Language & Punctuation Standards** (STRICTLY ENFORCED):
- **[MANDATORY]** Use Chinese for all test elements: test class comments, @DisplayName annotations, and assertion messages
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.)
- **[ABSOLUTELY PROHIBITED]** Chinese punctuation marks
- **[MANDATORY]** No emoji in any test code or comments

## Related Documentation

- **[TEST_EXAMPLES.md](TEST_EXAMPLES.md)** - Test class writing examples and templates
- **[COMMENT_RULES.md](COMMENT_RULES.md)** - Algorithm class comment standards
- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide

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

**Required Imports**:
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

**Requirements**:
- Test standard input scenarios
- Verify expected algorithm behavior
- Include clear assertion messages

### 4.2 Boundary Condition Tests (3-4 tests)

**Common Boundaries**:
- Empty array/collection
- null input
- Single element
- Minimum/maximum values

**Requirements**:
- Test algorithm's handling of edge cases
- Verify proper error handling
- Ensure robustness

### 4.3 Special Case Tests (3-4 tests)

**Common Special Cases**:
- All elements identical
- Completely increasing/decreasing
- Contains negative numbers, zeros
- Duplicate elements
- Skewed data structures (for trees/graphs)

**Requirements**:
- Test algorithm's behavior with special inputs
- Verify correctness under unusual conditions
- Document tree/graph structures visually

### 4.4 Complex Scenario Tests (2-3 tests)

**Common Complex Scenarios**:
- Long arrays/large inputs
- Multiple solutions/paths
- Extreme condition combinations
- Fluctuating patterns

**Requirements**:
- Test algorithm's scalability
- Verify correctness with complex inputs
- Ensure performance is acceptable

### 4.5 Data Structure Tests (Trees, Linked Lists)

**Visual Documentation**: Use clear comments to describe structure

**Requirements**:
- Document tree/graph structure in comments
- Use visual representation (ASCII art)
- Ensure test data matches documented structure

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

**Quality Standards**:
- Messages should be in Chinese with English punctuation
- Should explain WHY the expected result is correct
- Should include relevant context about the test scenario

### 5.3 Multiple Assertions Strategy

For complex results (lists, trees), use progressive assertions:
- First verify non-null
- Then verify size/structure
- Finally verify content

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

## 7. Running and Verification

### 7.1 Run Single Test Class

```bash
mvn test -Dtest=AlgoXXXTest  # Run problem package test class
mvn test -Dtest=LeetXXXXTest  # Run leetcode package test class
```

### 7.2 Run All Tests

```bash
mvn test
```

### 7.3 Success Criteria

- All tests pass (0 Failures, 0 Errors)
- Test coverage >= 80%
- Execution time < 1 second per test class

## 8. Common Issues and Solutions

### 8.1 Unclear Naming

**Problem**: `test1()`, `testMethod()`, `testA()`
**Solution**: `testEmptyArray()`, `testWithNegativeNumbers()`, `testSingleElement()`

### 8.2 Missing Assertion Messages

**Problem**: `assertEquals(3, result)`
**Solution**: `assertEquals(3, result, "预期结果为3, 因为...")`

### 8.3 Insufficient Coverage

**Problem**: Only normal cases tested, no boundary conditions
**Solution**: Add null, empty, single element, and special case tests

### 8.4 Interdependent Tests

**Problem**: Tests share state or depend on execution order
**Solution**: Create new instances in each test method

### 8.5 Wrong Punctuation

**Problem**: `@DisplayName("测试数组: 输入")` using Chinese punctuation
**Solution**: `@DisplayName("测试数组: 输入")` using English punctuation

## 9. Best Practices Summary

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

## 10. Documentation System Integration

Complete project documentation:
- **[CLAUDE.md](CLAUDE.md)** - Project structure and architecture
- **[COMMENT_RULES.md](COMMENT_RULES.md)** - Algorithm comment standards
- **[TEST_EXAMPLES.md](TEST_EXAMPLES.md)** - Test writing examples
- **[This Document]** - Test writing standards

## 11. Development Workflow

1. **Implement Algorithm** (follow [COMMENT_RULES.md](COMMENT_RULES.md))
2. **Write Test Class** (follow [TEST_EXAMPLES.md](TEST_EXAMPLES.md))
3. **Run Verification** (`mvn test -Dtest=YourClassNameTest`)
4. **Quality Check** (ensure all tests pass with clear messages)
5. **Submit Code** (with complete comments and comprehensive tests)

## 12. Reference Examples

For complete test class examples, see [TEST_EXAMPLES.md](TEST_EXAMPLES.md).

**Available Examples**:
- **problem package tests**: `src/test/java/com/flyingcode/problem/Algo025MaxIncSubseqTest.java`
- **leetcode package tests**: `src/test/java/com/flyingcode/leetcode/Leet0070ClimbStairsTest.java`
- **Tree structure tests**: `src/test/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversalTest.java`
