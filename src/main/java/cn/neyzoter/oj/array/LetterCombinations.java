package cn.neyzoter.oj.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 17 电话号码的字母组合
 */
public class LetterCombinations {
    public static void main(String[] arg){
        String digits = "23";
        Solution1_LetterCombinations solution1_letterCombinations = new Solution1_LetterCombinations();
        System.out.println(solution1_letterCombinations.letterCombinations(digits));
    }
}

class Solution1_LetterCombinations{
    public static final String[] lettersArray = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0){
            return ans;
        }
        char[] digitsChar = digits.toCharArray();
        for (int idx : digitsChar){
            //从字符转化为int
            idx -= '0';
            // 得到字母的长度
            char[] chars = lettersArray[idx].toCharArray();
            // 得到ans的长度，多长就remove多少次，有一个第一次为0的特殊情况
            int len = ans.size()==0?1:ans.size();
            while ((len--) != 0){
                String s;
                if(ans.isEmpty()){
                    s = "";
                }else {
                    s = ans.remove(0);
                }
                for (char ch : chars){
                    ans.add(s+ch);
                }
            }

        }
        return ans;
    }

}
