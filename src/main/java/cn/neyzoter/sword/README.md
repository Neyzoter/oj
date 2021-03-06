# Sword Finger
## 面试题3.找出数组中重复的数字 （RepeatNumberInArray）
### 3.1 问题
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：

[2, 3, 1, 0, 2, 5, 3]

输出：2 或 3 
 

限制：

`2 <= n <= 100000`
### 3.2 思路

* **方案1.使用HashSet**

    遍历一边就可以知道一个重复数字
    
    时间复杂度：O(n)
    
    空间复杂度：O(n)
    
* **方案2.使用数组保存重复次数**

    由于数组初始化为0，而数字遍历到的次数保存在数组中，第一次遍历到时，发现是0，则该元素加1，第二次遍历到时，就发现是1，就可以判断为重复数字。
    
    数组的遍历速度是O(1)
    
    时间复杂度：O(n)，但是实际上，会比Set快很多
    
    空间复杂度：O(n)

## 面试题04 二维数组中的查找
### 1. 问题
在一个 `n * m` 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = 5，返回 true。

给定 target = 20，返回 false。

限制：

```
0 <= n <= 1000
0 <= m <= 1000
```

注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

### 解题思路

* **暴力法**

```java
class Solution1_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length ; i ++) {
            for (int j = 0 ; j < matrix[0].length ; j ++) {
                if (matrix[i][j] == target) {
                    // 找到target
                    return true;
                } else if (matrix[i][j] > target) {
                    // 这一行结束
                    break;
                }
            }
        }
        return false;
    }
}
```

* **对角取点区域搜索法**

比如取右上角数字，如果大于target，则所在列可以不考虑，如果小于target所在行可以不考虑

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1 ; (i < matrix.length) && (j >= 0);) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i ++;
            } else if (matrix[i][j] > target){
                j --;
            }
        }
        return false;
    }
}
```

## 面试题05 替换空格
### 1. 问题
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

限制：

```
0 <= s 的长度 <= 10000
```

### 2. 思路

```java
class Solution {
    public static final char SPACE = ' ';
    public String replaceSpace(String s) {
        char[] ch = new char[s.length() * 3];
        int j = 0;
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if (c == SPACE) {
                ch[j] = '%';j++;
                ch[j] = '2';j++;
                ch[j] = '0';j++;
            } else {
                ch[j] = c;j++;
            }
        }
        return String.copyValueOf(ch, 0, j);
    }
}
```

## 面试题06. 从尾到头打印链表
### 6.1 问题
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

```
输入：head = [1,3,2]
输出：[2,3,1]
```

限制：

`0 <= 链表长度 <= 10000`
### 6.2 思路
将链表从头到尾依次拷贝到数组。

## 面试题07. 重建二叉树（Build Tree）
### 7.1 问题
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 `preorder = [3,9,20,15,7]`

中序遍历 `inorder = [9,3,15,20,7]`

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

限制：

`0 <= 节点个数 <= 5000`

### 7.2 思路
* **递归法**

    递归函数实现对前序和后序数组的分割操作，也就是分割出根节点、左子树和右子树。

## 面试题14- I. 剪绳子  cuttingRope
### 14.1 问题
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 `k[0],k[1]...k[m]` 。请问 `k[0]*k[1]*...*k[m]` 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

```
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
```

示例 2:

```
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```

提示：

`2 <= n <= 58`

## 面试题09. 用两个栈实现队列
### 9.1 问题
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )


示例 1：

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

示例 2：

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

提示：

`1 <= values <= 10000`

最多会对 appendTail、deleteHead 进行 10000 次调用

### 9.2 思路
一个stack按照加入顺序保存数据，当要删除尾部时，直接pop

一个stack用于删除头部时，从第一个stack拷贝出数据，即可实现将第一个stack的数据反过来存储，进而可以pop删除头部
### 14.2 思路
#### 14.2.1 动态规划
**注意：不可以不裁剪，在动态规划时，需要考虑该问题。**

**动态规划时，最后一个前的dp可以不裁剪（比如2不裁剪为2,3不裁剪是3），最后一个必须是裁剪的**

* **情况1**

`dp[1] = 1`

`dp[2] = 1  (1 * 1)`

* **情况2**

`dp[1] = 1`

`dp[2] = 2  (2，不裁剪)`

`dp[3] = 3  (3，不裁剪)`

`dp[4] = 4  (2*2, 4均可)`

`dp[5] = 6  (2*3均可)`

## 面试题16. 数值的整数次方 MyPow
### 16.1 问题
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

示例 1:

```
输入: 2.00000, 10
输出: 1024.00000
```

示例 2:

```
输入: 2.10000, 3
输出: 9.26100
```

示例 3:

```
输入: 2.00000, -2
输出: 0.25000
解释: 2^-2 = 1/2^2 = 1/4 = 0.25
```

说明:

`-100.0 < x < 100.0`

n 是 32 位有符号整数，其数值范围是 `[−2^31, 2^31 − 1]` 。

### 16.2 思路

* **for循环**

```java
public double myPow(double x, int n) {
    double val = 1;
    // 注意int取正可能超过int的最大值
    long absN = (long) n;
    absN = absN < 0 ? -absN : absN;

    if (x == 1) {
        return 1;
    } else if (x == -1 ) {
        return absN % 2 == 0 ? 1 : -1;
    }
    x = n < 0 ? 1 / x : x;
    for (int i = 0 ; i < absN ; i ++) {
        val *= x;
    }
    return val;
}
```

时间复杂度: O(n)

* **利用二进制幂**

<img src="./img/binary_pow.png" width="400" alt="二进制幂">

```java
public double myPow(double x, int n) {
    double val = 1;
    x = n < 0 ? 1 / x : x;
    // 注意int取正可能超过int的最大值
    long absN = (long) n;
    absN = absN < 0 ? -absN : absN;
    while (absN > 0) {
        if ((absN & 1) == 1) {
            val *= x;
        }
        x *= x;
        absN >>= 1;
    }
    return val;
}
```

时间复杂度: O(logn)

## 面试题43. 1-n整数中1出现的次数
### 43.1 问题
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

示例 1：

```
输入：n = 12
输出：5
```

示例 2：

```
输入：n = 13
输出：6
```

限制：

`1 <= n < 2^31`

**与LeetCode的233题相同**

### 43.2 思路

* 分情况讨论

只针对每个位进行讨论，然后合并。left表示左侧的数字，mid表示自身，right表示右侧的数字。

```java
if (mid > 1) {
    oneNum += (left + 1) * pow;
} else if (mid == 1) {
    oneNum += left * pow + (right + 1);
} else {
    oneNum += left * pow;
}
```

## 面试题44. 数字序列中某一位的数字
### 44.1 问题
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

示例 1：

```
输入：n = 3
输出：3
```

示例 2：

```
输入：n = 11
输出：0
```

限制：

```
0 <= n < 2^31
```

注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/

### 44.2 思路
1. 首先找到属于几位数（比如为N）

2. 将前面的个数都减掉，剩下X

3. X/N = A ... B

4. 根据A和N得到所在的数，根据B得到这个数的第几位

参考：

```java
public static final int ONE_DIGIT = 10;
public int findNthDigit(int n) {
    if (n < ONE_DIGIT) {
        return n;
    }
    long num = 1;
    int nAt = 1;
    for (int i = 1;  ; i ++) {
        long nextNum = num + 9 * (long) Math.pow(10, i - 1) * i;
        if (nextNum > n) {
            nAt = i;
            break;
        } else {
            num = nextNum;
        }
    }
    int left = n - (int) num;
    // 商数
    int quotient = left / nAt;
    // 余数
    int remainder = left % nAt;
    // 找到nAt位的数字的最小值
    int base = (int) Math.pow(10, nAt - 1);
    // 找到字符所在数字
    int basePlus = base + quotient;
    // 找到字符，并转化为数字
    int ch = String.valueOf(basePlus).charAt(remainder) - '0';
    return ch;
}
```

## 面试题49. 丑数 NthUglyNumber
### 49.1 问题
我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

示例:

```
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

说明:  

1. 1 是丑数。

2. n 不超过1690。

本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/

### 49.2 思路

* **动态规划1**

从1开始遍历，此数整除2或3或5得到的结果要是丑数。

* **动态规划2**

创建一个dp，然后2、3和5各自维护一个下标，每次用该下标对应的丑数来乘对应的2、3或者5,并采纳其中的min作为新的丑数。

而后判断是否和2、3和5的计算出来的结果相同，是则下表加1。

```java
public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int idx2 = 0 , idx3 = 0, idx5 = 0;
    for (int i = 1 ; i < n ; i ++) {
        int ugly2 = dp[idx2] * 2;
        int ugly3 = dp[idx3] * 3;
        int ugly5 = dp[idx5] * 5;
        int uglyNum = Math.min(Math.min(ugly2,ugly3), ugly5);
        dp[i] = uglyNum;
        // 此处不使用if else，因为有可能ugly数字相同
        if (uglyNum == ugly2) {
            idx2 ++;
        }
        if (uglyNum == ugly3) {
            idx3 ++;
        }
        if (uglyNum == ugly5) {
            idx5 ++;
        }
    }
    return dp[n - 1];
}
```

## 面试题52. 两个链表的第一个公共节点
输入两个链表，找出它们的第一个公共节点。

### 52.1 问题
https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

### 52.2 思路

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode node1, node2;
    int flag = 0;
    if (headA == null || headB == null) {
        return null;
    }
    for (node1 = headA, node2 = headB; node1 != node2 && flag <= 1;) {
        if (node1.next == null) {
            node1 = headB;
            flag ++;
        } else {
            node1 = node1.next;
        }
        if (node2.next == null) {
            node2 = headA;
        } else {
            node2 = node2.next;
        }
    }
    if (flag > 1) {
        return null;
    } else {
        return node1;
    }
}
```