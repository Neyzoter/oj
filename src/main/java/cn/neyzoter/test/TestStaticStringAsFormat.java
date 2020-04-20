package cn.neyzoter.test;

/**
 * test static String as String.format()
 */
public class TestStaticStringAsFormat {
    public static final String FORMAT = "%s,%s %s %s";
    public static void main (String[] args) {
        String printStr = String.format(FORMAT,"measurement", "tags", "fields", "timestamp");
        System.out.println(printStr);
    }
}
