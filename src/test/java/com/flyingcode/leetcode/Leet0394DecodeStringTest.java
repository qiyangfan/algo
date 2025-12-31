package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Leet0394DecodeString
 * 使用JUnit 5测试字符串解码算法的正确性
 */
class Leet0394DecodeStringTest {

    /**
     * 测试基本功能: 标准输入格式
     */
    @Test
    @DisplayName("测试基本功能: 标准输入格式")
    void testStandardInput() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "3[a]2[bc]";
        String expected = "aaabcbc";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "字符串3[a]2[bc]解码后应该是aaabcbc");
    }

    /**
     * 测试边界条件: 空字符串
     */
    @Test
    @DisplayName("测试边界条件: 空字符串")
    void testEmptyString() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "";
        String expected = "";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "空字符串解码后应该还是空字符串");
    }

    /**
     * 测试边界条件: 没有括号的字符串
     */
    @Test
    @DisplayName("测试边界条件: 没有括号的字符串")
    void testNoBrackets() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "abc";
        String expected = "abc";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "没有括号的字符串解码后应该保持不变");
    }

    /**
     * 测试特殊情况: 嵌套括号
     */
    @Test
    @DisplayName("测试特殊情况: 嵌套括号")
    void testNestedBrackets() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "2[3[a]b]";
        String expected = "aaabaaab";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "嵌套括号2[3[a]b]解码后应该是aaabaaab");
    }

    /**
     * 测试特殊情况: 多位数重复次数
     */
    @Test
    @DisplayName("测试特殊情况: 多位数重复次数")
    void testMultiDigitCount() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "10[a]";
        String expected = "aaaaaaaaaa";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "10[a]解码后应该是10个a组成的字符串");
    }

    /**
     * 测试特殊情况: 括号内多个字符
     */
    @Test
    @DisplayName("测试特殊情况: 括号内多个字符")
    void testMultipleCharsInBrackets() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "3[abc]";
        String expected = "abcabcabc";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "3[abc]解码后应该是abcabcabc");
    }

    /**
     * 测试复杂场景: 多层嵌套和多个重复序列
     */
    @Test
    @DisplayName("测试复杂场景: 多层嵌套和多个重复序列")
    void testComplexNestedAndMultipleSequences() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "2[abc]3[cd]ef";
        String expected = "abcabccdcdcdef";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "2[abc]3[cd]ef解码后应该是abcabccdcdcdef");
    }

    /**
     * 测试复杂场景: 深度嵌套
     */
    @Test
    @DisplayName("测试复杂场景: 深度嵌套")
    void testDeepNested() {
        // 准备测试数据
        Leet0394DecodeString decoder = new Leet0394DecodeString();
        String input = "2[2[2[a]]]";
        String expected = "aaaaaaaa";

        // 执行测试方法
        String result = decoder.solution(input);

        // 验证结果
        assertEquals(expected, result, "2[2[2[a]]]解码后应该是8个a组成的字符串");
    }
}
