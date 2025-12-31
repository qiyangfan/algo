package com.flyingcode.leetcode;

/**
 * 排序数组
 * 该类提供了一个高效的算法, 用于对整数数组进行排序.
 * 算法采用快速排序技术, 实现了O(n log n)的平均时间复杂度.
 */
public class Leet0912SortAnArray {

    /**
     * 算法设计思路:
     * 1. 快速排序是一种分治算法, 通过选择一个基准元素将数组分为左右两部分
     * 2. 核心步骤:
     *    a. 选择基准元素(pivot), 这里选择数组的最后一个元素
     *    b. 分区(partition): 将小于基准的元素移到基准左边, 大于基准的元素移到基准右边
     *    c. 递归地对左右两个子数组进行快速排序
     * 3. 优化点:
     *    a. 使用原地分区, 避免额外的空间开销
     *    b. 递归终止条件: 当子数组长度为1或0时直接返回
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O(n log n), 其中n是数组的长度.
     *   平均情况下, 每次分区将数组分成两个大致相等的子数组, 递归深度为log n, 每次分区需要O(n)时间.
     *   最坏情况下(如数组已排序), 时间复杂度为O(n²), 但实际应用中这种情况很少见.
     * - 空间复杂度: O(log n), 递归调用栈的深度取决于递归深度, 平均为log n.
     */

    /**
     * 对整数数组进行排序
     *
     * @param nums 要排序的整数数组
     * @return 排序后的整数数组
     */
    public int[] solution(int[] nums) {
        // 边界条件处理: 空数组或只有一个元素的数组直接返回
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // 调用快速排序算法
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    /**
     * 快速排序主函数
     *
     * @param nums 要排序的数组
     * @param left 排序起始位置
     * @param right 排序结束位置
     */
    private void quickSort(int[] nums, int left, int right) {
        // 递归终止条件: 左指针大于等于右指针
        if (left >= right) {
            return;
        }

        // 分区操作, 获取基准元素的正确位置
        int pivotIndex = partition(nums, left, right);

        // 递归排序左子数组
        quickSort(nums, left, pivotIndex - 1);
        // 递归排序右子数组
        quickSort(nums, pivotIndex + 1, right);
    }

    /**
     * 分区操作, 将数组分为两部分
     *
     * @param nums 要分区的数组
     * @param left 分区起始位置
     * @param right 分区结束位置
     * @return 基准元素的正确位置
     */
    private int partition(int[] nums, int left, int right) {
        // 选择最后一个元素作为基准
        int pivot = nums[right];

        // i指向小于基准的元素的最后一个位置
        int i = left - 1;

        // 遍历数组, 将小于基准的元素移到左边
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                // 交换元素
                swap(nums, i, j);
            }
        }

        // 将基准元素放到正确的位置
        swap(nums, i + 1, right);

        return i + 1;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        // 不使用内置函数, 手动交换元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
