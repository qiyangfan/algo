package com.flyingcode.leetcode;

/**
 * 排序数组
 * 该类提供了高效的算法, 用于对整数数组进行排序.
 * 实现了传统快排和双轴快排两种算法, 平均时间复杂度为O(n log n).
 */
public class Leet0912SortAnArray {

    /**
     * 算法选择标志: true表示使用双轴快排, false表示使用传统快排
     */
    private static final boolean USE_DUAL_PIVOT = true;

    /**
     * 传统快排算法设计思路:
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
     * 双轴快排算法设计思路:
     * 1. 双轴快排是传统快排的改进版本, 使用两个基准元素将数组分为三部分
     * 2. 核心步骤:
     *    a. 选择两个基准元素(pivot1, pivot2), 确保pivot1 < pivot2
     *    b. 三区划分: 小于pivot1 | pivot1到pivot2之间 | 大于pivot2
     *    c. 递归地对三个子数组进行双轴快排
     * 3. 优势:
     *    a. 减少递归深度, 提高缓存命中率
     *    b. 对于部分有序的数据表现更优
     *    c. 平均比较次数更少, 实际性能提升约10-20%
     */

    /**
     * 算法复杂度分析:
     * - 传统快排时间复杂度: O(n log n)
     *   平均情况下, 每次分区将数组分成两个大致相等的子数组, 递归深度为log n
     *   最坏情况下(如数组已排序), 时间复杂度为O(n²)
     * - 双轴快排时间复杂度: O(n log n)
     *   平均情况下性能优于传统快排, 递归深度更浅, 分区更均衡
     *   最坏情况下仍为O(n²), 但概率更低
     * - 空间复杂度: O(log n), 递归调用栈的深度取决于递归深度
     */

    /**
     * 对整数数组进行排序
     * 根据USE_DUAL_PIVOT标志选择使用传统快排或双轴快排
     *
     * @param nums 要排序的整数数组
     * @return 排序后的整数数组
     */
    public int[] solution(int[] nums) {
        // 边界条件处理: 空数组或只有一个元素的数组直接返回
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // 根据标志选择算法
        if (USE_DUAL_PIVOT) {
            dualPivotQuickSort(nums, 0, nums.length - 1);
        } else {
            quickSort(nums, 0, nums.length - 1);
        }

        return nums;
    }

    /**
     * 使用传统快排对整数数组进行排序
     *
     * @param nums 要排序的整数数组
     * @return 排序后的整数数组
     */
    public int[] solutionWithTraditionalQuickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 使用双轴快排对整数数组进行排序
     *
     * @param nums 要排序的整数数组
     * @return 排序后的整数数组
     */
    public int[] solutionWithDualPivotQuickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        dualPivotQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序主函数
     *
     * @param nums  要排序的数组
     * @param left  排序起始位置
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
     * @param nums  要分区的数组
     * @param left  分区起始位置
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
     * @param i    第一个元素的索引
     * @param j    第二个元素的索引
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

    /**
     * 双轴快速排序主函数
     * 使用两个基准元素将数组分为三部分进行递归排序
     *
     * @param nums  要排序的数组
     * @param left  排序起始位置
     * @param right 排序结束位置
     */
    private void dualPivotQuickSort(int[] nums, int left, int right) {
        // 递归终止条件: 左指针大于等于右指针
        if (left >= right) {
            return;
        }

        // 选择两个基准元素: 确保pivot1 < pivot2
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }

        int pivot1 = nums[left];   // 左基准(较小)
        int pivot2 = nums[right];  // 右基准(较大)

        // 三指针初始化
        int less = left + 1;    // 指向小于pivot1的区域的右边界
        int great = right - 1;  // 指向大于pivot2的区域的左边界
        int i = less;           // 当前遍历指针

        // 遍历数组, 进行三区划分
        while (i <= great) {
            if (nums[i] < pivot1) {
                // 当前元素小于pivot1, 交换到左区域
                swap(nums, i, less);
                less++;
                i++;
            } else if (nums[i] > pivot2) {
                // 当前元素大于pivot2, 交换到右区域
                swap(nums, i, great);
                great--;
                // 不递增i, 因为交换过来的元素还需要检查
            } else {
                // 当前元素在pivot1和pivot2之间, 保持不动
                i++;
            }
        }

        // 将基准元素放到正确的位置
        swap(nums, left, less - 1);
        swap(nums, right, great + 1);

        // 递归排序三个子数组
        dualPivotQuickSort(nums, left, less - 2);      // 小于pivot1的区域
        dualPivotQuickSort(nums, less, great);        // pivot1到pivot2之间的区域
        dualPivotQuickSort(nums, great + 2, right);   // 大于pivot2的区域
    }
}
