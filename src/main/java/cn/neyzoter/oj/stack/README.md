# 20 有效的括号
简单, 字符串, 栈
## 1.问题
给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: `"()"`
输出: true
示例 2:

输入: `"()[]{}"`
输出: true
示例 3:

输入: `"(]"`
输出: false
示例 4:

输入: `"([)]"`
输出: false
示例 5:

输入: `"{[]}"`
输出: true

## 2.思路
考虑从最里面的配对开始查询。

创建一个栈，从头push括号进去，如果碰到配对的就pop，结束的时候如果栈中还有括号就说明出错。