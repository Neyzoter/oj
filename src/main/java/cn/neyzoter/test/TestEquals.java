package cn.neyzoter.test;


public class TestEquals {
    public static void main(String[] args) {
        Integer i01 = -128;
        int i02 = -128;
        Integer i03 = Integer.valueOf(-128);
        Integer i04 = new Integer(-128);

        System.out.println(i03 == i04);
        System.out.println(i02 == i04);
        System.out.println(i01 == i03);
        System.out.println(i01 == i02);
    }
}
