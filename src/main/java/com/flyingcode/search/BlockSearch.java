package com.flyingcode.search;

/**
 * 分块查找
 * 该类提供一个高效的分块查找算法，用于在整数数组中查找目标值.
 * 算法将数组分成若干块，块内元素无序但块间有序，结合顺序查找和二分查找实现高效查找，空间复杂度为 O(√n).
 */
public class BlockSearch {

  /**
   * 算法设计思路:
   * 1. 将数组分成m个块，每个块的大小约为√n
   * 2. 创建索引表: 每个块记录该块的最大值和起始位置
   * 3. 块间查找: 遍历所有块，找到目标值可能所在的块
   * 4. 块内查找: 在目标块内使用顺序查找找到具体元素
   * 5. 如果找到，返回索引；否则返回-1
   *
   * 关键技术点:
   * - 分块策略: 块大小设置为√n，平衡块间查找和块内查找的时间复杂度
   * - 索引表: 存储每个块的最大值和起始位置
   * - 混合查找: 块间遍历，块内顺序查找
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(√n)，其中 n 是数组的长度.
   * 块间查找遍历所有块，时间复杂度为 O(m)，其中 m 是块的数量
   * 块内查找使用顺序查找，时间复杂度为 O(√n)
   * 总体时间复杂度为 O(m + √n) ≈ O(√n)
   * - 空间复杂度: O(√n).
   * 需要额外的索引表存储空间，大小与块的数量相当
   */

  /**
   * 分块查找的索引表结构
   */
  private static class IndexBlock {
    int maxValue; // 块内最大值
    int startIndex; // 块的起始索引
    int endIndex; // 块的结束索引

    IndexBlock(int maxValue, int startIndex, int endIndex) {
      this.maxValue = maxValue;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

  /**
   * 在整数数组中查找目标值的索引
   *
   * @param arr    输入的整数数组，块间必须有序，块内可以无序
   * @param target 要查找的目标值
   * @return 如果找到目标值，返回其索引；否则返回-1
   */
  public int search(int[] arr, int target) {
    // 边界条件处理: 空数组或null数组直接返回-1
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int n = arr.length;

    // 对于小数组，直接使用顺序查找
    if (n <= 10) {
      for (int i = 0; i < n; i++) {
        if (arr[i] == target) {
          return i;
        }
      }
      return -1;
    }

    // 计算块大小，一般取√n
    int blockSize = (int) Math.sqrt(n);
    // 计算块的数量
    int blockCount = (n + blockSize - 1) / blockSize;

    // 创建索引表
    IndexBlock[] indexTable = createIndexTable(arr, blockSize, blockCount);

    // 遍历所有块，查找目标值
    for (int i = 0; i < blockCount; i++) {
      // 如果当前块的最大值大于等于目标值，在当前块中查找
      if (target <= indexTable[i].maxValue) {
        int result = sequentialSearchInBlock(arr, indexTable[i], target);
        if (result != -1) {
          return result;
        }
      }
    }

    // 遍历所有块仍未找到，返回-1
    return -1;
  }

  /**
   * 创建索引表
   *
   * @param arr        原始数组
   * @param blockSize  块大小
   * @param blockCount 块数量
   * @return 索引表
   */
  private IndexBlock[] createIndexTable(int[] arr, int blockSize, int blockCount) {
    IndexBlock[] indexTable = new IndexBlock[blockCount];

    // 计算每个块的最大值
    for (int i = 0; i < blockCount; i++) {
      int startIndex = i * blockSize;
      int endIndex = Math.min((i + 1) * blockSize - 1, arr.length - 1);

      // 计算当前块的最大值
      int maxValue = arr[startIndex];
      for (int j = startIndex + 1; j <= endIndex; j++) {
        if (arr[j] > maxValue) {
          maxValue = arr[j];
        }
      }

      indexTable[i] = new IndexBlock(maxValue, startIndex, endIndex);
    }

    return indexTable;
  }

  /**
   * 在块内进行顺序查找
   *
   * @param arr    原始数组
   * @param block  目标块
   * @param target 目标值
   * @return 目标值的索引，如果没有找到返回-1
   */
  private int sequentialSearchInBlock(int[] arr, IndexBlock block, int target) {
    for (int i = block.startIndex; i <= block.endIndex; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
