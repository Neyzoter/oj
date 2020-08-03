package cn.neyzoter.labuladong;

/**
 * 高效寻找素数
 * @author neyzoter
 */
public class FindPrime {
    public static void main(String[] args) {

    }
    public static boolean isPrime(int num) {
        if (num == 1 || num == -1) {
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
