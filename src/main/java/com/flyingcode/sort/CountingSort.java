package com.flyingcode.sort;

/**
 * 计数排序
 * 该类提供一个高效的非比较排序算法, 用于对整数数组进行排序.
 * 算法通过统计每个元素出现的次数来实现排序, 实现稳定排序.
 * 计数排序适用于已知数据范围的场景, 尤其是数据范围不大的情况.
 */
public class CountingSort {

  /**
   * 算法设计思路:
   * 1. 确定数据范围: 找出数组的最大值和最小值, 计算数据范围
   * 2. 创建计数数组: 长度为数据范围, 用于统计每个元素出现的次数
   * 3. 统计元素次数: 遍历待排序数组, 统计每个元素的出现次数并存储到计数数组中
   * 4. 重构排序数组: 遍历计数数组, 根据元素出现次数重构排序后的数组
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n + k), 其中 n 是数组长度, k 是元素的取值范围.
   * 需要遍历数组两次: 一次统计次数(O(n)), 一次重构数组(O(n + k))
   * 最好、平均、最坏情况下时间复杂度均为 O(n + k)
   * - 空间复杂度: O(n + k).
   * 需要额外的计数数组(O(k))和输出数组(O(n))
   */

  /**
   * 对整数数组进行计数排序
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sort(int[] arr) {
    // 边界情况处理: 空数组或长度为1的数组无需排序
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 找出数组中的最大值和最小值, 确定数据范围
    int max = arr[0];
    int min = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
      if (num < min) {
        min = num;
      }
    }

    // 创建计数数组, 长度为数据范围
    int range = max - min + 1;
    int[] count = new int[range];

    // 统计每个元素出现的次数
    // 映射关系: 原数组元素num对应计数数组索引num - min
    for (int num : arr) {
      count[num - min]++;
    }

    // 重构排序后的数组
    int[] result = new int[arr.length];
    int index = 0;
    for (int i = 0; i < range; i++) {
      // 将计数数组中记录的元素按顺序放入结果数组
      // 计数数组索引i对应原数组元素i + min
      while (count[i] > 0) {
        result[index++] = i + min;
        count[i]--;
      }
    }

    return result;
  }
}
