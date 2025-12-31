# Code Comment Examples

## Important Formatting Rules

**Language & Punctuation Standards**:
- **[MANDATORY]** Use Chinese for all code comments, documentation, and descriptions
- **[MANDATORY]** Use English punctuation marks in all text (commas, periods, colons, semicolons, etc.) - **[ABSOLUTELY PROHIBITED]** Use Chinese punctuation marks
- This is a CRITICAL requirement - all Chinese comments must use English punctuation marks exclusively
- **No emoji**: Do not use emoji symbols in any code comments or documentation

## Related Documentation

- **[COMMENT_RULES.md](COMMENT_RULES.md)** - Code comment standards and rules
- **[TEST_EXAMPLES.md](TEST_EXAMPLES.md)** - Test class writing examples
- **[CLAUDE.md](CLAUDE.md)** - Project structure and development guide

---

## 1. Class-Level Comment Examples

### 1.1 Simple Algorithm

```java
/**
 * 最长连续递增子序列长度
 * 该类提供一个高效的算法, 用于查找未排序数组中最长的连续递增子序列的长度.
 * 算法采用单次遍历技术, 实现了线性时间复杂度, 空间复杂度为 O(1).
 */
public class Algo025MaxIncSubseq {
    // Implementation...
}
```

### 1.2 Algorithm with Special Method

```java
/**
 * 预测赢家: 动态规划数组实现
 * 本类提供一个算法, 用于判断在双方从数组两端轮流选择数字的游戏中, 先手玩家是否能获胜.
 * 算法使用动态规划方法, 计算在双方都采用最优策略的情况下, 先手玩家是否能保证获胜或平局.
 */
public class Algo032PredictWinnerDP {
    // Implementation...
}
```

### 1.3 Multi-Method Algorithm

```java
/**
 * 二叉树中序遍历
 * 该类提供两种高效的算法, 用于实现二叉树的中序遍历.
 * 算法采用递归和迭代两种技术, 均实现了线性时间复杂度, 空间复杂度为 O(n).
 */
public class Leet0094BinaryTreeInorderTraversal {
    // Implementation...
}
```

### 1.4 Sorting Algorithm

```java
/**
 * 快速排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分治策略, 选择基准元素将数组分割成两部分, 实现不稳定排序.
 */
public class QuickSort {
    // Implementation...
}
```

## 2. Algorithm Design Approach Examples

### 2.1 Simple Algorithm

```java
/**
 * 算法设计思路:
 * 1. 维护两个计数器: maxLength 记录全局最长长度, currentLength 记录当前连续递增序列长度
 * 2. 从第二个元素开始遍历数组, 比较当前元素与前一个元素的大小关系
 * 3. 如果当前元素大于前一个元素, 说明连续递增序列继续, 当前长度加1
 * 4. 如果当前元素小于等于前一个元素, 说明连续递增序列中断, 重新开始计数, 当前长度重置为1
 * 5. 每次更新当前长度时, 同步更新全局最大长度, 取两者中的较大值
 */
```

### 2.2 Algorithm with Key Technical Points

```java
/**
 * 算法设计思路:
 * 1. 使用哈希表存储数组元素及其对应的索引, 实现O(1)时间复杂度的查找
 * 2. 遍历数组中的每个元素 nums[i], 计算与目标值的差值 complement = target - nums[i]
 * 3. 检查哈希表中是否存在 complement:
 *    - 若存在, 则找到解, 返回 complement 对应的索引和当前索引 i
 *    - 若不存在, 则将当前元素 nums[i] 及其索引 i 存入哈希表
 * 4. 遍历完成后, 若未找到解则返回空数组
 *
 * 关键技术点:
 * - 哈希表的使用: 空间换时间, 将查找复杂度从O(n)降低到O(1)
 * - 单次遍历: 边遍历边存储, 避免重复计算
 */
```

### 2.3 Multi-Method Algorithm

```java
/**
 * 算法设计思路:
 *
 * 递归实现:
 * 1. 中序遍历的顺序是左子树 -> 根节点 -> 右子树
 * 2. 使用递归实现, 先递归遍历左子树
 * 3. 访问根节点, 将节点值加入结果列表
 * 4. 最后递归遍历右子树
 * 5. 递归终止条件是当前节点为null
 *
 * 迭代实现:
 * 1. 利用栈来模拟递归过程
 * 2. 初始化当前节点指针为根节点
 * 3. 当栈不为空或当前节点不为null时, 循环执行以下操作:
 *    a. 遍历左子树, 将所有左节点入栈, 直到当前节点为null
 *    b. 弹出栈顶节点, 访问该节点, 将其值加入结果列表
 *    c. 将当前节点指针指向右子节点
 */
```

## 3. Algorithm Complexity Analysis Examples

### 3.1 Linear Time, Constant Space

```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n), 其中 n 是数组的长度.
 *   因为只需要遍历数组一次, 每个元素只访问一次, 所以总操作次数是线性的.
 * - 空间复杂度: O(1), 只使用了常量级的额外空间(两个整型变量).
 *   算法是原地计算, 没有使用额外的数组或数据结构.
 */
```

### 3.2 Linear Time, Linear Space

```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n), 其中 n 是数组的长度.
 * 因为只需要遍历数组一次, 每个元素的哈希表操作(put和containsKey)都是O(1)时间复杂度
 * - 空间复杂度: O(n).
 * 最坏情况下, 需要将数组中的所有元素存入哈希表, 因此空间复杂度为O(n)
 */
```

### 3.3 Log-Linear Time, Log Space

```java
/**
 * 算法复杂度分析:
 * - 时间复杂度: O(n log n), 其中 n 是数组长度.
 * 平均情况下, 每轮分区将数组分成两个大小相近的子数组, 递归深度为 log n, 每轮分区时间为 O(n)
 * 最坏情况下, 分区不平衡, 时间复杂度为 O(n^2)
 * - 空间复杂度: O(log n).
 * 递归调用栈的深度, 平均情况下为 log n, 最坏情况下为 O(n)
 */
```

### 3.4 Multi-Method Algorithm

```java
/**
 * 算法复杂度分析:
 *
 * 递归实现:
 * - 时间复杂度: O(n), 其中 n 是二叉树的节点数量.
 * 每个节点恰好被访问一次, 因此总时间复杂度是线性的.
 * - 空间复杂度: O(n).
 * 最坏情况下, 当二叉树是一条链时, 递归调用栈的深度会达到n, 因此空间复杂度是O(n).
 *
 * 迭代实现:
 * - 时间复杂度: O(n), 其中 n 是二叉树的节点数量.
 * 每个节点恰好被访问一次, 因此总时间复杂度是线性的.
 * - 空间复杂度: O(n).
 * 最坏情况下, 当二叉树是一条链时, 栈的深度会达到n, 因此空间复杂度是O(n).
 */
```

## 4. Method-Level Comment Examples

### 4.1 Simple Method

```java
/**
 * 查找数组中最长连续递增子序列的长度
 *
 * 连续递增子序列是指数组中连续位置的元素严格递增的子序列.
 * 例如: 数组 [1,3,5,4,7] 中, [1,3,5] 和 [4,7] 都是连续递增子序列, 最长长度为3.
 *
 * @param nums 输入的整数数组, 可以包含负数, 零和正数, 无需排序
 * @return 最长连续递增子序列的长度; 如果数组为空或null, 返回0
 */
public int solution(int[] nums) {
    // Implementation
}
```

### 4.2 Method with Constraints

```java
/**
 * 计算爬楼梯的不同方法数
 *
 * @param n 楼梯的阶数, 范围为1 <= n <= 45
 * @return 到达第n阶的不同方法数
 */
public int solution(int n) {
    // Implementation
}
```

### 4.3 Method with Detailed Explanation

```java
/**
 * 在整数数组中查找两个数, 使其和等于目标值, 并返回这两个数的索引
 *
 * @param nums   整数数组, 长度范围为2 <= nums.length <= 10^4, 元素范围为-10^9 <= nums[i] <= 10^9
 * @param target 目标值, 范围为-10^9 <= target <= 10^9
 * @return 包含两个数的索引的数组, 索引范围为0 <= index1, index2 < nums.length, 且index1 < index2
 */
public int[] twoSum(int[] nums, int target) {
    // Implementation
}
```

### 4.4 Helper Method

```java
/**
 * 递归辅助函数, 用于实现中序遍历
 *
 * @param node   当前遍历的节点
 * @param result 存储遍历结果的列表
 */
private void inorderTraversal(TreeNode node, List<Integer> result) {
    // Implementation
}
```

## 5. Implementation Step Comment Examples

### 5.1 Variable Initialization with Context

```java
// 边界条件处理: 空数组或null直接返回0
if (nums == null || nums.length == 0) {
    return 0;
}

// 全局最大长度: 记录遍历过程中找到的最长连续递增子序列长度
// 初始值为1, 因为非空数组至少有一个元素, 最小长度为1
int maxLength = 1;

// 当前连续递增序列长度: 记录当前正在遍历的连续递增序列的长度
// 初始值为1, 表示从数组的第一个元素开始计数
int currentLength = 1;
```

### 5.2 Algorithm Logic Explanation

```java
// 从数组的第二个元素开始遍历(索引为1), 与前一元素比较
for (int i = 1; i < nums.length; i++) {
    // 判断当前元素是否大于前一个元素
    if (nums[i] > nums[i - 1]) {
        // 当前元素大于前一元素, 连续递增序列继续
        // 当前递增序列长度加1
        currentLength++;

        // 更新全局最大长度
        // 比较当前连续递增序列长度和历史最大长度, 取较大值作为新的全局最大长度
        maxLength = Math.max(maxLength, currentLength);
    } else {
        // 当前元素小于等于前一元素, 连续递增序列中断
        // 从当前元素重新开始计数, 当前长度重置为1
        currentLength = 1;
    }
}
```

### 5.3 Loop Invariant

```java
// 当前阶的方法数 = 到达第i-1阶的方法数 + 到达第i-2阶的方法数
current = prevPrev + prev;
// 更新状态: 前前一阶变为前一阶, 前一阶变为当前阶
prevPrev = prev;
prev = current;
```

### 5.4 Data Structure Operations

```java
// 遍历数组中的每个元素
for (int i = 0; i < nums.length; i++) {
    // 计算当前元素与目标值的差值
    int complement = target - nums[i];

    // 检查差值是否已经存在于HashMap中
    if (map.containsKey(complement)) {
        // 若存在, 则返回差值对应的索引和当前索引
        return new int[] { map.get(complement), i };
    }

    // 若不存在, 则将当前元素和其索引添加到HashMap中
    map.put(nums[i], i);
}
```

### 5.5 Boundary Condition Handling

```java
// 边界条件: 数组为空或为null, 先手玩家无法获胜
if (nums == null || nums.length == 0) {
    return false;
}
```

## 6. Complete Algorithm Class Examples

### 6.1 Standard Algorithm Template

```java
package com.flyingcode.problem;

/**
 * 最长连续递增子序列长度
 * 该类提供一个高效的算法, 用于查找未排序数组中最长的连续递增子序列的长度.
 * 算法采用单次遍历技术, 实现了线性时间复杂度, 空间复杂度为 O(1).
 */
public class Algo025MaxIncSubseq {

    /**
     * 算法设计思路:
     * 1. 维护两个计数器: maxLength 记录全局最长长度, currentLength 记录当前连续递增序列长度
     * 2. 从第二个元素开始遍历数组, 比较当前元素与前一个元素的大小关系
     * 3. 如果当前元素大于前一个元素, 说明连续递增序列继续, 当前长度加1
     * 4. 如果当前元素小于等于前一个元素, 说明连续递增序列中断, 重新开始计数, 当前长度重置为1
     * 5. 每次更新当前长度时, 同步更新全局最大长度, 取两者中的较大值
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O(n), 其中 n 是数组的长度.
     *   因为只需要遍历数组一次, 每个元素只访问一次, 所以总操作次数是线性的.
     * - 空间复杂度: O(1), 只使用了常量级的额外空间(两个整型变量).
     *   算法是原地计算, 没有使用额外的数组或数据结构.
     */

    /**
     * 查找数组中最长连续递增子序列的长度
     *
     * 连续递增子序列是指数组中连续位置的元素严格递增的子序列.
     * 例如: 数组 [1,3,5,4,7] 中, [1,3,5] 和 [4,7] 都是连续递增子序列, 最长长度为3.
     *
     * @param nums 输入的整数数组, 可以包含负数, 零和正数, 无需排序
     * @return 最长连续递增子序列的长度; 如果数组为空或null, 返回0
     */
    public int solution(int[] nums) {
        // 边界条件处理: 空数组或null直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 全局最大长度: 记录遍历过程中找到的最长连续递增子序列长度
        int maxLength = 1;

        // 当前连续递增序列长度: 记录当前正在遍历的连续递增序列的长度
        int currentLength = 1;

        // 从数组的第二个元素开始遍历(索引为1), 与前一元素比较
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 当前元素大于前一元素, 连续递增序列继续
                currentLength++;
                // 更新全局最大长度
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // 当前元素小于等于前一元素, 连续递增序列中断
                currentLength = 1;
            }
        }

        return maxLength;
    }
}
```

### 6.2 Hash Table Algorithm Example

```java
package com.flyingcode.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 该类提供一个高效的算法, 用于在整数数组中查找两个数, 使其和等于目标值.
 * 算法采用哈希表技术, 实现了线性时间复杂度, 空间复杂度为 O(n).
 */
public class Leet0001TwoSum {

    /**
     * 算法设计思路:
     * 1. 使用哈希表存储数组元素及其对应的索引, 实现O(1)时间复杂度的查找
     * 2. 遍历数组中的每个元素 nums[i], 计算与目标值的差值 complement = target - nums[i]
     * 3. 检查哈希表中是否存在 complement:
     *    - 若存在, 则找到解, 返回 complement 对应的索引和当前索引 i
     *    - 若不存在, 则将当前元素 nums[i] 及其索引 i 存入哈希表
     * 4. 遍历完成后, 若未找到解则返回空数组
     *
     * 关键技术点:
     * - 哈希表的使用: 空间换时间, 将查找复杂度从O(n)降低到O(1)
     * - 单次遍历: 边遍历边存储, 避免重复计算
     */

    /**
     * 算法复杂度分析:
     * - 时间复杂度: O(n), 其中 n 是数组的长度.
     * 因为只需要遍历数组一次, 每个元素的哈希表操作(put和containsKey)都是O(1)时间复杂度
     * - 空间复杂度: O(n).
     * 最坏情况下, 需要将数组中的所有元素存入哈希表, 因此空间复杂度为O(n)
     */

    /**
     * 在整数数组中查找两个数, 使其和等于目标值, 并返回这两个数的索引
     *
     * @param nums   整数数组, 长度范围为2 <= nums.length <= 10^4, 元素范围为-10^9 <= nums[i] <= 10^9
     * @param target 目标值, 范围为-10^9 <= target <= 10^9
     * @return 包含两个数的索引的数组, 索引范围为0 <= index1, index2 < nums.length, 且index1 < index2
     */
    public int[] twoSum(int[] nums, int target) {
        // 使用哈希表存储元素值到索引的映射
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素与目标值的差值
            int complement = target - nums[i];

            // 检查差值是否已经存在于HashMap中
            if (map.containsKey(complement)) {
                // 若存在, 则返回差值对应的索引和当前索引
                return new int[] { map.get(complement), i };
            }

            // 若不存在, 则将当前元素和其索引添加到HashMap中
            map.put(nums[i], i);
        }

        // 未找到解, 返回空数组
        return new int[] {};
    }
}
```

## 7. Data Structure Class Example

```java
package com.flyingcode.structure;

/**
 * 二叉树节点
 * 该类提供一个二叉树节点数据结构, 用于构建二叉树.
 *
 * 字段说明:
 * - val: 节点存储的值
 * - left: 左子节点指针
 * - right: 右子节点指针
 *
 * 使用场景:
 * - 二叉树算法的节点表示
 * - 二叉搜索树, 平衡树等树形结构的实现
 */
public class TreeNode {
    // 节点值
    public int val;

    // 左子节点
    public TreeNode left;

    // 右子节点
    public TreeNode right;

    /**
     * 构造函数
     *
     * @param val 节点的初始值
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 完整构造函数
     *
     * @param val   节点的初始值
     * @param left  左子节点
     * @param right 右子节点
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

## 8. Reference Examples Location

完整注释示例在项目中的位置:

**Simple Algorithm**:
- `src/main/java/com/flyingcode/problem/Algo025MaxIncSubseq.java`

**Hash Table Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0001TwoSum.java`

**Dynamic Programming Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0070ClimbStairs.java`
- `src/main/java/com/flyingcode/problem/Algo032PredictWinnerDP.java`

**Multi-Method Algorithm**:
- `src/main/java/com/flyingcode/leetcode/Leet0094BinaryTreeInorderTraversal.java`

**Sorting Algorithm**:
- `src/main/java/com/flyingcode/sort/QuickSort.java`

**Data Structure**:
- `src/main/java/com/flyingcode/structure/ListNode.java`
- `src/main/java/com/flyingcode/structure/TreeNode.java`
