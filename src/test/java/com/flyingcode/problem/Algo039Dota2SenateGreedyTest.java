package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Algo039Dota2SenateGreedy
 * Uses JUnit 5 to test the correctness of Dota2参议院问题的双队列贪心算法
 */
class Algo039Dota2SenateGreedyTest {

    private final Algo039Dota2SenateGreedy solution = new Algo039Dota2SenateGreedy();

    /**
     * 测试基本功能: 只有Radiant阵营的情况
     */
    @Test
    @DisplayName("测试基本功能: 只有Radiant阵营")
    void testOnlyRadiant() {
        assertEquals("Radiant", solution.solution("RRR"), "只有Radiant阵营时, Radiant应该获胜");
    }

    /**
     * 测试基本功能: 只有Dire阵营的情况
     */
    @Test
    @DisplayName("测试基本功能: 只有Dire阵营")
    void testOnlyDire() {
        assertEquals("Dire", solution.solution("DDD"), "只有Dire阵营时, Dire应该获胜");
    }

    /**
     * 测试基本功能: 交替排列, Radiant先发言
     */
    @Test
    @DisplayName("测试基本功能: 交替排列, Radiant先发言")
    void testAlternateRadiantFirst() {
        // R D R D R
        // R禁言D, D被禁言, R禁言D, D被禁言, R禁言D
        // 结果: Radiant获胜
        assertEquals("Radiant", solution.solution("RDRDR"), "交替排列且Radiant先发言时, Radiant应该获胜");
    }

    /**
     * 测试基本功能: 交替排列, Dire先发言
     */
    @Test
    @DisplayName("测试基本功能: 交替排列, Dire先发言")
    void testAlternateDireFirst() {
        // D R D R D
        // D禁言R, R被禁言, D禁言R, R被禁言, D禁言R
        // 结果: Dire获胜
        assertEquals("Dire", solution.solution("DRDRD"), "交替排列且Dire先发言时, Dire应该获胜");
    }

    /**
     * 测试边界条件: 只有两个参议员, Radiant先发言
     */
    @Test
    @DisplayName("测试边界条件: 只有两个参议员, Radiant先发言")
    void testExample1() {
        // 示例1: "RD", 预期结果: "Radiant"
        // R先发言, 禁言D, R获胜
        assertEquals("Radiant", solution.solution("RD"), "只有两个参议员且Radiant先发言时, Radiant应该获胜");
    }

    /**
     * 测试边界条件: 只有一个Radiant和两个Dire
     */
    @Test
    @DisplayName("测试边界条件: RDD组合")
    void testExample2() {
        // 示例2: "RDD", 预期结果: "Dire"
        // 第一轮: R发言, 禁言第一个D; 第一个D被禁言; 第二个D发言, 禁言R
        // 第二轮: 剩下的D发言, 没有R了, Dire获胜
        assertEquals("Dire", solution.solution("RDD"), "RDD组合时, Dire应该获胜");
    }

    /**
     * 测试边界条件: 相等数量的R和D, 不同的发言顺序
     */
    @Test
    @DisplayName("测试边界条件: 相等数量的R和D")
    void testEqualNumbers() {
        // 相等数量的R和D, 谁先发言谁获胜
        assertEquals("Radiant", solution.solution("RD"), "RD组合时, Radiant先发言应该获胜");
        assertEquals("Dire", solution.solution("DR"), "DR组合时, Dire先发言应该获胜");
    }

    /**
     * 测试复杂场景: 多轮投票情况
     */
    @Test
    @DisplayName("测试复杂场景: 多轮投票")
    void testMultipleRounds() {
        // "RDDRRDD": 多轮投票情况
        // 最终结果应该是Dire获胜
        // 模拟过程:
        // 轮1: R(0) vs D(1) → R胜, R重新入队(7)
        // 轮2: R(3) vs D(2) → D胜, D重新入队(9)
        // 轮3: R(4) vs D(5) → R胜, R重新入队(11)
        // 轮4: R(7) vs D(6) → D胜, D重新入队(13)
        // 轮5: R(11) vs D(9) → D胜, D重新入队(16)
        // 最终: Radiant队列为空, Dire获胜
        assertEquals("Dire", solution.solution("RDDRRDD"), "多轮投票情况下, Dire应该获胜");
    }
}
