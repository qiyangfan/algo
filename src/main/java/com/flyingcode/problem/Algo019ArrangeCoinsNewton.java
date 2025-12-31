package com.flyingcode.problem;

public class Algo019ArrangeCoinsNewton {
  /**
   * 计算可以排列成完整阶梯行的硬币总行数(使用牛顿迭代法)
   *
   * @param n 总硬币数,n>=0
   * @return 可以形成的完整阶梯行的总行数
   */
  public int solution(int n) {
    // 处理n=0的边界情况
    if (n == 0) {
      return 0;
    }

    // 初始化牛顿迭代法的初始值为n/2, 这是一个合理的初始猜测
    int x = n / 2;

    // 牛顿迭代法循环, 直到收敛(变化量小于1)
    while (x * (x + 1) / 2 > n) {
      // 使用牛顿迭代公式更新x, 其中f(x) = x^2 - n, f'(x) = 2x
      // 目标是找到一个x, 使得f(x) = 0, 即x^2 - n = 0
      x = (x + n / x) / 2;
    }

    // 循环结束时,x就是最后一个可以完整放置的行数
    // 因为当x^2 - n < 1时,x就是最大的满足S(k) <= n的k值
    return x;
  }

  public static int sqrt(int n) {
    // 处理n=0的边界情况
    if (n == 0) {
      return 0;
    }

    // 初始化牛顿迭代法的初始值为n/2, 这是一个合理的初始猜测
    int x = n / 2;

    // 牛顿迭代法循环, 直到收敛(变化量小于1)
    while (x * x > n) {
      // 使用牛顿迭代公式更新x, 其中f(x) = x^2 - n, f'(x) = 2x
      // 目标是找到一个x, 使得f(x) = 0, 即x^2 - n = 0
      x = (x + n / x) / 2;
    }

    // 循环结束时,x就是最后一个可以完整放置的行数
    // 因为当x^2 - n < 1时,x就是最大的满足S(k) <= n的k值
    return x;
  }
}
