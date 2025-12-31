package com.flyingcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希查找
 * 该类提供一个高效的哈希查找算法，用于在整数数组中查找目标值.
 * 算法采用哈希表技术，实现了平均O(1)时间复杂度的查找功能，空间复杂度为 O(n).
 */
public class HashSearch {

  /**
   * 算法设计思路:
   * 1. 构建哈希表: 将数组中的元素作为键，元素索引作为值存储到HashMap中
   * 2. 查找目标值: 直接通过目标值作为键在哈希表中查找对应的值（索引）
   * 3. 如果找到，返回索引；否则返回-1
   *
   * 关键技术点:
   * - 哈希表: 使用HashMap实现O(1)平均时间复杂度的查找
   * - 键值对: 元素值作为键，元素索引作为值
   * - 冲突处理: HashMap内部处理哈希冲突
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n)，其中 n 是数组的长度.
   * 构建哈希表需要遍历整个数组，时间复杂度为 O(n)
   * 查找操作的平均时间复杂度为 O(1)，最坏情况下为 O(n)（哈希冲突严重时）
   * - 空间复杂度: O(n).
   * 需要额外的哈希表存储空间，大小与数组长度相当
   */

  /**
   * 在整数数组中查找目标值的索引
   *
   * @param arr    输入的整数数组，可以包含负数、零和正数，无需排序
   * @param target 要查找的目标值
   * @return 如果找到目标值，返回其索引；否则返回-1
   */
  public int search(int[] arr, int target) {
    // 边界条件处理: 空数组或null数组直接返回-1
    if (arr == null || arr.length == 0) {
      return -1;
    }

    // 构建哈希表
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      hashMap.put(arr[i], i);
    }

    // 在哈希表中查找目标值
    return hashMap.getOrDefault(target, -1);
  }

  /**
   * 在整数数组中查找目标值的索引，处理有重复元素的情况
   * 返回第一个匹配的索引
   *
   * @param arr    输入的整数数组，可以包含负数、零和正数，无需排序
   * @param target 要查找的目标值
   * @return 如果找到目标值，返回第一个匹配的索引；否则返回-1
   */
  public int searchFirst(int[] arr, int target) {
    // 边界条件处理: 空数组或null数组直接返回-1
    if (arr == null || arr.length == 0) {
      return -1;
    }

    // 构建哈希表，只存储第一个出现的元素索引
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      // 如果元素未存在于哈希表中，才添加
      if (!hashMap.containsKey(arr[i])) {
        hashMap.put(arr[i], i);
      }
    }

    // 在哈希表中查找目标值
    return hashMap.getOrDefault(target, -1);
  }
}
