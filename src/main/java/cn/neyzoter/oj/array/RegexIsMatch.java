package cn.neyzoter.oj.array;

/**
 * 10. 正则表达式匹配
 * @author Charles Song
 * @date 2020-6-1
 */
public class RegexIsMatch {
    public static void main (String[] args) {
        Sol2_RegexIsMatch regexIsMatch = new Sol2_RegexIsMatch();
        System.out.println(regexIsMatch.isMatch("mississippi","mis*is*p*."));
    }
}


class Sol2_RegexIsMatch {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
