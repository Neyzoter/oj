package cn.neyzoter.oj.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 */
public class GenerateParenthesis {
    public static void main(String[] args){
        int n = 10;
        Solution1_GenerateParenthesis solution1_generateParenthesis = new Solution1_GenerateParenthesis();
        System.out.println(solution1_generateParenthesis.generateParenthesis(n));

//        Solution2_GenerateParenthesis solution2_generateParenthesis = new Solution2_GenerateParenthesis();
//        System.out.println(solution2_generateParenthesis.generateParenthesis(n));
    }
}

/**
 * 回溯算法
 */
class Solution1_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<>();
        String str = "";
        getParenthesisList(strs,str,0,0,n);
        return strs;
    }

    /**
     *
     * @param str 存储不同的情况
     * @param left 左括号个数
     * @param right 右括号个数
     * @param num 括号个数
     */
    public void getParenthesisList(List<String> strs,String str, int left, int right, int num) {
        if (left + right == 2 * num) {
            strs.add(str);
        }

        if (left < num) {
            getParenthesisList(strs, str + "(",left + 1, right, num);
        }
        if (right < left) {
            getParenthesisList(strs, str + ")",left, right + 1, num);
        }
    }
}

/**
 * 动态规划法
 */
class Solution2_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<>();
        if (n == 0) {
            strs.add("");
        } else {
            for (int c = 0; c < n ; c ++) {
                for (String left: generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - c - 1)) {
                        strs.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return strs;
    }
}