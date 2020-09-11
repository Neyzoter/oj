package cn.neyzoter.exam.youzan;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Sol_Youzan1 sol = new Sol_Youzan1();
        long res = sol.sum(3, 5);
        System.out.print(res);
    }
}

class Sol_Youzan1 {
    /**
     *
     * @param num int整型 相加的数字
     * @param itemNum int整型 相加项数
     * @return long长整型
     */
    public long sum (int num, int itemNum) {
        // write code here
        int multi = 10;
        long res = 0;
        for (int i = 1;i <= itemNum;i++) {
            res *= multi;
            res += (long)num * i;
        }
        return res;
    }
}