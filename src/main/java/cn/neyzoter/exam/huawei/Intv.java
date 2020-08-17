package cn.neyzoter.exam.huawei;

/**
 * 回文子串
 * @author neyzoter
 */
public class Intv {
    public static void main(String[] args) {
        test();
    }

    /**
     * 测试
     */
    public static void test() {
        String[] strs = {"133454321", "12232", "abcd", "", "babad", "cbbd"};
        for (String s : strs) {
            System.out.println("origin : " + s + "  result : " + get(s));
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * @param str 字符串
     * @return 最长回文
     */
    public static String get(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String result = Character.toString(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            // 偶数
            int left = i - 1;
            int right = i;
            String s = getMax(str, left, right);
            if (s.length() > result.length()) {
                result = s;
            }
            // 奇数
            left = i;
            s = getMax(str, left, right);
            if (s.length() > result.length()) {
                result = s;
            }
        }
        return result;
    }

    /**
     * 获取left、right开始的最长回文
     * @param str 总的字符串
     * @param left 左侧坐标
     * @param right 右侧坐标
     * @return 最长回文
     */
    public static String getMax(String str, int left, int right) {
        for (;left >= 0 && right < str.length(); left--, right++) {
            char lc = str.charAt(left);
            char rc = str.charAt(right);
            if (lc != rc) {
                break;
            }
        }
        if (left + 1 <= right) {
            return str.substring(left + 1, right);
        } else {
            return "";
        }
    }
}
