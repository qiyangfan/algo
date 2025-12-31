package com.flyingcode.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: BlockSearch
 * 使用JUnit 5测试分块查找算法的正确性
 */
class BlockSearchTest {

    /**
     * 测试基本功能: 标准分块数组中查找存在的元素
     */
    @Test
    @DisplayName("测试标准分块数组中查找存在的元素")
    void testStandardBlockArrayWithExistingElement() {
        // 准备测试数据：分块数组，块间有序，块内可以无序
        // 块1: [2, 3, 1] (最大值3)
        // 块2: [5, 4, 6] (最大值6)
        // 块3: [8, 7, 9] (最大值9)
        BlockSearch search = new BlockSearch();
        int[] arr = { 2, 3, 1, 5, 4, 6, 8, 7, 9 };
        int target = 4;
        int expected = 4;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "分块数组[2,3,1,5,4,6,8,7,9]中查找4，应该返回索引4");
    }
    
    /**
     * 测试基本功能: 标准分块数组中查找不存在的元素
     */
    @Test
    @DisplayName("测试标准分块数组中查找不存在的元素")
    void testStandardBlockArrayWithNonExistingElement() {
        // 准备测试数据：分块数组，块间有序，块内可以无序
        BlockSearch search = new BlockSearch();
        int[] arr = { 2, 3, 1, 5, 4, 6, 8, 7, 9 };
        int target = 10;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "分块数组[2,3,1,5,4,6,8,7,9]中查找10，应该返回-1");
    }
    
    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        // 准备测试数据
        BlockSearch search = new BlockSearch();
        int[] arr = {};
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "空数组中查找任何元素，应该返回-1");
    }
    
    /**
     * 测试边界条件: null数组
     */
    @Test
    @DisplayName("测试边界条件: null数组")
    void testNullArray() {
        // 准备测试数据
        BlockSearch search = new BlockSearch();
        int[] arr = null;
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "null数组中查找任何元素，应该返回-1");
    }
    
    /**
     * 测试边界条件: 单个元素数组
     */
    @Test
    @DisplayName("测试边界条件: 单个元素数组")
    void testSingleElementArray() {
        // 准备测试数据
        BlockSearch search = new BlockSearch();
        int[] arr = { 10 };
        int target = 10;
        int expected = 0;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "单个元素数组[10]中查找10，应该返回索引0");
    }
    
    /**
     * 测试边界条件: 单个元素数组，元素不存在
     */
    @Test
    @DisplayName("测试单个元素数组，元素不存在")
    void testSingleElementArrayWithNonExistingElement() {
        // 准备测试数据
        BlockSearch search = new BlockSearch();
        int[] arr = { 10 };
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "单个元素数组[10]中查找5，应该返回-1");
    }
    
    /**
     * 测试特殊情况: 块内无序的数组
     */
    @Test
    @DisplayName("测试块内无序的数组")
    void testArrayWithUnorderedBlocks() {
        // 准备测试数据：块间有序，块内无序
        // 块1: [5, 3, 2, 4, 1] (最大值5)
        // 块2: [10, 8, 7, 9, 6] (最大值10)
        // 块3: [15, 13, 12, 14, 11] (最大值15)
        BlockSearch search = new BlockSearch();
        int[] arr = { 5, 3, 2, 4, 1, 10, 8, 7, 9, 6, 15, 13, 12, 14, 11 };
        int target = 12;
        int expected = 12;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "块内无序的数组中查找12，应该返回索引12");
    }
    
    /**
     * 测试特殊情况: 包含重复元素的数组
     */
    @Test
    @DisplayName("测试包含重复元素的数组")
    void testArrayWithDuplicateElements() {
        // 准备测试数据：包含重复元素的分块数组
        BlockSearch search = new BlockSearch();
        int[] arr = { 2, 3, 1, 3, 4, 6, 8, 7, 9 };
        int target = 3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果：分块查找可能返回任何匹配的索引，这里只验证找到了元素
        assertEquals(true, result != -1, "包含重复元素的数组中查找3，应该找到元素");
    }
    
    /**
     * 测试特殊情况: 包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        // 准备测试数据：包含负数的分块数组
        // 块1: [-5, -3, -4] (最大值-3)
        // 块2: [-2, 0, -1] (最大值0)
        // 块3: [2, 1, 3] (最大值3)
        BlockSearch search = new BlockSearch();
        int[] arr = { -5, -3, -4, -2, 0, -1, 2, 1, 3 };
        int target = -1;
        int expected = 5;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含负数的数组[-5,-3,-4,-2,0,-1,2,1,3]中查找-1，应该返回索引5");
    }
    
    /**
     * 测试特殊情况: 包含零的数组
     */
    @Test
    @DisplayName("测试包含零的数组")
    void testArrayWithZero() {
        // 准备测试数据：包含零的分块数组
        BlockSearch search = new BlockSearch();
        int[] arr = { 2, 3, 1, 0, 4, 6, 8, 7, 9 };
        int target = 0;
        int expected = 3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含零的数组[2,3,1,0,4,6,8,7,9]中查找0，应该返回索引3");
    }
    
    /**
     * 测试复杂场景: 长数组
     */
    @Test
    @DisplayName("测试复杂场景: 长数组")
    void testLongArray() {
        // 准备测试数据：长数组，分块有序
        BlockSearch search = new BlockSearch();
        int[] arr = new int[100];
        
        // 填充数组，每个块内无序，块间有序
        for (int i = 0; i < 100; i++) {
            // 每个块10个元素，块间最大值递增
            int blockMax = (i / 10 + 1) * 100;
            arr[i] = blockMax - (i % 10);
        }
        
        int target = 55;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "长数组中查找55，应该返回-1");
    }
    
    /**
     * 测试复杂场景: 块大小为1的情况
     */
    @Test
    @DisplayName("测试块大小为1的情况")
    void testBlockSizeOne() {
        // 准备测试数据：块大小为1的数组
        BlockSearch search = new BlockSearch();
        int[] arr = { 1, 3, 5, 7, 9 };
        int target = 7;
        int expected = 3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "块大小为1的数组[1,3,5,7,9]中查找7，应该返回索引3");
    }
}