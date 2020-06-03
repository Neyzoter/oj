package cn.neyzoter.sword;
/**
 * 面试题64. 求1+2+…+n
 */
public class _64_NAdd {
    public static void main (String[] args) {
        Sol1_NAdd nAdd = new Sol1_NAdd();
        System.out.println(nAdd.sumNums(9));

        Sol2_NAdd sol2 = new Sol2_NAdd();
        System.out.println(sol2.sumNums(2));
    }
}

class Sol1_NAdd {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }

}

class Sol2_NAdd {
    public int sumNums(int n) {
        /**
         * n * (n + 1) / 2
         */
        int np1 = n + 1;

        int bit = n & 0x01;
        int temp = mul(np1, 0, bit);

        bit = n >> 1 & 0x01;
        temp += mul(np1, 1, bit);

        bit = n >> 2 & 0x01;
        temp += mul(np1, 2, bit);
        bit = n >> 3 & 0x01;
        temp += mul(np1, 3, bit);
        bit = n >> 4 & 0x01;
        temp += mul(np1, 4, bit);
        bit = n >> 5 & 0x01;
        temp += mul(np1, 5, bit);
        bit = n >> 6 & 0x01;
        temp += mul(np1, 6, bit);

        bit = n >> 7 & 0x01;
        temp += mul(np1, 7, bit);
        bit = n >> 8 & 0x01;
        temp += mul(np1, 8, bit);
        bit = n >> 9 & 0x01;
        temp += mul(np1, 9, bit);
        bit = n >> 10 & 0x01;
        temp += mul(np1, 10, bit);

        bit = n >> 11 & 0x01;
        temp += mul(np1, 11, bit);
        bit = n >> 12 & 0x01;
        temp += mul(np1, 12, bit);
        bit = n >> 13 & 0x01;
        temp += mul(np1, 13, bit);
        bit = n >> 14 & 0x01;
        temp += mul(np1, 14, bit);


        return temp >> 1;
    }

    public static int mul (int num , int i, int bit) {
        if (bit == 1) {
            return num << i;
        } else {
            return 0;
        }
    }
}
