package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo026LemonadeChange
 * 使用 JUnit 5 测试柠檬水找零算法的正确性
 */
class Algo026LemonadeChangeTest {

    /**
     * 测试基本功能: 可以正确找零的情况
     * 场景:[5,5,10] - 第三位顾客支付10美元, 可以用前两张5美元找零
     */
    @Test
    @DisplayName("测试基本功能: 可以正确找零")
    void testCanGiveCorrectChange() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 10 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "顾客支付 [5,5,10] 应该能正确找零");
    }

    /**
     * 测试基本功能: 不能找零的情况
     * 场景:[10] - 第一位顾客支付10美元, 没有5美元找零
     */
    @Test
    @DisplayName("测试基本功能: 不能找零")
    void testCannotGiveCorrectChange() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 10 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "第一位顾客支付10美元, 没有5美元找零");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = {};
        boolean result = algo.solution(bills);
        assertEquals(true, result, "空数组表示没有顾客, 应该返回true");
    }

    /**
     * 测试边界条件: 单个顾客支付5美元
     */
    @Test
    @DisplayName("测试边界条件: 单个顾客支付5美元")
    void testSingleCustomerWithFive() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "单个顾客支付5美元, 无需找零");
    }

    /**
     * 测试边界条件: 单个顾客支付10美元
     */
    @Test
    @DisplayName("测试边界条件: 单个顾客支付10美元")
    void testSingleCustomerWithTen() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 10 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "单个顾客支付10美元, 没有5美元找零");
    }

    /**
     * 测试边界条件: 单个顾客支付20美元
     */
    @Test
    @DisplayName("测试边界条件: 单个顾客支付20美元")
    void testSingleCustomerWithTwenty() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 20 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "单个顾客支付20美元, 没有零钱找零");
    }

    /**
     * 测试特殊情况: 所有顾客都支付5美元
     */
    @Test
    @DisplayName("测试特殊情况: 所有顾客都支付5美元")
    void testAllFiveDollarBills() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 5, 5 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "所有顾客支付5美元, 无需找零");
    }

    /**
     * 测试特殊情况: 第二位顾客支付10美元, 需要找零
     */
    @Test
    @DisplayName("测试特殊情况:10美元找零场景")
    void testTenDollarChange() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 10, 5 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "有足够的5美元为10美元找零");
    }

    /**
     * 测试特殊情况:20美元使用10+5找零(贪心策略)
     * 场景:[5,5,10,20] - 第四位顾客支付20美元, 使用10+5找零
     */
    @Test
    @DisplayName("测试特殊情况:20美元使用10+5找零")
    void testTwentyDollarChangeWithTenAndFive() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 10, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "20美元顾客可以使用10+5找零");
    }

    /**
     * 测试特殊情况:20美元使用3张5美元找零
     * 场景:[5,5,5,20] - 第四位顾客支付20美元, 使用3张5美元找零
     */
    @Test
    @DisplayName("测试特殊情况:20美元使用3张5美元找零")
    void testTwentyDollarChangeWithThreeFives() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "20美元顾客可以使用3张5美元找零");
    }

    /**
     * 测试特殊情况:20美元找零失败(没有足够的钱)
     * 场景:[5,5,20] - 第三位顾客支付20美元, 只有两张5美元, 不够找零
     */
    @Test
    @DisplayName("测试特殊情况:20美元找零失败")
    void testTwentyDollarChangeFail() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 20 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "只有两张5美元, 无法为20美元找零");
    }

    /**
     * 测试复杂场景: 混合面值, 可以正确找零
     * 场景:[5,5,5,10,20] - 可以用贪心策略处理所有找零
     */
    @Test
    @DisplayName("测试复杂场景: 混合面值可以找零")
    void testMixedBillsSuccess() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 10, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "混合面值 [5,5,5,10,20] 应该能正确找零");
    }

    /**
     * 测试复杂场景: 贪心策略优势验证
     * 场景:[5,10,5,20] - 第四位顾客支付20美元
     * 使用贪心策略(优先10+5)而不是使用3张5美元
     * 这样为后续可能的找零保留了更多5美元
     */
    @Test
    @DisplayName("测试复杂场景: 贪心策略优势验证")
    void testGreedyStrategyAdvantage() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 10, 5, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "贪心策略优先使用10+5, 为后续保留更多5美元");
    }

    /**
     * 测试复杂场景: 多个20美元顾客
     * 场景:[5,5,5,5,10,10,20,20]
     * 验证连续处理多个20美元找零的能力
     */
    @Test
    @DisplayName("测试复杂场景: 多个20美元顾客")
    void testMultipleTwentyDollarBills() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 5, 10, 10, 20, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "应该能处理多个20美元找零请求");
    }

    /**
     * 测试复杂场景: 大量顾客混合面值
     * 场景:[5,5,5,10,5,5,10,10,20,20]
     * 验证算法在长序列下的正确性
     */
    @Test
    @DisplayName("测试复杂场景: 大量顾客混合面值")
    void testLongSequenceMixedBills() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 10, 5, 5, 10, 10, 20, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "长序列混合面值应该能正确找零");
    }

    /**
     * 测试边界情况: 刚好够找零
     * 场景:[5,5,5,10,20] - 刚好能用完所有钞票找零
     */
    @Test
    @DisplayName("测试边界情况: 刚好够找零")
    void testBarelyEnoughChange() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 10, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "钞票刚好够找零");
    }

    /**
     * 测试边界情况: 差一张5美元不够找零
     * 场景:[5,10,20] - 第三位顾客支付20美元, 需要10+5, 但10美元已经用掉
     */
    @Test
    @DisplayName("测试边界情况: 差一张5美元不够")
    void testJustOneFiveShort() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 10, 20 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "20美元需要10+5找零, 但只有一张5美元不够");
    }

    /**
     * 测试特殊情况: 连续的10美元顾客
     * 场景:[5,5,10,10] - 需要两张5美元为两位10美元顾客找零
     */
    @Test
    @DisplayName("测试特殊情况: 连续的10美元顾客")
    void testConsecutiveTenDollarBills() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 10, 10 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "连续的10美元顾客应该能正确找零");
    }

    /**
     * 测试特殊情况: 连续的5美元后接20美元
     * 场景:[5,5,5,5,5,5,20,20] - 两位20美元顾客各用3张5美元找零, 需要6张5美元
     */
    @Test
    @DisplayName("测试特殊情况: 连续20美元使用3张5美元")
    void testConsecutiveTwentyWithThreeFives() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 5, 5, 5, 5, 5, 20, 20 };
        boolean result = algo.solution(bills);
        assertEquals(true, result, "连续20美元顾客应该能使用3张5美元找零");
    }

    /**
     * 测试失败场景:10美元太多导致20美元无法找零
     * 场景:[5,10,10,20] - 虽然有足够金额, 但没有正确的钞票组合
     */
    @Test
    @DisplayName("测试失败场景: 钞票组合不当")
    void testWrongBillCombination() {
        Algo026LemonadeChange algo = new Algo026LemonadeChange();
        int[] bills = { 5, 10, 10, 20 };
        boolean result = algo.solution(bills);
        assertEquals(false, result, "虽然有足够金额, 但钞票组合不当无法找零");
    }
}
