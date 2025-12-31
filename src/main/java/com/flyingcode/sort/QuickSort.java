package com.flyingcode.sort;

/**
 * 快速排序
 * 该类提供高效的排序算法, 用于对整数数组进行排序.
 * 实现了传统快排和双轴快排两种算法, 均采用分治策略.
 */
public class QuickSort {

  /**
   * 算法选择标志: true表示使用双轴快排, false表示使用传统快排
   */
  private static final boolean USE_DUAL_PIVOT = true;

  /**
   * 传统快排算法设计思路:
   * 1. 选择一个基准元素(pivot), 通常选择数组的第一个或最后一个元素
   * 2. 分区操作: 将数组中小于基准的元素放在基准左边, 大于基准的元素放在基准右边
   * 3. 对基准左边和右边的子数组分别递归地执行步骤1和步骤2
   * 4. 递归结束条件是子数组长度为0或1
   */

  /**
   * 双轴快排算法设计思路:
   * 1. 选择两个基准元素(pivot1, pivot2), 确保pivot1 < pivot2
   * 2. 三区划分: 小于pivot1 | pivot1到pivot2之间 | 大于pivot2
   * 3. 对三个子数组分别递归地执行双轴快排
   * 4. 小数组优化: 对小规模子数组使用插入排序
   */

  /**
   * 算法复杂度分析:
   * - 传统快排时间复杂度: O(n log n)
   * 平均情况下, 每轮分区将数组分成两个大小相近的子数组, 递归深度为 log n
   * 最坏情况下, 分区不平衡, 时间复杂度为 O(n^2)
   * - 双轴快排时间复杂度: O(n log n)
   * 平均情况下性能优于传统快排, 递归深度更浅, 分区更均衡
   * 最坏情况下仍为 O(n^2), 但概率更低
   * - 空间复杂度: O(log n)
   * 递归调用栈的深度, 平均情况下为 log n, 最坏情况下为 O(n)
   */

  /**
   * 对整数数组进行快速排序
   * 根据USE_DUAL_PIVOT标志选择使用传统快排或双轴快排
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
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
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sortWithTraditionalQuickSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    quickSort(arr, 0, arr.length - 1);
    return arr;
  }

  /**
   * 使用双轴快排对整数数组进行排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sortWithDualPivotQuickSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    dualPivotQuickSort(arr, 0, arr.length - 1);
    return arr;
  }

  /**
   * 递归实现快速排序
   *
   * @param arr   待排序的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   */
  private void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      // 获取分区点
      int pivotIndex = partition(arr, left, right);
      // 对基准左边的子数组进行排序
      quickSort(arr, left, pivotIndex - 1);
      // 对基准右边的子数组进行排序
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
    // i 指向小于基准元素区域的右边界
    int i = left - 1;

    // 遍历数组, 将小于基准的元素放到左边
    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        i++;
        // 交换元素
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // 将基准元素放到正确位置
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
   * @param left  左边界索引
   * @param right 右边界索引
   */
  private void dualPivotQuickSort(int[] arr, int left, int right) {
    // 递归终止条件: 左指针大于等于右指针
    if (left >= right) {
      return;
    }

    // 选择两个基准元素: 确保pivot1 < pivot2
    if (arr[left] > arr[right]) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
    }

    int pivot1 = arr[left]; // 左基准(较小)
    int pivot2 = arr[right]; // 右基准(较大)

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
    int temp = arr[left];
    arr[left] = arr[less - 1];
    arr[less - 1] = temp;

    temp = arr[right];
    arr[right] = arr[great + 1];
    arr[great + 1] = temp;

    // 递归排序三个子数组
    dualPivotQuickSort(arr, left, less - 2); // 小于pivot1的区域
    dualPivotQuickSort(arr, less, great); // pivot1到pivot2之间的区域
    dualPivotQuickSort(arr, great + 2, right); // 大于pivot2的区域
  }

  /**
   * 插入排序
   * 用于小数组优化, 当数组长度较小时性能优于快排
   *
   * @param arr   待排序的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   */
  private void insertionSort(int[] arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      int key = arr[i];
      int j = i - 1;

      // 将大于key的元素向后移动
      while (j >= left && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }

      arr[j + 1] = key;
    }
  }
}
