package com.flyingcode.leetcode;

/**
 * 二分查找
 * 该类提供了一个高效的算法, 用于在有序数组中查找目标值的索引.
 * 算法采用二分查找技术, 实现了O(log n)的时间复杂度.
 */
public class Leet0704BinarySearch {

    /**
     * 算法设计思路:
     * 1. 二分查找的前提是数组必须是有序的
     * 2. 初始化左指针为0, 右指针为数组长度-1
     * 3. 当左指针<=右指针时, 计算中间位置 mid = left + (right - left) / 2
     * 4. 如果中间位置的值等于目标值, 返回中间位置
     * 5. 如果中间位置的值大于目标值, 说明目标值在左半部分, 将右指针移到 mid - 1
     * 6. 否则, 说明目标值在右半部分, 将左指针移到 mid + 1
     * 7. 如果循环结束仍未找到目标值, 返回-1
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O(log n), 其中n是数组的长度.
     *   每次迭代都会将搜索范围缩小一半, 因此迭代次数为log2(n)级别.
     * - 空间复杂度: O(1), 只使用了常数级别的额外空间.
     */

    /**
     * 在有序数组中查找目标值的索引
     *
     * @param nums 有序整数数组, 必须按升序排列
     * @param target 要查找的目标值
     * @return 如果找到目标值, 返回其索引; 否则返回-1
     */
    public int solution(int[] nums, int target) {
        // 边界条件处理: 空数组返回-1
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 初始化左右指针
        int left = 0;
        int right = nums.length - 1;

        // 二分查找主循环
        while (left <= right) {
            // 计算中间位置, 防止整数溢出
            int mid = left + (right - left) / 2;

            // 找到目标值, 返回索引
            if (nums[mid] == target) {
                return mid;
            }
            // 目标值在左半部分, 移动右指针
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            // 目标值在右半部分, 移动左指针
            else {
                left = mid + 1;
            }
        }

        // 未找到目标值, 返回-1
        return -1;
    }
}
