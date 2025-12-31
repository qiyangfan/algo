package com.flyingcode.sort;

/**
 * 快速排序
 * 该类提供高效的排序算法, 用于对整数数组进行排序.
 * 实现了传统快排和双轴快排两种算法, 均采用分治策略.
 * 快速排序是一种原地排序算法, 平均情况下性能优异, 是常用的排序算法之一.
 */
public class QuickSort {

  /**
   * 算法选择标志: true表示使用双轴快排, false表示使用传统快排
   */
  private static final boolean USE_DUAL_PIVOT = true;

  /**
   * 传统快排算法设计思路:
   * 1. 选择基准元素(pivot): 通常选择数组的第一个或最后一个元素
   * 2. 分区操作(partition): 将数组分为两部分
   * - 小于等于基准的元素放在基准左边
   * - 大于基准的元素放在基准右边
   * 3. 递归排序: 对基准左边和右边的子数组分别递归执行快排
   * 4. 递归终止条件: 子数组长度为0或1
   */

  /**
   * 双轴快排算法设计思路:
   * 1. 选择两个基准元素(pivot1, pivot2), 确保pivot1 < pivot2
   * 2. 三区划分: 将数组分为三个部分
   * - 小于pivot1的元素
   * - pivot1到pivot2之间的元素
   * - 大于pivot2的元素
   * 3. 递归排序: 对三个子数组分别递归执行双轴快排
   * 4. 递归终止条件: 子数组长度为0或1
   */

  /**
   * 算法复杂度分析:
   * - 传统快排时间复杂度: O(n log n), 其中 n 是数组长度.
   * - 平均情况下: 每轮分区将数组分成两个大小相近的子数组, 递归深度为 log n
   * - 最坏情况下: 分区不平衡, 时间复杂度为 O(n^2)
   * - 最好情况下: 每轮分区都将数组均匀分成两部分, 时间复杂度为 O(n log n)
   *
   * - 双轴快排时间复杂度: O(n log n), 其中 n 是数组长度.
   * - 平均情况下: 性能优于传统快排, 递归深度更浅, 分区更均衡
   * - 最坏情况下: 仍为 O(n^2), 但概率更低
   *
   * - 空间复杂度: O(log n).
   * - 递归调用栈的深度, 平均情况下为 log n
   * - 最坏情况下为 O(n), 但概率较低
   */

  /**
   * 对整数数组进行快速排序
   * 根据USE_DUAL_PIVOT标志选择使用传统快排或双轴快排
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sort(int[] arr) {
    // 边界情况处理: 空数组或长度为1的数组无需排序
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 根据标志选择算法
    if (USE_DUAL_PIVOT) {
      dualPivotQuickSort(arr, 0, arr.length - 1);
    } else {
      quickSort(arr, 0, arr.length - 1);
    }

    return arr;
  }

  /**
   * 使用传统快排对整数数组进行排序
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sortWithTraditionalQuickSort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    quickSort(arr, 0, arr.length - 1);
    return arr;
  }

  /**
   * 使用双轴快排对整数数组进行排序
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sortWithDualPivotQuickSort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    dualPivotQuickSort(arr, 0, arr.length - 1);
    return arr;
  }

  /**
   * 递归实现传统快速排序
   *
   * @param arr   待排序的整数数组
   * @param left  当前子数组的左边界索引
   * @param right 当前子数组的右边界索引
   */
  private void quickSort(int[] arr, int left, int right) {
    // 递归终止条件: 子数组长度为0或1
    if (left < right) {
      // 获取分区点: 基准元素的最终位置
      int pivotIndex = partition(arr, left, right);
      // 递归排序基准左边的子数组
      quickSort(arr, left, pivotIndex - 1);
      // 递归排序基准右边的子数组
      quickSort(arr, pivotIndex + 1, right);
    }
  }

  /**
   * 分区操作, 将数组分成两部分
   *
   * @param arr   待分区的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   * @return 基准元素的最终位置
   */
  private int partition(int[] arr, int left, int right) {
    // 选择最右边的元素作为基准
    int pivot = arr[right];
    // i 指向小于等于基准元素区域的右边界
    int i = left - 1;

    // 遍历数组[left, right-1], 将小于等于基准的元素放到左边
    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        // 扩大小于等于基准的区域, 交换元素
        i++;
        // 交换i和j位置的元素
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // 将基准元素放到正确位置: 小于等于基准区域的右边
    int temp = arr[i + 1];
    arr[i + 1] = arr[right];
    arr[right] = temp;

    return i + 1;
  }

  /**
   * 双轴快速排序主函数
   * 使用两个基准元素将数组分为三部分进行递归排序
   *
   * @param arr   待排序的整数数组
   * @param left  当前子数组的左边界索引
   * @param right 当前子数组的右边界索引
   */
  private void dualPivotQuickSort(int[] arr, int left, int right) {
    // 递归终止条件: 左指针大于等于右指针
    if (left >= right) {
      return;
    }

    // 选择两个基准元素, 确保pivot1 < pivot2
    // 初始选择左边界和右边界元素作为候选基准
    if (arr[left] > arr[right]) {
      // 交换元素, 确保pivot1 < pivot2
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
    }

    int pivot1 = arr[left]; // 左基准(较小值)
    int pivot2 = arr[right]; // 右基准(较大值)

    // 三指针初始化
    int less = left + 1; // 指向小于pivot1的区域的右边界
    int great = right - 1; // 指向大于pivot2的区域的左边界
    int i = less; // 当前遍历指针

    // 遍历数组, 进行三区划分
    while (i <= great) {
      if (arr[i] < pivot1) {
        // 当前元素小于pivot1, 交换到左区域
        int temp = arr[i];
        arr[i] = arr[less];
        arr[less] = temp;
        less++;
        i++;
      } else if (arr[i] > pivot2) {
        // 当前元素大于pivot2, 交换到右区域
        int temp = arr[i];
        arr[i] = arr[great];
        arr[great] = temp;
        great--;
        // 不递增i, 因为交换过来的元素还需要检查
      } else {
        // 当前元素在pivot1和pivot2之间, 保持不动
        i++;
      }
    }

    // 将基准元素放到正确的位置
    // 将pivot1放到小于pivot1区域的右边
    int temp = arr[left];
    arr[left] = arr[less - 1];
    arr[less - 1] = temp;

    // 将pivot2放到大于pivot2区域的左边
    temp = arr[right];
    arr[right] = arr[great + 1];
    arr[great + 1] = temp;

    // 递归排序三个子数组
    dualPivotQuickSort(arr, left, less - 2); // 小于pivot1的区域
    dualPivotQuickSort(arr, less, great); // pivot1到pivot2之间的区域
    dualPivotQuickSort(arr, great + 2, right); // 大于pivot2的区域
  }

}
