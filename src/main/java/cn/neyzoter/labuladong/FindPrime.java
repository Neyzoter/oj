package cn.neyzoter.labuladong;

/**
 * 高效寻找素数
 * @author neyzoter
 */
public class FindPrime {
    public static void main(String[] args) {
        long l = 9876543210L;
        int l1 = (int) l;
        System.out.println(l1);
        SubClass.a();
    }
    public static int test(int i) {
        i ++;
        return i < 8888888 ? test(i) : i;
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

class SubClass {
    public static void a() {
        int j = 1;
        int sum = 0;
        for (int i = 1;i < 2000; i *= 2) {
            sum += i;
            System.out.println(j + " " + sum);
            j++;
        }

    }
}