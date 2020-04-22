package cn.neyzoter.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取YYMD
 * @author Charles Song
 * @date 2020-4-22
 */
public class GetYyMD {
    public static void main (String[] args) {
        SimpleDateFormat sdfYy = new SimpleDateFormat ("yyyy");
        SimpleDateFormat sdfM = new SimpleDateFormat ("MM");
        SimpleDateFormat sdfD = new SimpleDateFormat ("dd");
        Date date = new Date();
        int yy = Integer.parseInt(sdfYy.format(date));
        int m = Integer.parseInt(sdfM.format(date));
        int d = Integer.parseInt(sdfD.format(date));
        int yymd = yy << 16 | m << 8 | d;
        System.out.println(String.format("[LITTLE ENDIAN] yymd = 0x%x", yymd));

    }
}
