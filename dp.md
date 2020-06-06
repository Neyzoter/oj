# 动态规划
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