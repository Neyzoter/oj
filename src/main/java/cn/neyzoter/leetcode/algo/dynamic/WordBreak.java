package cn.neyzoter.leetcode.algo.dynamic;

import java.util.*;

/**
 * 139.单词拆分
 */
public class WordBreak {
    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(2));

        String[] strs = {"leetcode", "applepenapple", "catsandog","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};
        List<String> wordDict1 = new ArrayList<>();wordDict1.add("leet");wordDict1.add("code");
        List<String> wordDict2 = new ArrayList<>();wordDict2.add("apple");wordDict2.add("pen");
        List<String> wordDict3 = new ArrayList<>();wordDict3.add("cats");wordDict3.add("dog");wordDict3.add("sand");wordDict3.add("and");wordDict3.add("cat");
        List<String> wordDict4 = new ArrayList<>();wordDict4.add("a");wordDict4.add("aa");wordDict4.add("aaa");wordDict4.add("aaaa");wordDict4.add("aaaaa");
        wordDict4.add("aaaaaa");wordDict4.add("aaaaaaa");wordDict4.add("aaaaaaaa");wordDict4.add("aaaaaaaaa");wordDict4.add("aaaaaaaaaa");
        List<List<String>> wordDicts = new ArrayList<>();wordDicts.add(wordDict1);wordDicts.add(wordDict2);wordDicts.add(wordDict3);wordDicts.add(wordDict4);
//        Solution1_WordBreak solution1_wordBreak = new Solution1_WordBreak();
//        for (int i = 0; i < strs.length;i ++) {
//            System.out.println(strs[i]);
//            System.out.println("\t"+solution1_wordBreak.wordBreak(strs[i],wordDicts.get(i)));
//
//        }

//        Solution2_WordBreak solution2_wordBreak = new Solution2_WordBreak();
//        solution2_wordBreak.stringTest();
//        for (int i = 0; i < strs.length;i ++) {
//            System.out.println(strs[i]);
//            System.out.println("\t"+solution2_wordBreak.wordBreak(strs[i],wordDicts.get(i)));
//
//        }

        Solution3_WordBreak solution3_wordBreak = new Solution3_WordBreak();
        for (int i = 0; i < strs.length;i ++) {
            System.out.println(strs[i]);
            System.out.println("\t"+solution3_wordBreak.wordBreak(strs[i],wordDicts.get(i)));

        }
    }


}

/**
 * 暴力动态规划法
 * 时间复杂度：O(n^n)，最坏情况s = aaaaaaa 。每一个前缀都在字典中，此时回溯树的复杂度会达到 n^n
 * 空间复杂度：O(n)O(n) 。回溯树的深度最深达到 nn 。
 *
 */
class Solution1_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordDict) {
            wordSet.add(str);
        }
        return wordExist(s , wordSet);
    }

    public boolean wordExist(String s, Set<String> wordSet) {
        String s1;String s2;
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0 ; i < s.length() ; i ++) {
            // substring not contains last one
            s1 = s.substring(0 , i + 1);
            // substring is start from the idx of i + 1
            s2 = s.substring(i + 1);
            if (wordSet.contains(s1) && wordExist(s2 , wordSet)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 记忆花回溯，将前面搜索过的结果保存
 * 时间复杂度：n(n^2)
 * 空间复杂度：n(n)
 */
class Solution2_WordBreak {
    Map<String,Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        memo.clear();
        Set<String> wordSet = new HashSet<>();
        for (String str : wordDict) {
            wordSet.add(str);
        }
        return wordExist(s , wordSet);
    }

    public boolean wordExist(String s, Set<String> wordSet) {
        String s1;String s2;
        if (s.length() == 0) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        for (int i = 0 ; i < s.length() ; i ++) {
            // substring not contains last one
            s1 = s.substring(0 , i + 1);
            // substring is start from the idx of i + 1
            s2 = s.substring(i + 1);
            if (wordSet.contains(s1)) {
                if (wordExist(s2 , wordSet)) {
                    memo.put(s, true);
                    return true;
                }else {
                    memo.put(s2, false);
                }

            }
        }
        memo.put(s, false);
        return false;
    }

    public void stringTest() {
        String[] ss = {"123455","123"};
        changeString(ss);
        for (String str : ss) {
            System.out.println(str);
        }
    }
    public void changeString(String[] s) {
        s[1] = "333";
    }
}

/**
 * 动态规划
 */
class Solution3_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordDict) {
            wordSet.add(str);
        }
        Boolean[] dp = new Boolean[s.length() + 1];
        for (int i = 0; i < s.length() + 1; i ++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i ++) {
            for (int j = 0 ; j < i; j ++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}