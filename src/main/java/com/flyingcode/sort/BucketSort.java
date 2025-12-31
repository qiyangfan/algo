package com.flyingcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法将数组元素分配到有限数量的桶中, 然后对每个桶分别进行排序, 最后合并结果, 实现稳定排序.
 */
public class BucketSort {

  /**
   * 算法设计思路:
   * 1. 确定桶的数量和范围: 找出数组的最大值和最小值, 计算桶的数量
   * 2. 初始化桶结构: 创建指定数量的桶, 每个桶使用动态数组存储元素
   * 3. 分配元素到桶: 根据元素值计算应该放入的桶索引, 将元素添加到对应桶中
   * 4. 桶内排序: 对每个非空桶中的元素进行排序, 可以使用其他排序算法
   * 5. 合并桶元素: 将所有桶中的元素按顺序合并, 得到最终排序结果
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n + k), 其中 n 是数组长度, k 是桶的数量.
   * 平均情况下, 元素均匀分布在各个桶中, 每个桶的排序时间为 O(n/k log(n/k)), 总时间为 O(n + k)
   * 最好情况下, 每个桶只有一个元素, 时间复杂度为 O(n + k)
   * 最坏情况下, 所有元素都分配到一个桶中, 时间复杂度为 O(n^2)
   * - 空间复杂度: O(n + k).
   * 需要额外的桶空间和输出数组
   */

  /**
   * 对整数数组进行桶排序
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

    // 计算桶的数量, 这里使用固定值10个桶
    int bucketCount = 10;
    List<List<Integer>> buckets = new ArrayList<>(bucketCount);

    // 初始化桶: 创建指定数量的空桶
    for (int i = 0; i < bucketCount; i++) {
      buckets.add(new ArrayList<>());
    }

    // 将元素分配到桶中
    for (int num : arr) {
      // 计算元素应该放入的桶索引: 线性映射到桶区间
      // 公式: (num - min) * (bucketCount - 1) / (max - min)
      int bucketIndex = (int) ((num - min) * (bucketCount - 1) / (max - min));
      buckets.get(bucketIndex).add(num);
    }

    // 对每个桶中的元素进行排序, 使用Java内置的Collections.sort
    for (List<Integer> bucket : buckets) {
      Collections.sort(bucket);
    }

    // 合并所有桶中的元素, 构建最终排序结果
    int[] result = new int[arr.length];
    int index = 0;
    for (List<Integer> bucket : buckets) {
      for (int num : bucket) {
        result[index++] = num;
      }
    }

    return result;
  }
}
