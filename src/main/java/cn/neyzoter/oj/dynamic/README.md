# 最长回文子串问题（LongestPalindromicSubstring）
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
结束条件为`i==i_end,j==j_end`，每次递归参数为i和j。

定义全局变量max = 0

```
If i == i_end && j == j_end
    max++
    return
End
thisFunc(i+1,j)
thisFunc(i，j+1)
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