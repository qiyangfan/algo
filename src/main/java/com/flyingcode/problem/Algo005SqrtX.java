package com.flyingcode.problem;

/**
 * 计算非负整数的平方根整数部分 - 二分查找
 * 该类提供一个高效的算法, 用于计算给定非负整数的平方根的整数部分
 * 算法采用二分查找技术, 能够在对数时间内完成计算
 * 主要特点: 避免了直接计算平方可能导致的整数溢出问题
 */
public class Algo005SqrtX {
  /**
   * 算法设计思路:
   * 1. 利用平方根的数学性质: 对于非负整数x, 其平方根的整数部分k满足k*k <= x < (k+1)*(k+1)
   * 2. 采用二分查找算法在区间[1, x]中寻找满足条件的最大整数k
   * 3. 使用整数除法避免直接计算平方导致的溢出
   * 4. 通过维护左右边界, 逐步缩小搜索范围, 直到找到精确解或确定边界
   * 5. 计算中间值mid, 使用left + (right - left) / 2避免溢出
   * 6. 通过整数除法比较mid与x/mid的大小关系, 根据比较结果调整搜索区间
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(log n), 其中n为输入整数x
   * 每次迭代将搜索区间长度减半, 因此迭代次数为log2(n)级别
   * - 空间复杂度:O(1)
   * 仅使用了常数个变量(left, right, mid), 不随输入规模变化
   */

  /**
   * 计算非负整数的平方根整数部分
   *
   * @param x 输入的非负整数, 取值范围为0到Integer.MAX_VALUE
   * @return 输入整数的平方根整数部分, 即满足k*k ≤ x的最大整数k
   */
  public int solution(int x) {
    // 边界条件处理:0和1的平方根等于自身
    if (x == 0 || x == 1) {
      return x;
    }

    // 初始化搜索区间:left为可能的最小值,right为可能的最大值
    int left = 1;
    int right = x;

    // 二分查找循环: 当搜索区间不为空时继续搜索
    while (left <= right) {
      /*
       * 计算中间值mid, 避免使用(left+right)/2可能导致的整数溢出
       */
      int mid = left + (right - left) / 2;

      /*
       * 使用整数除法判断mid*mid与x的大小关系, 避免直接计算平方导致溢出
       */
      if (mid == x / mid) {
        // 找到精确解, 直接返回mid
        return mid;
      } else if (mid < x / mid) {
        /*
         * mid*mid < x, 说明平方根可能在右半区间, 调整左边界
         */
        left = mid + 1;
      } else {
        /*
         * mid*mid > x, 说明平方根可能在左半区间, 调整右边界
         */
        right = mid - 1;
      }
    }

    // 循环结束时,right为满足k*k ≤ x的最大整数
    return right;
  }
}
