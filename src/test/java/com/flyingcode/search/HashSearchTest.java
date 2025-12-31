package com.flyingcode.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: HashSearch
 * 使用JUnit 5测试哈希查找算法的正确性
 */
class HashSearchTest {

    /**
     * 测试基本功能: 标准数组中查找存在的元素
     */
    @Test
    @DisplayName("测试标准数组中查找存在的元素")
    void testStandardArrayWithExistingElement() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 1, 3, 5, 7, 9 };
        int target = 5;
        int expected = 2;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "数组[1,3,5,7,9]中查找5，应该返回索引2");
    }
    
    /**
     * 测试基本功能: 标准数组中查找不存在的元素
     */
    @Test
    @DisplayName("测试标准数组中查找不存在的元素")
    void testStandardArrayWithNonExistingElement() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 1, 3, 5, 7, 9 };
        int target = 4;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "数组[1,3,5,7,9]中查找4，应该返回-1");
    }
    
    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        // 准备测试数据
        HashSearch search = new HashSearch();
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
        HashSearch search = new HashSearch();
        int[] arr = null;
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "null数组中查找任何元素，应该返回-1");
    }
    
    /**
     * 测试边界条件: 单个元素数组，元素存在
     */
    @Test
    @DisplayName("测试单个元素数组，元素存在")
    void testSingleElementArrayWithExistingElement() {
        // 准备测试数据
        HashSearch search = new HashSearch();
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
        HashSearch search = new HashSearch();
        int[] arr = { 10 };
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "单个元素数组[10]中查找5，应该返回-1");
    }
    
    /**
     * 测试特殊情况: 包含重复元素的数组，返回最后一个匹配的索引
     */
    @Test
    @DisplayName("测试包含重复元素的数组，返回最后一个匹配的索引")
    void testArrayWithDuplicateElements() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 2, 4, 6, 4, 8, 4, 10 };
        int target = 4;
        int expected = 5;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含重复元素的数组[2,4,6,4,8,4,10]中查找4，应该返回最后一个匹配的索引5");
    }
    
    /**
     * 测试特殊情况: 包含重复元素的数组，返回第一个匹配的索引
     */
    @Test
    @DisplayName("测试包含重复元素的数组，返回第一个匹配的索引")
    void testArrayWithDuplicateElementsSearchFirst() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 2, 4, 6, 4, 8, 4, 10 };
        int target = 4;
        int expected = 1;
        
        // 执行测试方法
        int result = search.searchFirst(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含重复元素的数组[2,4,6,4,8,4,10]中查找4，应该返回第一个匹配的索引1");
    }
    
    /**
     * 测试特殊情况: 包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { -5, -3, 0, 2, 4 };
        int target = -3;
        int expected = 1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含负数的数组[-5,-3,0,2,4]中查找-3，应该返回索引1");
    }
    
    /**
     * 测试特殊情况: 包含零的数组
     */
    @Test
    @DisplayName("测试包含零的数组")
    void testArrayWithZero() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 1, 0, 3, 0, 5 };
        int target = 0;
        int expected = 3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含零的数组[1,0,3,0,5]中查找0，应该返回最后一个匹配的索引3");
    }
    
    /**
     * 测试复杂场景: 长数组
     */
    @Test
    @DisplayName("测试复杂场景: 长数组")
    void testLongArray() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i * 2;
        }
        int target = 998;
        int expected = 499;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "长数组中查找998，应该返回索引499");
    }
    
    /**
     * 测试复杂场景: 所有元素相同的数组
     */
    @Test
    @DisplayName("测试所有元素相同的数组")
    void testAllSameElements() {
        // 准备测试数据
        HashSearch search = new HashSearch();
        int[] arr = { 5, 5, 5, 5, 5 };
        int target = 5;
        int expectedSearch = 4;
        int expectedSearchFirst = 0;
        
        // 执行测试方法
        int resultSearch = search.search(arr, target);
        int resultSearchFirst = search.searchFirst(arr, target);
        
        // 验证结果
        assertEquals(expectedSearch, resultSearch, "所有元素相同的数组[5,5,5,5,5]中查找5，search方法应该返回最后一个索引4");
        assertEquals(expectedSearchFirst, resultSearchFirst, "所有元素相同的数组[5,5,5,5,5]中查找5，searchFirst方法应该返回第一个索引0");
    }
}