package com.flyingcode.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: TreeTableSearch
 * 使用JUnit 5测试树表查找算法的正确性
 */
class TreeTableSearchTest {

    /**
     * 测试基本功能: 标准数组中查找存在的元素
     */
    @Test
    @DisplayName("测试标准数组中查找存在的元素")
    void testStandardArrayWithExistingElement() {
        // 准备测试数据
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 5, 3, 7, 2, 4, 6, 8 };
        int target = 4;
        int expected = 4;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "数组[5,3,7,2,4,6,8]中查找4，应该返回4");
    }
    
    /**
     * 测试基本功能: 标准数组中查找不存在的元素
     */
    @Test
    @DisplayName("测试标准数组中查找不存在的元素")
    void testStandardArrayWithNonExistingElement() {
        // 准备测试数据
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 5, 3, 7, 2, 4, 6, 8 };
        int target = 9;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "数组[5,3,7,2,4,6,8]中查找9，应该返回-1");
    }
    
    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        // 准备测试数据
        TreeTableSearch search = new TreeTableSearch();
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
        TreeTableSearch search = new TreeTableSearch();
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
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 10 };
        int target = 10;
        int expected = 10;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "单个元素数组[10]中查找10，应该返回10");
    }
    
    /**
     * 测试边界条件: 单个元素数组，元素不存在
     */
    @Test
    @DisplayName("测试单个元素数组，元素不存在")
    void testSingleElementArrayWithNonExistingElement() {
        // 准备测试数据
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 10 };
        int target = 5;
        int expected = -1;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "单个元素数组[10]中查找5，应该返回-1");
    }
    
    /**
     * 测试特殊情况: 包含重复元素的数组
     */
    @Test
    @DisplayName("测试包含重复元素的数组")
    void testArrayWithDuplicateElements() {
        // 准备测试数据：包含重复元素的数组
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 5, 3, 7, 3, 4, 6, 8 };
        int target = 3;
        int expected = 3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含重复元素的数组[5,3,7,3,4,6,8]中查找3，应该返回3");
    }
    
    /**
     * 测试特殊情况: 包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        // 准备测试数据：包含负数的数组
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 5, -3, 7, -5, 4, 0, 8 };
        int target = -3;
        int expected = -3;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含负数的数组[5,-3,7,-5,4,0,8]中查找-3，应该返回-3");
    }
    
    /**
     * 测试特殊情况: 包含零的数组
     */
    @Test
    @DisplayName("测试包含零的数组")
    void testArrayWithZero() {
        // 准备测试数据：包含零的数组
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 5, 3, 7, 2, 4, 0, 8 };
        int target = 0;
        int expected = 0;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "包含零的数组[5,3,7,2,4,0,8]中查找0，应该返回0");
    }
    
    /**
     * 测试复杂场景: 长数组
     */
    @Test
    @DisplayName("测试复杂场景: 长数组")
    void testLongArray() {
        // 准备测试数据：长数组
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i * 2;
        }
        int target = 98;
        int expected = 98;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "长数组中查找98，应该返回98");
    }
    
    /**
     * 测试复杂场景: 已排序的数组
     */
    @Test
    @DisplayName("测试复杂场景: 已排序的数组")
    void testSortedArray() {
        // 准备测试数据：已排序的数组（构建平衡二叉搜索树）
        TreeTableSearch search = new TreeTableSearch();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 6;
        int expected = 6;
        
        // 执行测试方法
        int result = search.search(arr, target);
        
        // 验证结果
        assertEquals(expected, result, "已排序的数组[1,2,3,4,5,6,7,8,9]中查找6，应该返回6");
    }
}