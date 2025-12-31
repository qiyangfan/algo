package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Algo035KMP
 * Uses JUnit 5 to test the correctness of the Algo035KMP string search
 * algorithm
 */
class Algo035KMPTest {

    /**
     * 测试基本功能: 模式串在主串中出现一次
     */
    @Test
    @DisplayName("测试基本功能: 模式串在主串中出现一次")
    void testPatternAppearsOnce() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(10), result, "模式串\"ABABCABAB\"在主串\"ABABDABACDABABCABAB\"中应该出现在位置10");
    }

    /**
     * 测试基本功能: 模式串在主串中出现多次
     */
    @Test
    @DisplayName("测试基本功能: 模式串在主串中出现多次")
    void testPatternAppearsMultipleTimes() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "AAAAA";
        String pattern = "AA";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(0, 1, 2, 3), result, "模式串\"AA\"在主串\"AAAAA\"中应该出现在位置0, 1, 2, 3");
    }

    /**
     * 测试边界条件: 空主串
     */
    @Test
    @DisplayName("测试边界条件: 空主串")
    void testEmptyMainString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "";
        String pattern = "ABC";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(), result, "空主串应该返回空列表");
    }

    /**
     * 测试边界条件: 空模式串
     */
    @Test
    @DisplayName("测试边界条件: 空模式串")
    void testEmptyPatternString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABCDEF";
        String pattern = "";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(), result, "空模式串应该返回空列表");
    }

    /**
     * 测试边界条件: 主串为null
     */
    @Test
    @DisplayName("测试边界条件: 主串为null")
    void testNullMainString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = null;
        String pattern = "ABC";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(), result, "主串为null应该返回空列表");
    }

    /**
     * 测试边界条件: 模式串为null
     */
    @Test
    @DisplayName("测试边界条件: 模式串为null")
    void testNullPatternString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABCDEF";
        String pattern = null;

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(), result, "模式串为null应该返回空列表");
    }

    /**
     * 测试边界条件: 模式串等于主串
     */
    @Test
    @DisplayName("测试边界条件: 模式串等于主串")
    void testPatternEqualsMainString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABC";
        String pattern = "ABC";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(0), result, "模式串等于主串时应该出现在位置0");
    }

    /**
     * 测试特殊情况: 模式串为单个字符
     */
    @Test
    @DisplayName("测试特殊情况: 模式串为单个字符")
    void testSingleCharacterPattern() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "AAAAA";
        String pattern = "A";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), result, "单个字符模式串\"A\"在主串\"AAAAA\"中应该出现在位置0, 1, 2, 3, 4");
    }

    /**
     * 测试特殊情况: 主串中没有匹配的模式串
     */
    @Test
    @DisplayName("测试特殊情况: 主串中没有匹配的模式串")
    void testNoMatchingPattern() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABCDEF";
        String pattern = "XYZ";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(), result, "主串\"ABCDEF\"中没有模式串\"XYZ\", 应该返回空列表");
    }

    /**
     * 测试特殊情况: 重叠匹配
     */
    @Test
    @DisplayName("测试特殊情况: 重叠匹配")
    void testOverlappingMatches() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABABABAB";
        String pattern = "ABAB";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(0, 2, 4), result, "模式串\"ABAB\"在主串\"ABABABAB\"中应该出现在位置0, 2, 4");
    }

    /**
     * 测试复杂场景: 长主串包含多种模式
     */
    @Test
    @DisplayName("测试复杂场景: 长主串包含多种模式")
    void testLongMainString() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "This is a test string for Algo035KMP algorithm test. Test test test.";
        String pattern = "test";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(10, 47, 58, 63), result, "模式串\"test\"在长主串中应该出现在位置10, 47, 58, 63(区分大小写)");
    }

    /**
     * 测试特殊情况: 模式串有重复的前缀和后缀
     */
    @Test
    @DisplayName("测试特殊情况: 模式串有重复的前缀和后缀")
    void testPatternWithRepeatedPrefixes() {
        // Arrange
        Algo035KMP kmp = new Algo035KMP();
        String text = "ABCABABCABABCABABCABABCABABC";
        String pattern = "ABABCABABC";

        // Act
        List<Integer> result = kmp.solution(text, pattern);

        // Assert
        assertEquals(Arrays.asList(3, 8, 13, 18), result, "带有重复前缀和后缀的模式串应该被正确找到");
    }
}
