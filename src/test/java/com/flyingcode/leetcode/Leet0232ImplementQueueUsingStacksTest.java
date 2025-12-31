package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Leet0232ImplementQueueUsingStacks
 * Uses JUnit 5 to test the correctness of the queue implementation using two stacks
 */
class Leet0232ImplementQueueUsingStacksTest {

    /**
     * 测试基本功能: 标准队列操作
     * 入队多个元素, 然后依次出队, 验证FIFO顺序
     */
    @Test
    @DisplayName("测试基本功能: 标准队列操作")
    void testStandardQueueOperations() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int result1 = queue.pop();
        int result2 = queue.pop();
        queue.push(4);
        int result3 = queue.pop();
        int result4 = queue.pop();
        
        // 验证结果
        assertEquals(1, result1, "第一个出队元素应该是1");
        assertEquals(2, result2, "第二个出队元素应该是2");
        assertEquals(3, result3, "第三个出队元素应该是3");
        assertEquals(4, result4, "第四个出队元素应该是4");
    }

    /**
     * 测试边界条件: 空队列
     * 测试空队列的出队、查看队头和判空操作
     */
    @Test
    @DisplayName("测试边界条件: 空队列")
    void testEmptyQueue() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        int popResult = queue.pop();
        int peekResult = queue.peek();
        boolean emptyResult = queue.empty();
        
        // 验证结果
        assertEquals(-1, popResult, "空队列调用pop应该返回-1");
        assertEquals(-1, peekResult, "空队列调用peek应该返回-1");
        assertTrue(emptyResult, "空队列调用empty应该返回true");
    }

    /**
     * 测试边界条件: 单个元素队列
     * 测试只有一个元素的队列操作
     */
    @Test
    @DisplayName("测试边界条件: 单个元素队列")
    void testSingleElementQueue() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        queue.push(5);
        boolean emptyBeforePop = queue.empty();
        int peekResult = queue.peek();
        int popResult = queue.pop();
        boolean emptyAfterPop = queue.empty();
        
        // 验证结果
        assertFalse(emptyBeforePop, "队列有一个元素时调用empty应该返回false");
        assertEquals(5, peekResult, "查看队头元素应该是5");
        assertEquals(5, popResult, "出队元素应该是5");
        assertTrue(emptyAfterPop, "出队后队列为空, 调用empty应该返回true");
    }

    /**
     * 测试特殊情况: 连续调用peek方法
     * 验证peek方法不会改变队列状态
     */
    @Test
    @DisplayName("测试特殊情况: 连续调用peek方法")
    void testMultiplePeekCalls() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        queue.push(10);
        queue.push(20);
        int peekResult1 = queue.peek();
        int peekResult2 = queue.peek();
        int peekResult3 = queue.peek();
        
        // 验证结果
        assertEquals(10, peekResult1, "第一次peek应该返回10");
        assertEquals(10, peekResult2, "第二次peek应该返回10");
        assertEquals(10, peekResult3, "第三次peek应该返回10");
    }

    /**
     * 测试特殊情况: 交替调用push和pop
     * 验证队列在交替操作下的正确性
     */
    @Test
    @DisplayName("测试特殊情况: 交替调用push和pop")
    void testAlternatingPushPop() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        queue.push(1);
        int result1 = queue.pop();
        queue.push(2);
        int result2 = queue.pop();
        queue.push(3);
        queue.push(4);
        int result3 = queue.pop();
        queue.push(5);
        int result4 = queue.pop();
        int result5 = queue.pop();
        
        // 验证结果
        assertEquals(1, result1, "第一个出队元素应该是1");
        assertEquals(2, result2, "第二个出队元素应该是2");
        assertEquals(3, result3, "第三个出队元素应该是3");
        assertEquals(4, result4, "第四个出队元素应该是4");
        assertEquals(5, result5, "第五个出队元素应该是5");
    }

    /**
     * 测试复杂场景: 大量元素操作
     * 测试队列处理大量元素的正确性
     */
    @Test
    @DisplayName("测试复杂场景: 大量元素操作")
    void testLargeNumberOfElements() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        int elementCount = 100;
        
        // 执行测试方法
        // 入队100个元素
        for (int i = 0; i < elementCount; i++) {
            queue.push(i);
        }
        
        // 出队前50个元素
        for (int i = 0; i < 50; i++) {
            int result = queue.pop();
            assertEquals(i, result, "第" + (i+1) + "个出队元素应该是" + i);
        }
        
        // 继续入队50个元素
        for (int i = 100; i < 150; i++) {
            queue.push(i);
        }
        
        // 出队剩余100个元素
        for (int i = 50; i < 150; i++) {
            int result = queue.pop();
            assertEquals(i, result, "第" + (i+1) + "个出队元素应该是" + i);
        }
        
        // 验证队列为空
        assertTrue(queue.empty(), "所有元素出队后队列为空");
    }

    /**
     * 测试特殊情况: 查看空队列的队头元素
     * 验证空队列调用peek方法的正确性
     */
    @Test
    @DisplayName("测试特殊情况: 查看空队列的队头元素")
    void testPeekEmptyQueue() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        int result = queue.peek();
        
        // 验证结果
        assertEquals(-1, result, "空队列调用peek应该返回-1");
    }

    /**
     * 测试特殊情况: 出队空队列
     * 验证空队列调用pop方法的正确性
     */
    @Test
    @DisplayName("测试特殊情况: 出队空队列")
    void testPopEmptyQueue() {
        // 准备测试数据
        Leet0232ImplementQueueUsingStacks queue = new Leet0232ImplementQueueUsingStacks();
        
        // 执行测试方法
        int result = queue.pop();
        
        // 验证结果
        assertEquals(-1, result, "空队列调用pop应该返回-1");
    }
}