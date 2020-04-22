package cn.neyzoter.sword;


/**
 * 面试题05 替换空格
 * @author Charles Song
 * @date 2020-4-22
 */
public class ReplaceSpace {
    public static void main (String[] args) {
        String s = "We are the World!";
        Solution1_ReplaceSpace solution1_replaceSpace = new Solution1_ReplaceSpace();
        System.out.println(String.format("origin : %s  trans : %s", s, solution1_replaceSpace.replaceSpace(s)));
    }
}

class Solution1_ReplaceSpace {
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
