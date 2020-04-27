package cn.neyzoter.test;

/**
 * 测试String的相等
 * @author Charles Song
 * @date 2020-4-27
 */
public class TestStringEquals {
    public static void main (String[] args) {
        String str1 = "song";
        String str2 = "song";
        String str3 = new String("song");
        if (str1 == str2) {
            System.out.println("str1 != str2");
        } else {
            System.out.println("str1 != str2");
        }
        if (str1.equals(str2)) {
            System.out.println("str1.equals(str2) = true");
        } else {
            System.out.println("str1.equals(str2) = false");
        }
    }
}
