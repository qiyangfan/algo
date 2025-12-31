package com.flyingcode.sort;

/**
 * 基数排序
 * 该类提供一个高效的非比较排序算法, 用于对整数数组进行排序.
 * 算法从最低有效位到最高有效位依次对元素进行排序, 实现稳定排序.
 * 基数排序适用于整数、字符串等可以按位比较的数据类型.
 */
public class RadixSort {

  /**
   * 算法设计思路:
   * 1. 确定最大位数: 找出数组中的最大值, 确定需要处理的最大位数
   * 2. 按位排序: 从最低有效位(个位)开始, 依次对每一位进行计数排序
   * 3. 位数递增: 每次处理完一位后, 将位数提升一位(十位、百位、千位...)
   * 4. 重复处理: 直到处理完最高有效位
   * 5. 最终结果: 经过所有位的排序后, 数组完成整体排序
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(d * (n + k)), 其中 n 是数组长度, d 是最大位数, k 是进制基数(这里为10).
   * - 每一位的计数排序时间为 O(n + k)
   * - 需要处理 d 位, 因此总时间复杂度为 O(d * (n + k))
   * - 最好、平均、最坏情况下时间复杂度均为 O(d * (n + k))
   * - 空间复杂度: O(n + k).
   * - 需要额外的计数数组(O(k))和输出数组(O(n))
   */

  /**
   * 对整数数组进行基数排序
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sort(int[] arr) {
    // 边界情况处理: 空数组或长度为1的数组无需排序
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 找出数组中的最大值, 用于确定最大位数
    int max = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }

    // 确定最大位数
    int maxDigits = 0;
    while (max > 0) {
      maxDigits++;
      max /= 10; // 每次除以10, 相当于右移一位
    }

    // 对每一位进行计数排序
    // 初始使用原数组的副本作为结果数组
    int[] result = arr.clone();
    int exp = 1; // 表示当前处理的位数 (1: 个位, 10: 十位, 100: 百位, ...)

    // 从最低有效位到最高有效位依次排序
    for (int i = 0; i < maxDigits; i++) {
      // 对当前位数进行计数排序
      result = countingSortByDigit(result, exp);
      // 位数提升一位
      exp *= 10;
    }

    return result;
  }

  /**
   * 按指定位数对数组进行计数排序
   * 该方法是基数排序的核心, 用于对数组中指定位数的数字进行排序
   *
   * @param arr 待排序的整数数组
   * @param exp 当前处理的位数 (1: 个位, 10: 十位, 100: 百位, ...)
   * @return 按当前位数排序后的数组
   */
  private int[] countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n]; // 存储排序结果的输出数组
    int[] count = new int[10]; // 计数数组, 0-9 共10个数字

    // 统计每个数字出现的次数
    for (int i = 0; i < n; i++) {
      // 计算当前元素在指定位数上的数字
      int digit = (arr[i] / exp) % 10;
      count[digit]++;
    }

    // 计算每个数字的结束位置
    // 将count数组转换为前缀和数组, 用于确定每个数字在输出数组中的位置
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // 从右往左遍历原数组, 将元素放到输出数组的正确位置
    // 从右往左遍历是为了保持排序的稳定性
    for (int i = n - 1; i >= 0; i--) {
      // 计算当前元素在指定位数上的数字
      int digit = (arr[i] / exp) % 10;
      // 根据count数组确定元素在输出数组中的位置
      output[count[digit] - 1] = arr[i];
      // 更新count数组, 为下一个相同数字的元素确定位置
      count[digit]--;
    }

    return output;
  }
}
