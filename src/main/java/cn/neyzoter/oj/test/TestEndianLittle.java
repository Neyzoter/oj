package cn.neyzoter.oj.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 大小端测试
 * @author Charles Song
 * @date 2020-4-14
 */
public class TestEndianLittle {
    public static void main (String[] args) {
        SimpleDateFormat sdfYYYY = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMM = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDD = new SimpleDateFormat("dd");

        Date date = new Date();
        int yyddmm = Integer.parseInt(sdfYYYY.format(date)) << 16 |
                Integer.parseInt(sdfMM.format(date)) << 8 |
                Integer.parseInt(sdfDD.format(date));
        System.out.println(String.format("%x", yyddmm));
    }
}
