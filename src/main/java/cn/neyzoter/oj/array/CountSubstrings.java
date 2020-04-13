package cn.neyzoter.oj.array;

/**
 * 647. 回文子串 CountSubstrings
 * @author Charles Song
 * @date 2020-4-13
 */
public class CountSubstrings {
    public static void main (String[] args) {
        String s = "fdsklf";
        Solution1_CountSubstrings solution1_countSubstrings = new Solution1_CountSubstrings();
        System.out.println(String.format("string = %s , result = %d", s, solution1_countSubstrings.countSubstrings(s)));
    }
}

class Solution1_CountSubstrings {
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
}
