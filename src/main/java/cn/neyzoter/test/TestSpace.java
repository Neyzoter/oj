package cn.neyzoter.test;

/**
 * 测试空格
 * @author Charles Song
 * @date 2020-7-4
 */
public class TestSpace {
    public static void main (String[] args) {
        char space = ' ';
        System.out.println(String.format("%s", Integer.toBinaryString((int)space)));
    }
}
