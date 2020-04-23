package cn.neyzoter.test;

/**
 * 测试Integer的==和equals
 */
public class TestIntegerEquals {
    public static void main (String[] args) {
        Integer val1 = 1;
        Integer val2 = 1;
        if (val1.equals(val2)) {
            System.out.println("equals : True");
        } else {
            System.out.println("equals : False");
        }
        if (val1 == val2) {
            System.out.println("== : True");
        } else {
            System.out.println("== : False");
        }
    }
}
