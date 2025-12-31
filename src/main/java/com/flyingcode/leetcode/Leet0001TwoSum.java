package com.flyingcode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 该类提供一个高效的算法, 用于在整数数组中查找两个数, 使其和等于目标值, 并返回这两个数的索引.
 * 算法采用哈希表技术, 实现了线性时间复杂度.
 */
public class Leet0001TwoSum {

  /**
   * 算法设计思路:
   * 1. 使用哈希表存储数组元素及其对应的索引, 实现O(1)时间复杂度的查找
   * 2. 遍历数组中的每个元素 nums[i], 计算与目标值的差值 complement = target - nums[i]
   * 3. 检查哈希表中是否存在 complement:
   * - 若存在, 则找到解, 返回 complement 对应的索引和当前索引 i
   * - 若不存在, 则将当前元素 nums[i] 及其索引 i 存入哈希表
   * 4. 遍历完成后, 若未找到解则返回空数组
   *
   * 关键技术点:
   * - 哈希表的使用: 空间换时间, 将查找复杂度从O(n)降低到O(1)
   * - 单次遍历: 边遍历边存储, 避免重复计算
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是数组的长度.
   * 因为只需要遍历数组一次, 每个元素的哈希表操作(put和containsKey)都是O(1)时间复杂度
   * - 空间复杂度: O(n).
   * 最坏情况下, 需要将数组中的所有元素存入哈希表, 因此空间复杂度为O(n)
   */

  /**
   * 在整数数组中查找两个数, 使其和等于目标值, 并返回这两个数的索引
   *
   * @param nums   整数数组, 长度范围为2 <= nums.length <= 10^4, 元素范围为-10^9 <= nums[i] <=
   *               10^9
   * @param target 目标值, 范围为-10^9 <= target <= 10^9
   * @return 包含两个数的索引的数组, 索引范围为0 <= index1, index2 < nums.length, 且index1 < index2
   */
  public int[] twoSum(int[] nums, int target) {
    // 初始化HashMap, 用于存储数组元素和其索引的映射关系
    Map<Integer, Integer> map = new HashMap<>();

    // 遍历数组中的每个元素
    for (int i = 0; i < nums.length; i++) {
      // 计算当前元素与目标值的差值
      int complement = target - nums[i];

      // 检查差值是否已经存在于HashMap中
      if (map.containsKey(complement)) {
        // 若存在, 则返回差值对应的索引和当前索引
        return new int[] { map.get(complement), i };
      }

      // 若不存在, 则将当前元素和其索引添加到HashMap中
      map.put(nums[i], i);
    }

    // 题目保证有且只有一个解, 所以不会执行到这里
    return new int[0];
  }
}
