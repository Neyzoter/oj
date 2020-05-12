package cn.neyzoter.test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 测试BigInteger
 * @author Charles Song
 * @date 2020-5-12
 */
public class TestBigInteger {
    public static void main (String[] args) {
        BigInteger var = new BigInteger("1");
        for(int i = 100 ; i > 1; i --) {
            var = var.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println(var);

        BigDecimal dec = new BigDecimal("1000000.00111");
        System.out.println(dec);
    }
}
