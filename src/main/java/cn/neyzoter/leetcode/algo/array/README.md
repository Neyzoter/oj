# 两数相加问题（AddTwoNumbers）
## 1.问题
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)

输出：7 -> 0 -> 8

原因：342 + 465 = 807

## 2.思路
1、创建缓存ListNode单链表的temp1,temp2和sum_temp

分别用于指向输入单链表1的某个节点，输入单链表2的某个节点，相加的结果的单链表的某个节点

2、一次从单链表的第一个开始遍历（第一个节点即个位，第二个节点即十位...）

两个单链表的数值和进c位相加后%10提取保留的数，/10提取进位c。

注意：在遍历到都是null时，进位有可能还有数值，需要另外判断。

## 3.感悟

进位问题：需要考虑没有相加的数，但是还是有进位的情况。

# 盛最多水的容器问题（ContainerWithMostWater）
(下标1-下标2)*(高度)
## 1.思路
### 1.1 暴力法
1、两个for循环

获取最大的面积

*时间复杂度*:O(n^2)

*空间复杂度*:O(1)

### 1.2 指针法
由于限制面积的总是高度低的，所以需要将高度低的指针向内侧移动。

为了使面积最大化，我们需要考虑更长的两条线段之间的区域。如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。

另外的理解：移动高度高的，没有必要了。不过就算没有遍历，也不会有遗漏的地方。

# 无重复字符的最长子串问题（LongestSubstringWithoutRepeatingCharacters）
## 1.问题
给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

```
输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
```

示例 2:

```
输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
```

示例 3:

```
输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
```

## 2.思路
### 2.1 哈希表法
1、从start=0,end=0开始遍历

2、在哈希表中查看是否有end下标对因的数值，如果有那么就更新start

start是end下标对因数值在哈希表中的下标和本次start的值中大的。

为什么要这么做呢？

如"abccb"。遍历到最后一个b时，可以查到哈希表中有b（第一个b），但是此时start时第二个c下标。所以可见不能小于start当前的下标，会造成来两个b中间有c重复。

3、将本次end对因的数值和下标+1put到哈希表中（会覆盖原来的<数值,下标+1>）

4、更新长度

*时间复杂度*:O(n)

*空间复杂度*:O(n)

### 2.2 暴力法
1、start=0,end=0开始遍历

2、每次end增加1次，就用一个idx_find下标来遍历从下标start到end前一个，是否有和end下标所在的数值相等的

如果相等就移动start到idx_find

3、如果最大长度end-start+1变大了，就更新长度

*时间复杂度*:O(n^2)

*空间复杂度*:O(1)

## 3.感悟
* 子序列和子串
  
    子序列：子序列中的字符串不一定在原字符串中连在一起，而且是按照ASCII码顺序排序。
    
    子串：子串中的字符串在原字符串中连在一起。
    
    
# 两个排序数组的中位数（MiddleOfTwoSortedArrays）

## 1.问题
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

示例 1:

nums1 = [1, 3]
nums2 = [2]

中位数是 2.0

示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

中位数是 (2 + 3)/2 = 2.5

## 2.思路
1.判断数组降序还是升序，并设定从小的开始取数

2.判断两个数组中小的，取出

3.直到取到中位数

3.1 中位数通过`(m+n+1)%2`来判断是（等于1）否（等于0）需要平均

# 14 最长公共前缀
## 1.问题
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

```
输入: ["flower","flow","flight"]
输出: "fl"
```

示例 2:

```
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:
所有输入只包含小写字母 a-z 。
```

## 2.思路
### 2.1 暴力搜索
```
minlen = strs[0].len
strnum = strs.len
For str : strs
    If str.len < minlen
        minlen = str.len
    End
End

prefix = ""
For i = 0 : minlen - 1
    ch = strs[0].charAt(i)
    For str : strs
        If str.charAt(i) != ch
            return prefix
    End
    prefix += ch
End
```

# 15 三数之和
中等

## 1.问题

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组` nums = [-1, 0, 1, 2, -1, -4]`，

满足要求的三元组集合为：

```
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```


## 2.思路
### 2.1 最终思路

1、nums排序

2、首先确定三个数中最小的数，得到其余两个数之和的目标，从左往右遍历

3、再使用双指针法得到中间数、最大数

*遍历过程注意点*

* 越大的数，下标一定比小的数下标大。

* 最小的数遍历到倒数第三个即可。

* 确定最小的数的时候，如果和前面一个的相同，可以直接跳过。

因为当前最小数后面遍历的数集合是前一个相同的数后面遍历的数集合的子集。

[-1,-1,-1,0,1,1,2]，可见第一个-1后面的数肯定比第二个-1后面的数多，是子集关系。第二个-1作为最小数所做的遍历结果，一定包含在第一个-1作为最小数所做的遍历结果当中。

*时间复杂度*:O(n^2)

*空间复杂度*:O(1)??

## 2.2 其他思路
### 2.2.1 步骤
1、nums排序

2、先确定三个数（小、中、大排序）的中间那个，得到其余的两个数相加需要多大。

3、开始向左边和右边遍历，寻找最小的值和最大的值。

### 2.2.2 说明

*问题*

需要考虑左边和右边遍历的数是否会影响到最终出来的结果是重复的，较麻烦。

*特点*

减少遍历的时间。

## 3.感悟
* 双指针法

目标：两个数相加和target相等，且找到的数不重复

方法：

1、排序数组

2、一个（min）从最小开始，一个（max）从最大开始。

3、如果相加大于target，则max减小，即max下标减小。

如果相加小于target，则min增大，即max下标增大。

4、如果相加等于target，则保存这组数。

双指针同时向对方靠拢，min下标变大，max下标变小。

同时，**为了防止重复**，如果max和上一个相等，则跳过，到达在下一个。min同理。

```Java
while(idx_mid<idx_max&&nums[idx_mid]==nums[idx_mid-1]) {
						idx_mid++;
					}
```

# 16 最接近的三数之和（ThreeSumClosest）
中等
## 1.问题

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

## 2.思路
使用三指针，i从头到尾遍历，再通过两个指针（在i右边的最左侧和最右侧开始）left和right，left只能增大（三数和随之增大），right只能减小（三数和随之减小）。和target的对比，通过调节left和right的移动来增大或者减小三数之和，进而找到最接近的数。


# 17 电话号码的字母组合（LetterCombinations）

## 1. 问题
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

```
2：abc
3：def
4：ghi
5：jki
6：mno
7：pqrs
8：tuv
9：wxyz
```

## 2.思路
1.创建一个字符串数组，保存字母V1；将字符串转化为整数型数组V2；创建要返回的String列表ans
2.For循环中创建数组

```
FOR int i : V2
    int len = ans.len==0?1:ans.len;
    String thisS = V1[i]
    WHILE len--
        String s = ans.remove
        FOR char ch : thisS.toCharArray
              ans.add(s+ch)
        END
    END
END
```

# 18.四数之和
## 1.问题
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

```
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

## 2.思路
nums.sort

For i = 0:N - 1
    For j = i + 1:N - 1
        target_2item = target - nums[i][j]
        find(nums, i, j, target_2item)  // 找到所有2个元素相加等于target_2item
    End
End

*考虑到不能重复，使用Set<List<Integer>>保存数据，最后转化为List<List<Integer>>*

# 29. 两数相除 Divide
## 1.问题
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 

示例 1:

```
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
```

示例 2:

```
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
```

提示：

被除数和除数均为 32 位有符号整数。

除数不为 0。

假设我们的环境只能存储 32 位有符号整数，其数值范围是 `[−2^31,  2^31 − 1]`。本题中，如果除法结果溢出，则返回 `2^31 − 1`。

## 2.思路
### 2.1 递归法
1. 除数不断乘2

2. 直到结果超过被除数（需要考虑溢出问题）

策略包括：比较大小时，`vabsDividend - sum <= sum`，防止`2 * sum`溢出；计算过程中都使用负数计算，随后再转化为正数

3. 超过后计算得到剩下的，进一步进行递归操作，直到除以后等于0

```java
public int divide(int dividend, int divisor) {
    int result = divideVabs(dividend, divisor);
    boolean resultIsPos = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
    if (resultIsPos) {
        if (result == Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        } else {
            result = -result;
        }
    }
    return result;
}
public int divideVabs (int dividend, int divisor) {
    // 转化为负数
    int vabsDividend = dividend < 0 ? dividend : -dividend;
    int vabsDivisor = divisor < 0 ? divisor : -divisor;
    if (vabsDividend > vabsDivisor) {
        return 0;
    }
    int sum = vabsDivisor;
    int result = -1;
    for (;vabsDividend - sum <= sum;) {
        sum += sum;
        result += result;
    }
    int res = vabsDividend - sum;
    result = divideVabs(res, divisor) + result;
    return result;
}
```
### 2.2 暴力法
不断使用除数加法实现超过被除数

```java
public int divide(int dividend, int divisor) {
    if (divisor == 0) {
        return Integer.MAX_VALUE;
    }
    int sum = 0;
    // 转化为负数
    int vabsDividend = dividend < 0 ? dividend : -dividend;
    int vabsDivisor = divisor < 0 ? divisor : -divisor;
    int result = 0;
    for (result = 0; vabsDividend - sum <= vabsDivisor; result --) {
        sum += vabsDivisor;
    }
    int sign;
    if (dividend > 0 && divisor >0) {
        sign = 1;
    } else if (dividend < 0 && divisor < 0){
        sign = 1;
    } else {
        sign = -1;
    }
    if (sign == -1) {
        return result;
    } else {
        if (result != Integer.MIN_VALUE) {
            return -result;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
```
# 31.下一个排列（Next Permutation）
## 1.问题
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。

```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

## 2.思路

```
nums[N]

For i = N-2 : 0
    tmp = nums[i]
    If nums[i] < nums[N-1]
        For j = i + 1 : N - 1
            If nums[i] < nums[j]  
                nums[i] = nums[j]
                nums[j] = tmp
                return
            End
        End
    Else
        For j = i + 1 : N - 1
            nums[j - 1] = nums[j]
        End
        nums[N-1] = tmp
    End
End
```

# 33. 搜索旋转排序数组

## 1.问题
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 `O(log n)` 级别。

示例 1:

```
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

示例 2:

```
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```
## 2.思路

```java
/**
 * 二分查找
 * @param left
 * @param right
 * @param nums
 * @param target
 * @return
 */
public int binarysearch(int left, int right, int[] nums, int target) {
    int middle;
    while (left <= right) {
        middle = (left + right) / 2;
        if (nums[middle] > target) {
            right = middle - 1;
        }else if (nums[middle] < target){
            left = middle + 1;
        }else {
            return middle;
        }
    }
    return -1;
}

/**
 * 查找旋转的索引
 * @param nums
 * @return
 */
public int find_rotation_idx (int[] nums) {
    int left = 0;int right = nums.length - 1;
    if (nums[left] < nums[right]) {
        return 0;
    }
    while (left <= right) {
        int middle = (left + right) / 2;
        if (nums[middle] > nums[middle + 1]) {
            return middle + 1;
        } else if (nums[middle] >= nums[0]){
            left = middle + 1;
        } else if (nums[middle] <= nums[nums.length - 1]) {
            right = middle - 1;
        }
    }
    return -1;
}
public int search(int[] nums, int target) {
    if (nums.length == 1) {
        return nums[0] == target ? 0:-1;
    } else if (nums.length == 0) {
        return -1;
    }
    int rotation_idx = find_rotation_idx(nums);
    if (rotation_idx == -1) {
        return -1;
    }
    if (rotation_idx == 0) {
        return binarysearch(0, nums.length-1, nums, target);
    } else if (target >= nums[0]) {
        return binarysearch(0, rotation_idx - 1, nums, target);
    } else if (target <= nums[nums.length - 1]){
        return binarysearch(rotation_idx, nums.length - 1, nums, target);
    } else {
        return -1;
    }
}

```

# 34. 在排序数组中查找元素的第一个和最后一个位置
## 1.问题
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 `O(log n)` 级别。

如果数组中不存在目标值，返回` [-1, -1]`。

示例 1:

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
```

示例 2:

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
```

## 2.思路
### 2.1 二分查找
1. 使用二分查找法找到目标

如果没有找到直接返回`[-1,-1]`

2. 如果找打了一个目标，则再向两侧搜索

# 39.组合总数
## 1.问题
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

```
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
```

示例 1:

```
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
```

示例 2:

```
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

## 2.思路

### 2.1 递归法

```
nums是一个升序数组

combinationSum(nums, target,i)

List<List<Integer>> list 

For i ; nums[i] <= target && NotOutOfBound; i++
    If nums[i] == target
        List<Integer> l1 = {nums[i]}
        list.add(l1)
    Else
        List<List<Integer>> l2
        l2 = combinationSum(nums, target-nums[i],i)
        If l2.isNotEmpty
            For l : l2
                l.add(nums[i])
                list.add(l)
            End
        End
    End
End
return list

```

说明：i参数的作用是防止重复，只能向后找


### 2.2 动态规划

动态规划法较为繁琐，因为动态规划的最终结果以来前面的结果（耦合度高），比如计算target = 5，需要考虑`dp[1:4]`，会出现各种重复的情况。

而上述递归法的结果都是独立的，可以通过让idx不从0开始，而是从上一步递归的一步开始，从而实现后面的递归数字都是大于等于前面的数字的。

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int len = candidates.length;
    if (len == 0) {
        return new LinkedList<>();
    }
    Map<Integer,List<List<Integer>>> dp = new HashMap<>();
    Arrays.sort(candidates);
    for (int num = candidates[0] ; num <= target; num ++) {
        List<List<Integer>> lists = new LinkedList<>();
        Set<List<Integer>> mapLists = new HashSet<>();
        for (int j = 0 ; j < len && candidates[j] <= num ; j ++) {
            if (dp.containsKey(num - candidates[j])) {
                List<List<Integer>> l_dp = dp.get(num - candidates[j]);
                for (List<Integer> l : l_dp) {
                    List<Integer> l_new = new LinkedList<>(l);
                    if (l_new.get(l_new.size() - 1) < candidates[j]) {
                        l_new.add(candidates[j]);
                    } else {
                        for (int i = 0 ; i < l_new.size() ; i ++) {
                            if (l_new.get(i) >= candidates[j]) {
                                l_new.add(i, candidates[j]);
                                break;
                            }
                        }
                    }
                    mapLists.add(l_new);
                }
            }else if (candidates[j] == num) {
                List<Integer> l_new = new LinkedList<>();
                l_new.add(candidates[j]);
                mapLists.add(l_new);
            }
        }
        for (List<Integer> list : mapLists) {
            lists.add(list);
        }
        dp.put(num, lists);
    }
    if (dp.containsKey(target)) {
        return dp.get(target);
    } else {
        return new LinkedList<>();
    }
}
```

# 43. 字符串相乘 String Multiply
## 1 问题
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

```
输入: num1 = "2", num2 = "3"
输出: "6"
```

示例 2:

```
输入: num1 = "123", num2 = "456"
输出: "56088"
```

说明：

1. num1 和 num2 的长度小于110。

2. num1 和 num2 只包含数字 0-9。

3. num1 和 num2 均不以零开头，除非是数字 0 本身。

4. 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
## 2.思路
### 2.1 竖式计算
1. 创建全零字符数组result，长度为两个字符串之和（相乘后数字不会超过该长度）

2. 遍历两个字符串的每个字符，将两个字符串的字符相乘

3. 根据字符所在下标，可以确定相乘的结果应该加到字符数组result的哪一位

4. 考虑进位

```java
public String multiply(String num1, String num2) {
    int num1Len = num1.length();
    int num2Len = num2.length();
    char[] result = new char[num1Len + num2Len];
    for (int i = num1Len - 1 ; i >= 0 ; i --) {
        for (int j = num2Len - 1 ; j >= 0 ; j --) {
            int val1 = num1.charAt(i) - '0'; int val2 = num2.charAt(j) - '0';
            int multi = val1 * val2;
            int bit1 = multi % 10; int bit2 = multi / 10;
            result[i + j + 1] += bit1;
            int c = result[i + j + 1] / 10;
            result[i + j + 1] %= 10;
            result[i + j] += bit2 + c;
            c = result[i + j] / 10;
            result[i + j] %= 10;
            if (c > 0) {
                result[i + j - 1] += c;
            }
        }
    }
    int start = 0;boolean findNotZero = false;
    for (int i = 0; i < num1Len + num2Len; i ++) {
        if (result[i] != 0 && findNotZero == false) {
            findNotZero = true;
            start = i;
        }
        result[i] += '0';
    }
    if (findNotZero == true) {
        return String.copyValueOf(result,start,result.length - start);
    } else {
        return "0";
    }
}
```

# 46. 全排列
## 1.问题
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## 2.思路
### 2.1 递归法
```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 0) {
        return result;
    } else if (nums.length == 1) {
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        result.add(0, list);
        return result;
    }
    for (int i = 0; i < nums.length ; i ++ ) {
        int[] new_nums = new int[nums.length - 1];
        for (int j = 0,x = 0 ; x < nums.length ; x ++) {
            if (x != i) {
                new_nums[j] = nums[x];
                j ++;
            }
        }
        List<List<Integer>> result_temps = permute(new_nums);
        for (List<Integer> result_temp : result_temps) {
            result_temp.add(0,nums[i]);
            result.add(result_temp);
        }
    }
    return result;
}
```

# 48.旋转图像
## 1. 问题描述
给定一个 N × N 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

```
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

示例 2:

```
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

## 2. 解决方案
以包围圈的方式实现逐个圈的旋转

```
low = n
up = N - 1 - n
int[] temp = matrix[low][low + 1:up]
length = up - low + 1   // 边长
For i = 0:length - 1
    matrix[low][up - i] = matrix[low  + i][low]
    matrix[low  + i][low] = matrix[up][low + i]
    matrix[up][low + i] = matrix[up - i][up]
    matrix[up - i][up] = temp[length - 1 - i]
End
```

# 49. 字母异位词分组

## 1. 问题

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

```
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

说明：

所有输入均为小写字母。

不考虑答案输出的顺序。

## 2.思路

逐个遍历，排序后查询是否为新的字符组。

# 53. 最大子序和（Max SubArray）

## 1.问题
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: `[-2,1,-3,4,-1,2,1,-5,4]`,

输出: 6

解释: 连续子数组 `[4,-1,2,1]` 的和最大，为 6。

进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

## 2.思路

### 动态规划

遍历，每次找到遍历元素为结尾的最大子序和

### 暴力法

遍历，两个变量，1个保存最大的和，1个记录当前的和。每次发现当前和加上下一个元素比下一个元素小了，说明当前和需要重新计算了。

# 79 单词搜索（WordSearch）
## 1.问题
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
```


给定 word = "ABCCED", 返回 true.

给定 word = "SEE", 返回 true.

给定 word = "ABCB", 返回 false.

## 2.思路
使用回溯算法，字母表（已经使用的字母用空格代替）、单词剩下的部分，开始的坐标作为输入，直到单词剩下部分为0.

*注意*：二维数组赋值深拷贝需要通过特定函数实现，如`System.arraycopy`，但是`System.arraycopy`只能对某个对象操作，不能直接操作二维数组，所以需要写一个for。对于某一个类的数组，也需要逐个深拷贝。

```java
char[][] boardNext = new char[board.length][board[0].length];
for (int idx = 0; idx < board.length;idx ++){
    System.arraycopy(board[idx],0,boardNext[idx],0,board[0].length);
}
```

# 283 移动零（MoveZeroes）
数组、双指针

## 1.问题
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]

输出: [1,3,12,0,0]

说明:

必须在原数组上操作，不能拷贝额外的数组。尽量减少操作次数。

## 2.思路
在原数组上遍历，不是零则放到前面。遍历完后，数组后面没有赋值过的就置零。

空间复杂度O(n)

时间复杂度O(1)

# KMP字符串匹配
## 1. 问题
在str1中找到str2的起始位置。

## 2. 思路
### 2.1 KMP
1. 对str2计算得到状态转移机

dp[str2.length][256]，行表示第i个字符，列表示ASCII字符。dp中存储，在第i个字符匹配时，碰到不同的字符，分别回退或者推进到何处。

2. 利用dp进行匹配

```java
class Kmps {
    /**
     * 获取next数组（状态机）
     * @param ps 字符串
     * @return next数组
     */
    private static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            // 情况1,p[j] == p[k]，next是往后推进的
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            // 情况2,p[j] != p[k]，k需要回退
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * str2在str1的起始位置
     * @param str1 字符串2
     * @param str2 字符串1
     * @return str2在str1的起始位置
     */
    public static int getIndex (String str1, String str2) {
        int[] next = getNext(str2);
        int i = 0, j = 0;
        for (; i < str1.length() && j < str2.length(); ) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch1 != ch2) {
                if (next[j] < 0) {
                    i ++;
                } else {
                    j = next[j];
                }

            } else {
                j ++;
                i ++;
            }
        }
        if (j >= str2.length()) {
            return i - str2.length();
        } else {
            return -1;
        }
    }
}
```

# 647. 回文子串 CountSubstrings
## 1.问题
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

```
输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
```

示例 2:

```
输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
```

注意:

输入的字符串长度不会超过1000。

## 2.思路
### 2.1 中心对称法
1. 遍历所有元素和两个元素中间

2. 累加回文子串个数

```java
public int countSubstrings(String s) {
    int sum;
    switch (s.length()) {
        case 0:
            sum = 0;
            return sum;
        case 1:
            sum = 1;
            return sum;
        default:
            sum = 0;
            break;
    }

    for (int i = 0 ; i < s.length(); i ++) {
        sum ++;
        // 1个字符为中心
        for (int j = 1; ;j ++){
            int left = i - j;
            int right = i + j;
            int inc = count(s, left, right);
            if (inc == 0) {
                break;
            } else {
                sum += inc;
            }
        }
        // 2个字符为中心
        for (int j = 1 ; ; j ++) {
            int left = i + 1 - j;
            int right = i + j;
            int inc = count(s, left, right);
            if (inc == 0) {
                break;
            } else {
                sum += inc;
            }
        }
    }
    return sum;
}

public int count (String s , int left , int right) {
    int sum = 0;
    if ((left >= 0) && (right < s.length())) {
        if (s.charAt(left) == s.charAt(right)) {
            sum += 1;
        }
    }
    return sum;
}
```

### 2.2 拉马车法

[拉马车法](https://www.cnblogs.com/bitzhuwei/p/Longest-Palindromic-Substring-Part-II.html)