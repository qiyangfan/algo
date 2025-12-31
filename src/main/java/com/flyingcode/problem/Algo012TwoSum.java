package com.flyingcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 - 无序数组哈希表解法
 * 该类提供一个高效的算法, 用于在无序数组中找出两个数, 使它们的和等于目标值
 * 算法采用哈希表技术, 通过空间换时间的方式, 实现线性时间复杂度
 * 主要特点: 只需一次遍历, 时间效率高
 */
public class Algo012TwoSum {
  /**
   * 算法设计思路:
   * 1. 使用哈希表存储数组元素及其索引的映射关系
   * 2. 遍历数组, 对于每个元素, 计算其补数(目标值 - 当前元素值)
   * 3. 检查补数是否已存在于哈希表中
   * 4. 如果存在, 说明找到了两个数, 返回它们的索引
   * 5. 如果不存在, 将当前元素及其索引存入哈希表, 继续遍历
   * 6. 这种方法实现了在一次遍历中完成查找, 避免了重复遍历
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中n是数组的长度
   * 只需遍历数组一次, 哈希表的查找和插入操作平均时间为O(1)
   * - 空间复杂度:O(n)
   * 最坏情况下需要存储n个元素到哈希表中
   */

  /**
   * 在无序数组中查找两个数, 使它们的和等于目标值, 并返回它们的索引
   *
   * @param nums   输入的无序整数数组
   * @param target 目标和值
   * @return 包含两个元素索引的数组, 若未找到则返回空数组
   */
  public int[] solution(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    return new int[0];
  }
}
