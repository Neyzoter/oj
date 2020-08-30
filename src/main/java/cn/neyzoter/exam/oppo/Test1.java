package cn.neyzoter.exam.oppo;
import java.math.*;
/**
 * Test1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        System.out.println(add(a, b));
    }
    public static BigDecimal add(double a, double b) {
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.add(b1);
    }
}
