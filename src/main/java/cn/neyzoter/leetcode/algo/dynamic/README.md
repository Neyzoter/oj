# 5.最长回文子串问题（LongestPalindromicSubstring）
## 1.问题
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

*回文串*是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。

示例 1：

```
输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
```

示例 2：

```
输入: "cbbd"
输出: "bb"
```

## 2.思路
### 2.1 中心扩散法
分成两种情况，一种是奇数个，一种是偶数个。

*奇数个*

1、确定中间的数

2、向两边遍历

*偶数个*

1、确定中间两个数

2、向两边遍历

*时间复杂度*:O(n^2)

*空间复杂度*:O(1)

### 2.2 动态规划法
1、先找长度1和2的回文子串，并存储在矩阵中

也就是先给(0,0)(1,1)(2,2)...(0,1)(1,2)(2,3)...赋值，false或者true。分别表示字符串下标i到j之间的部分是不是回文子串。

2、遍历长度3的回文子串，长度4的回文子串，以此类推

```
for(长度){
    for(下标遍历){
    	判断[本次下标,本次下标+长度]
    }
}
```

## 3.感悟
### 3.1 最长公共子串
给定两个字符串，求出它们之间最长的相同子字符串的长度。

**解决方法**

* 暴力法

以字符串中的每个字符作为子串的端点，判定以此为开始的子串的相同字符最长能达到的长度。。其实从表层上想，这个算法的复杂度应该只有O(n2)因为该算法把每个字符都成对相互比较一遍，但关键问题在于比较两个字符串的效率并非是O(1)，这也导致了实际的时间复杂度应该是满足Ω(n^2)和O(n^3)。

* 动态规划

在比较以i和j分别为起始点字符串时，有可能会进行i+1和j+1以及i+2和j+2位置的字符的比较；而在比较i+1和j+1分别为起始点字符串时，这些字符又会被比较一次了。也就是说该问题有非常相似的子问题，而子问题之间又有重叠，这就给动态规划法的应该提供了契机。

# 22.括号生成
## 1.问题
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```
## 2.思路
### 2.1 回溯法
左括号存在才能加右括号，否则是无效的。

利用回溯算法，分两种情况

1. 直接添加左括号（满足小于等于n）

2. 如果左括号多于右括号，才能加右括号。

结束条件为，左括号数目和右括号数目都等于n

时间复杂度：O(4^n / sqrt(n))

空间复杂度：O(4^n / sqrt(n))

### 2.2 动态规划法
首先将问题切割为第n个括号和n-1个括号的结合。第n个括号`()`。对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 `2*c + 1`。然后两者间的 `2*c` 个元素一定是有效序列，其余元素一定是有效序列。可以对所有情况遍历，

`"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】`

上述遍历没有重复情况出现。

时间复杂度：O(4^n / sqrt(n))

空间复杂度：O(4^n / sqrt(n))

# 68 不同路径
中等, 动态规划
## 1.问题
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

说明：m 和 n 的值均不超过 100。

**示例 1**:

输入: m = 3, n = 2

输出: 3

解释:

从左上角开始，总共有 3 条路径可以到达右下角。

```
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
```

**示例 2**:

输入: m = 7, n = 3

输出: 28

## 2.思路
### 2.1 递归法

*此方法会超时*

结束条件为`i==i_end,j==j_end`，每次递归参数为i和j。

定义全局变量max = 0

```java
class Solution1_UniquePath {
    public static int cnt = 0;
    public int uniquePaths(int m, int n) {
        cnt = 0;
        if (m == 1 || n == 1) {
            cnt = 1;
            return cnt;
        }else {
            return pathCounter(m - 1,n - 1);
        }
    }
    private int pathCounter (int m, int n) {
        if (m > 0) {
            pathCounter(m - 1, n);
        }
        if (n > 0) {
            pathCounter(m, n - 1);
        }
        if (m == 0 && n == 0) {
            cnt ++;
        }
        return cnt;
    }
}
```

### 2.2 动态规划法
从最后一个块开始，和最后一个相邻的两个块分别只有一条路径到达最后一块。进而得到这两个块夹着的一个有1+1个路径。以此类推。

```
+------------+
+ X  6  3  1 +
+ 4  3  2  1 +
+ 1  1  1  0 +
+------------+
```

```java
class Solution2_UniquePath {
    public int uniquePaths(int m, int n) {
        if (m==1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        int i = m - 1;int j = n - 1;
        dp[i - 1][j] = 1;dp[i][j - 1] = 1;
        for (i = m - 1;i >= 0; i --) {
            for (j = n - 1;j >= 0; j --) {
                // 最后一行
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
```

时间复杂度：n(n*m)

# 70.爬楼梯
## 1.问题
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

示例 2：

```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

## 2.思路
### 2.1 动态规划
从1个开始，
```
# 1个，1种
|-|
# 2个, 2种
|-|-|
|--|
# 3个，如果最后一步是1,那么情况数目和dp[2]一样，如果是2步，那么情况和dp[3-2步]一样
dp[2] + dp[1] = 3
....
# N个，如果最后一步是1,那么情况数目和dp[N-1]一样，如果是2步，那么情况和dp[N-2]一样
```

伪代码如下

```
dp[N+1]
dp[1] = 1
dp[2] = 2
For i =3 : N
    dp[i] = dp[i - 1] + dp[i - 2]
End

```

# 96.不同的二叉搜索树
## 1.问题
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3

输出: 5

解释:

给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

```
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

## 2.思路
### 2.1 动态规划
n个数据，可以分为n种情况，比如3个，那么第1，2，3三个数字分别作为根节点。分别为，右边2个，左右各1个，左边2个，分解为了n等于1和2的问题。所以可通过计算1个，再计算2个，以此类推。

```
dp长度N + 1, 初始化为0
dp[0] = 1  // 一侧为0时，认为是1
For n = 1:N   // n现在有n个数
  For i = 1:n   // i表示选择n个数中的第i个作为根节点
    left = i - 1   // 左侧i - 1个数字
    right = n - i   // 右侧n- j个数字
    dp[n-1] += dp[left-1] * dp[right -1]  // 左右相乘得到这种根节点选择法的情况种类
  End
End
```

# 139 单词拆分（Word Break）
## 1.问题
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。

你可以假设字典中没有重复的单词。

**示例 1**：

输入: `s = "leetcode", wordDict = ["leet", "code"]`

输出: true

解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

**示例 2**：

输入: `s = "applepenapple", wordDict = ["apple", "pen"]`

输出: true

解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

**示例 3**：

输入:` s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]`

输出: false

## 2.思路
### 2.1 暴力法
首先，单词字典保存到集合。

然后，使用动态规划（递归实现）：

```
wordExist(String s,Hashset<String> dict)

if s.len == 0
    return true
End

For i = 0 : s.len
    String s1 = s.substr(i)[0];
    String s2 = s.substr(i)[1];
    If dict.contains(s1) && wordExist(s2,dict) 
        return true
    End
End

return false
```

时间复杂度：n(n^n)

空间复杂度：n(n^2)

但是`"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]`需要非常长的时间

### 2.2 记忆化回溯

基于暴力法，把每次true或者false用Hashmap memo记录下来。

```
wordExist(String s,Hashset<String> dict)
If s.len == 0
    return true
End
For i = 0 : s.len
    String s1 = s.substr(i)[0];
    String s2 = s.substr(i)[1];
    If dict.contains(s1) && wordExist(s2,dict) 
        memo.put(s, true);
        return true
    End
End
memo.put(s, false)
return false
```

时间复杂度：n(n^2)

空间复杂度：n(n^2)

### 2.3 动态规划
对于给定的字符串可以拆分成2个子字符串的子问题。如果这2个子问题都可以拆分成符合要求的子字符串，则整个字符串符合要求。

```
dp[0] = true
dp[1:-1] = false
For i = 0 : s.len
    For j = 0 : i
        If dp[j] == true && dict.exist(s[j:i])
            dp [i] = true
        End
    End
End 

return dp[-1]
```