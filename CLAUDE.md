# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Related Documentation

- **Code Comment Guidelines**: [CODE_COMMENT_GUIDELINES.md](CODE_COMMENT_GUIDELINES.md) - Code comment standards and conventions
- **Test Guidelines**: [TEST_GUIDELINES.md](TEST_GUIDELINES.md) - Test class writing standards and best practices

## Project Overview

This is a Java-based algorithm practice project for LeetCode-style problems. Each class represents an independent problem or algorithm implementation with no inter-class dependencies.

## Documentation Standards

- **Punctuation Usage**: Use English punctuation marks in all text (commas, periods, colons, etc.) to maintain consistency across all code comments and documentation

## Build and Run Commands

### Build
```bash
mvn clean compile
```

### Run a specific class
```bash
mvn exec:java -Dexec.mainClass="com.flyingcode.ClassName"
```

### Run tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ClassNameTest

# Example: Run Algo025 tests
mvn test -Dtest=Algo025MaxLengthContinuousIncreasingSubsequenceArrayTest
```

### Clean build artifacts
```bash
mvn clean
```

## Code Architecture

- **Package Structure**: All classes are in `com.flyingcode` package under `src/main/java/`
- **Independence**: Each class is self-contained with its own `main()` method for testing - no inter-class dependencies
- **Standard Pattern**: Classes implement a `solution()` static method containing the core algorithm logic

## Dependencies

- **Java 8**: Target compiler version
- No external dependencies - uses only JDK standard library for output (System.out.println)

## File Organization

- **Source**: `src/main/java/com/flyingcode/` - All algorithm implementations
  - `problem/` - Algorithm problem solutions (e.g., Algo001*, Algo002*, etc.)
  - `structure/` - Data structure implementations (TreeNode, ListNode, etc.)
- **Tests**: `src/test/java/com/flyingcode/problem/` - JUnit 5 test classes
  - Test class naming: `{AlgorithmClass}Test.java`
  - Each algorithm implementation has corresponding test coverage

## Creating New Algorithm Classes

When adding a new algorithm solution:

1. Create new class in `com.flyingcode.problem` package
2. Implement static `solution()` method with core algorithm
3. Add comprehensive comments following [CODE_COMMENT_GUIDELINES.md](CODE_COMMENT_GUIDELINES.md)
4. Create corresponding test class in `src/test/java/com/flyingcode/problem/`
5. Follow [TEST_GUIDELINES.md](TEST_GUIDELINES.md) for test structure and coverage
6. Add `main()` method for quick manual testing (optional, for debugging purposes)

### Algorithm Comment Requirements

All algorithm classes MUST include:
- Class-level Javadoc describing the algorithm
- Algorithm design approach and strategy
- Time and space complexity analysis
- Method-level Javadoc with @param and @return
- Inline comments for key implementation steps

### Test Class Requirements

All test classes MUST:
- Follow proper naming convention: `{ClassName}Test`
- Use JUnit 5 annotations (@Test, @DisplayName)
- Include comprehensive test cases:
  - Basic functionality tests
  - Boundary conditions (null, empty, single element)
  - Special cases (duplicates, negative numbers, etc.)
  - Complex scenarios
- Provide clear assertion messages
- Follow AAA pattern (Arrange-Act-Assert)
