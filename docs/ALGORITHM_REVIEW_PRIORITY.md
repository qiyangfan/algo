# 算法考试复习优先级清单

> 分析时间：2026-03-10
> 高价值题目 = 经典算法、母题、强迁移性

---

## 一、必看 (10题) ⭐⭐⭐⭐⭐

| 题号 | 题目 | 算法思想 | 为什么必看 |
|------|--------|----------|------------|
| Leet0001 | Two Sum | 哈希表 | 空间换时间思想，所有Hash、Two Pointer题目的基础 |
| Algo012 | Two Sum | 哈希表 | 理解哈希表解法原理 |
| Algo005 | Sqrt X | 二分查找 | 经典二分思想，有序区间搜索基础 |
| Leet0704 | Binary Search | 二分查找 | 标准二分查找实现 |
| sort/QuickSort | Quick Sort | 分治策略 | O(n log n)平均时间，面试必考 |
| sort/MergeSort | Merge Sort | 分治+归并 | 稳定排序，O(n log n) |
| sort/HeapSort | Heap Sort | 优先队列 | O(n log n)，原地排序 |
| Leet0070 | Climb Stairs | DP递推 | F(n)=F(n-1)+F(n-2)，DP入门必看 |
| Algo036 | House Robber DP | DP状态转移 | rob(n)=max(rob(n-1),rob(n-2)+nums[n-1]) |
| Algo038 | House Robber Tree DP | DP+树后序 | 树形DP，后序遍历+两种状态 |

---

## 二、熬夜也要看 (18题) ⭐⭐⭐⭐⭐

| 题号 | 题目 | 算法思想 | 为什么熬夜要看 |
|------|--------|----------|---------------|
| Algo007 | Reverse Linked List | 反转链表(迭代) | 三个指针(prev,curr,next)，链表基础操作 |
| Leet0206 | Reverse Linked List | 反转链表 | 同上，LeetCode标准实现 |
| Leet0021 | Merge Two Sorted Lists | 合并有序链表 | 递归合并，链表合并必考 |
| Algo020 | Detect Cycle | 快慢指针检测环 | Floyd判圈算法，O(n)时间O(1)空间 |
| Leet0141 | Linked List Cycle I | 环检测I | 快慢指针，检测环是否存在 |
| Leet0142 | Linked List Cycle II | 环检测II | 快慢指针+数学推导，找环入口 |
| Leet0876 | Middle of Linked List | 快慢指针找中点 | 快2慢1，找中点技巧 |
| Leet0160 | Intersection of Two Linked Lists | 双指针找交点 | 同步遍历两链表找交点 |
| Leet0101 | Symmetric Tree | 对称树 | 递归比较左右子树镜像 |
| Leet0104 | Maximum Depth of Binary Tree | 最大深度 | 递归: max(左深,右深)+1 |
| Leet0094 | Inorder Traversal | 中序遍历 | 左-根-右，递归和迭代两种实现 |
| Leet0144 | Preorder Traversal | 前序遍历 | 根-左-右，必考遍历顺序 |
| Leet0145 | Postorder Traversal | 后序遍历 | 左-右-根，递归和迭代实现 |
| Algo028 | Province Count DFS | DFS连通分量 | 邻接矩阵DFS，递归访问未访问节点 |
| Algo029 | Province Count BFS | BFS连通分量 | 邻接矩阵BFS，队列遍历 |
| Algo030 | Province Count UF | 并查集 | Union-Find+路径压缩+按秩合并，连通性问题经典 |
| Algo035 | KMP | KMP算法 | 部分匹配表，O(n+m)字符串匹配经典算法 |
| Algo003 | Remove Duplicates | 双指针 | 有序数组去重，快慢指针经典应用 |
| Algo013 | Two Sum Sorted | 双指针 | 有序数组中两数之和，双指针技巧 |

---

## 三、有时间必看 (20题) ⭐⭐⭐

| 题号 | 题目 | 算法思想 | 备注 |
|------|--------|----------|------|
| SwordOffer0010 | Fibonacci | DP滚动数组 | 斐波那契数列，DP经典应用，最优解法 |
| Algo037 | House Robber Cycle DP | DP+问题分解 | 首尾相连需分解为两个DP问题 |
| Algo032 | Predict Winner DP | DP+博弈论 | dp[i][j]分数差，博弈论基础 |
| Leet083 | Delete Duplicates from Sorted List | 删除重复元素 | 单次遍历，链表去重 |
| Leet0234 | Palindrome Linked List | 回文链表 | 快慢找中点+反转后半部分+比较 |
| Algo023 | Min Depth DFS | 最小深度DFS | 递归，注意单侧子树情况 |
| Algo024 | Min Depth BFS | 最小深度BFS | BFS找到第一个叶子节点即最小深度 |
| Leet0110 | Balanced Binary Tree | 平衡二叉树 | \|h左-h右\|<=1，递归或后序遍历 |
| Algo002 | Prime Count Sieve | 埃拉托斯特尼筛 | O(n log log n)素数筛选，经典数论算法 |
| Algo026 | Lemonade Change | 贪心 | 优先使用大面额找零，典型贪心场景 |
| Algo027 | Max Perimeter Triangle | 排序+贪心 | 排序后逆向遍历，a+b>c判断 |
| Algo039 | Dota2 Senate Greedy | 双队列贪心 | 模拟投票过程，索引+轮次技巧 |
| Algo040 | Advantage Shuffle Greedy | 田忌赛马策略 | 排序后双指针，最小赢+最弱输 |
| Algo010 | Max Product Three | 排序后比较 | max(三最大正, 最大正*两最小负)，考虑负数情况 |
| Algo025 | Max Inc Subseq | 线性扫描 | 单次遍历，连续递增序列长度统计 |
| Algo004 | Find Pivot Index | 前缀和 | leftSum == rightSum - leftSum - nums[i]，前缀和技巧 |
| Algo006 | Sqrt X Newton | 牛顿迭代法 | x = (x + n/x) / 2，数值优化技巧 |
| Algo018 | Arrange Coins BS | 二分查找 | 使用等差数列公式+二分，O(log n)最优解 |
| Algo031 | Predict Winner Recur | 递归+极小化极大 | O(2^n)理解递归思想，对比DP优化 |
| Algo022 | Max Average Subarray | 滑动窗口 | 固定窗口处理，滑动窗口技巧基础 |

---

## 四、高价值母题 (11题) ⭐⭐⭐

| 题号 | 题目 | 算法思想 | 为什么高价值 |
|------|--------|----------|-------------|
| Algo012 | Two Sum | 哈希表 | 同上，理解哈希表解法原理 |
| sort/BubbleSort | Bubble Sort | 冒泡排序 | O(n^2)，仅作理解 |
| sort/SelectionSort | Selection Sort | 选择排序 | O(n^2)，仅作理解 |
| sort/ShellSort | Shell Sort | 希尔排序 | 插入排序改进版，有一定参考价值 |
| search/SequentialSearch | Sequential Search | 顺序搜索 | O(n)，基础对比 |
| search/FibonacciSearch | Fibonacci Search | 斐波那契查找 | O(log n)近似黄金分割 |
| sort/CountingSort | Counting Sort | 计数排序 | O(n+k)，特定场景 |
| sort/RadixSort | Radix Sort | 基数排序 | O(n*k)，线性排序，特殊场景 |
| search/BlockSearch | Block Search | 分块搜索 | 索引表+分块，特定场景 |
| search/TreeTableSearch | Tree Table Search | 树表搜索 | B树思想，具体场景 |
| Algo033 | Champagne Tower | 模拟 | 逐层计算香槟溢出分配，具体场景，除考试出原题外无意义 |

---

**总计：59题高价值题**
