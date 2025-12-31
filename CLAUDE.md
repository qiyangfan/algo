# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Related Documentation

- **[docs/COMMENT_RULES.md](docs/COMMENT_RULES.md)** - Code comment standards and conventions
- **[docs/COMMENT_EXAMPLES.md](docs/COMMENT_EXAMPLES.md)** - Code comment examples and templates
- **[docs/TEST_RULES.md](docs/TEST_RULES.md)** - Test class writing standards
- **[docs/TEST_EXAMPLES.md](docs/TEST_EXAMPLES.md)** - Test class writing examples
- **[docs/ALGORITHM_GUIDE.md](docs/ALGORITHM_GUIDE.md)** - Algorithm implementation guide

---

## Project Overview

This is a Java-based algorithm practice project for LeetCode-style problems. Each class represents an independent problem or algorithm implementation with no inter-class dependencies.

**Key Characteristics**:
- Self-contained algorithm implementations
- Comprehensive code comments in Chinese with English punctuation
- Full test coverage using JUnit 5
- No external dependencies beyond JDK

## Documentation Standards

**CRITICAL Requirements**:

### Language & Punctuation
- **Code Comments**: Use Chinese text with English punctuation marks (MANDATORY)
- **Test Elements**: Use Chinese for @DisplayName, comments, and assertion messages with English punctuation
- **No Chinese Punctuation**: Absolutely禁止 use of Chinese punctuation marks (，。：；) in any code or comments
- **No Emoji**: No emoji symbols in any code comments or documentation

### Code Quality
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Use 2-space indentation (project standard)
- Add meaningful comments explaining **why**, not **what**
- Keep methods focused and concise

## Project Structure

### Package Organization

```
com.flyingcode/
├── leetcode/        # LeetCode problem solutions (LeetXXXXProblemName)
├── problem/         # Algorithm practice problems (AlgoXXXAlgorithmName)
├── sort/            # Sorting algorithm implementations (QuickSort, MergeSort, etc.)
├── structure/       # Data structure definitions (TreeNode, ListNode, etc.)
└── swordoffer/      # Sword Offer problems (SwordOfferXXProblemName)
```

### Source Files Location

- **Source Code**: `src/main/java/com/flyingcode/`
- **Test Code**: `src/test/java/com/flyingcode/`

### Class Naming Conventions

| Package | Naming Pattern | Example |
|---------|---------------|---------|
| `problem/` | `AlgoXXXAlgorithmName` | `Algo025MaxIncSubseq` |
| `leetcode/` | `LeetXXXXProblemName` | `Leet0070ClimbStairs` |
| `sort/` | `AlgorithmName` | `QuickSort`, `MergeSort` |
| `swordoffer/` | `SwordOfferXXProblemName` | `SwordOfferXX` |

## Build and Run Commands

### Build Commands

```bash
# Clean and compile
mvn clean compile

# Clean only (remove build artifacts)
mvn clean
```

### Run Algorithm Classes

```bash
# Run a specific algorithm class
mvn exec:java -Dexec.mainClass="com.flyingcode.ClassName"

# Examples:
mvn exec:java -Dexec.mainClass="com.flyingcode.problem.Algo025MaxIncSubseq"
mvn exec:java -Dexec.mainClass="com.flyingcode.leetcode.Leet0070ClimbStairs"
```

### Test Commands

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ClassNameTest

# Run specific package tests
mvn test -Dtest=com.flyingcode.problem.*
mvn test -Dtest=com.flyingcode.leetcode.*

# Examples:
mvn test -Dtest=Algo025MaxIncSubseqTest
mvn test -Dtest=Leet0070ClimbStairsTest
```

## Development Workflow

### Creating New Algorithm Classes

**Step-by-Step Process**:

1. **Create Algorithm Class**
   - Create class in appropriate package (`problem/`, `leetcode/`, `sort/`, etc.)
   - Follow naming convention for the package
   - Implement static `solution()` method with core algorithm

2. **Add Code Comments**
   - Follow [docs/COMMENT_RULES.md](docs/COMMENT_RULES.md) for comment standards
   - Reference [docs/COMMENT_EXAMPLES.md](docs/COMMENT_EXAMPLES.md) for templates
   - Include all required sections:
     - Class-level Javadoc
     - Algorithm design approach
     - Complexity analysis
     - Method-level Javadoc with @param and @return
     - Inline comments for key steps

3. **Create Test Class**
   - Create corresponding test class in `src/test/java/com/flyingcode/[package]/`
   - Follow [docs/TEST_RULES.md](docs/TEST_RULES.md) for test standards
   - Reference [docs/TEST_EXAMPLES.md](docs/TEST_EXAMPLES.md) for test templates
   - Include comprehensive test coverage:
     - Basic functionality (2-3 tests)
     - Boundary conditions (3-4 tests: null, empty, single element)
     - Special cases (3-4 tests: duplicates, negatives, etc.)
     - Complex scenarios (2-3 tests)

4. **Verify Implementation**
   - Run tests: `mvn test -Dtest=YourClassNameTest`
   - Ensure all tests pass
   - Verify comment completeness and accuracy

5. **Quality Check**
   - Review code for consistency with project standards
   - Check proper use of Chinese with English punctuation
   - Verify comprehensive test coverage (minimum 8-10 tests)

### Algorithm Class Structure

**Required Components**:

1. **Package Declaration**
   ```java
   package com.flyingcode.problem; // or leetcode, sort, swordoffer
   ```

2. **Class-Level Comment**
   - Algorithm Chinese name
   - Feature description
   - Core technique
   - Performance characteristics

3. **Algorithm Design Approach**
   - Numbered implementation steps
   - Key technical points (if applicable)

4. **Complexity Analysis**
   - Time complexity with explanation
   - Space complexity with explanation

5. **Method Implementation**
   - Method-level Javadoc with @param and @return
   - Inline comments for key logic
   - Proper boundary condition handling

### Test Class Structure

**Required Components**:

1. **Package Declaration** (matching source package)

2. **Imports**
   - Static assertions (assertEquals, assertTrue, etc.)
   - JUnit 5 annotations (@Test, @DisplayName)
   - Required data structures

3. **Test Methods**
   - Descriptive method names: `testSpecificScenario()`
   - @Test and @DisplayName annotations (Chinese with English punctuation)
   - AAA pattern (Arrange-Act-Assert)
   - Clear assertion messages explaining expected results

4. **Test Coverage**
   - Minimum 8-10 tests per algorithm class
   - Recommended 12-15 tests for comprehensive coverage

## Dependencies

**Java Version**: Java 8 (target compiler version)

**External Libraries**:
- **JUnit 5**: For testing framework
- **JDK Standard Library Only**: No other external dependencies for algorithm implementations

**Maven Configuration**: All dependencies managed through `pom.xml`

## Common Patterns

### Algorithm Implementation Pattern

```java
package com.flyingcode.problem;

/**
 * Algorithm Chinese Name
 * Feature description with English punctuation.
 */
public class AlgoXXXName {

    /**
     * Algorithm design approach:
     * 1. Step one description
     * 2. Step two description
     */

    /**
     * Complexity analysis:
     * - Time: O(n) where n is input size
     * - Space: O(1) constant space
     */

    /**
     * Method description in Chinese
     *
     * @param param1 parameter description
     * @return return value description
     */
    public static int solution(int[] nums) {
        // Boundary condition
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Algorithm implementation
        // ...

        return result;
    }

    // Optional main method for debugging
    public static void main(String[] args) {
        // Test code here
    }
}
```

### Test Implementation Pattern

```java
package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class: AlgoXXXName
 * Test description in Chinese with English punctuation
 */
class AlgoXXXNameTest {

    @Test
    @DisplayName("Test scenario description in Chinese")
    void testSpecificScenario() {
        // Arrange
        AlgoXXXName algo = new AlgoXXXName();
        int[] input = {1, 2, 3};
        int expected = 6;

        // Act
        int result = algo.solution(input);

        // Assert
        assertEquals(expected, result, "Assertion message in Chinese");
    }
}
```

## Best Practices

### Code Comments

- **Explain Why**: Focus on reasoning, not obvious mechanics
- **Be Concise**: Avoid redundancy with self-evident code
- **Stay Current**: Update comments when code changes
- **Use Chinese**: All comments in Chinese with English punctuation
- **Consistent Terminology**: Use consistent terms across similar algorithms

### Test Writing

- **Independence**: Each test must run independently
- **Clear Names**: Use descriptive test method names
- **Comprehensive Coverage**: Test all scenarios including edge cases
- **Clear Messages**: Assertion messages must explain expected results
- **AAA Pattern**: Follow Arrange-Act-Assert structure consistently

### Code Quality

- **Single Responsibility**: Each method does one thing well
- **No Magic Numbers**: Use named constants
- **Proper Naming**: Variables and methods clearly indicate purpose
- **Error Handling**: Handle null, empty, and edge cases properly
- **Efficiency**: Consider time and space complexity

## Troubleshooting

### Common Issues

**Issue**: Tests fail with "No tests found"
- **Solution**: Verify test class naming matches `{ClassName}Test` pattern
- **Solution**: Ensure test class is in correct package path

**Issue**: Compilation errors
- **Solution**: Run `mvn clean compile` to see full error messages
- **Solution**: Check Java version compatibility (Java 8)

**Issue**: Punctuation errors in comments
- **Solution**: Use English punctuation marks (, . : ;)
- **Solution**: Absolutely禁止 Chinese punctuation marks (，。：；)

**Issue**: Insufficient test coverage
- **Solution**: Add boundary condition tests (null, empty, single)
- **Solution**: Add special case tests (duplicates, negatives, etc.)
- **Solution**: Add complex scenario tests

### Getting Help

1. **Check Documentation**:
   - [docs/COMMENT_RULES.md](docs/COMMENT_RULES.md) - Comment standards
   - [docs/COMMENT_EXAMPLES.md](docs/COMMENT_EXAMPLES.md) - Comment templates
   - [docs/TEST_RULES.md](docs/TEST_RULES.md) - Test standards
   - [docs/TEST_EXAMPLES.md](docs/TEST_EXAMPLES.md) - Test templates
   - [docs/ALGORITHM_GUIDE.md](docs/ALGORITHM_GUIDE.md) - Algorithm patterns

2. **Review Examples**:
   - `src/main/java/com/flyingcode/problem/Algo025MaxIncSubseq.java`
   - `src/main/java/com/flyingcode/leetcode/Leet0001TwoSum.java`
   - `src/test/java/com/flyingcode/problem/Algo025MaxIncSubseqTest.java`

3. **Run Tests**: `mvn test` to verify implementation

## Project Maintenance

### Git Workflow

- **Feature Branches**: Create branches for new algorithm implementations
- **Commit Messages**: Use clear, descriptive commit messages
- **Code Review**: Ensure all tests pass before committing
- **Documentation**: Keep documentation synchronized with code changes

### Quality Standards

- All code must have comprehensive comments
- All algorithms must have corresponding test classes
- Test coverage should be comprehensive (minimum 8-10 tests)
- Code must follow project naming conventions
- Comments must use Chinese text with English punctuation

---

**Last Updated**: 2025-12-31
**Documentation Version**: 2.1
**Changes**: Updated documentation paths to use docs/ directory
