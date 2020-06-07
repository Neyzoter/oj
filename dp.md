# 动态规划

## 解题思路
问题需要满足原则：最优子结构

使用过程中需要确定：

（0）目标

求背包中最大价值

（1）状态

比如0-1背包问题，状态是“背包容量”和“可选择的物品”。

```java
// 状态
for (int i = 1; i < GOODS_NUM; i ++) {
    for (int j = 1; j < BAG_CAP; j ++) {
        // 做选择
    }
}
```

（2）选择

```java
// 状态
for (int i = 1; i < GOODS_NUM; i ++) {
    for (int j = 1; j < BAG_CAP; j ++) {
        // 做选择
        dp[i][j] = max 价值 (物品i放进背包, 物品i不放进背包)
    }
}
```

## 典型问题

**子序列问题**

模板

```python

int	n = arr.length;
int[][] dp = new dp[n][n];
for	(int i = 0; i < n; i++) {
    for	(int j = 0; j < n; j++) {
    if	(arr[i] == arr[j])	
        dp[i][j] = dp[i][j]	+ ...
    else
        dp[i][j] = 最值(...)
    }
}
```

（1）涉及到两个字符串

LeetCode 1143 最长公共子序列

（2）涉及一个字符串

LeetCode 516 最⻓回文子序列



**最值问题**

0-1背包问题