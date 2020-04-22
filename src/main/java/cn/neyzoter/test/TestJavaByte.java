package cn.neyzoter.test;

/**
 * 测试Java Byte的<< >> >>
 * @author Charles Song
 * @date 2020-4-22
 */
public class TestJavaByte {
    public static void main (String[] args) {
        Byte posByte = 2;
        Byte nagByte = -2;
        System.out.println(String.format("posByte = %s B", toBinary(posByte)));
        System.out.println(String.format("nagByte = %s B", toBinary(nagByte)));
        System.out.println("Java中只能用short保存无符号byte，不存在unsigned byte");

        int posInt = 1000;
        int nagInt = -1000;
        System.out.println(String.format("posInt = %s B", toBinary(posInt)));
        System.out.println(String.format("nagInt = %s B", toBinary(nagInt)));

        int posIntRightBit = posInt >> 1;
        int nagIntRightBit = nagInt >> 1;
        System.out.println(String.format("posIntRightBit = %s B", toBinary(posIntRightBit)));
        System.out.println(String.format("nagIntRightBit = %s B %d D", toBinary(nagIntRightBit), nagIntRightBit));

    }
    public static String toBinary (byte val) {
        String resualt = "";
        for (int i = 7 ; i >= 0 ; i --) {
            resualt += String.valueOf(((val >>> i) & 0x01));
        }
        return resualt;
    }
    public static String toBinary (int val) {
        String resualt = "";
        for (int i = 31 ; i >= 0 ; i --) {
            resualt += String.valueOf(((val >>> i) & 0x01));
        }
        return resualt;
    }
}
