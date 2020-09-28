package cn.neyzoter.exam.qihu360;

import java.util.Scanner;

/**
 * 搬家公司正在帮助一家人将小物体装箱。一个箱子的大小是有限的，公司可以把一个箱子分成最多k个独立的隔间，将一个箱子分成r个隔间需要r-1个隔板（这一个箱子没有放隔板也拥有一个本身的隔间）。而这一次搬家工作只携带了b个隔板。
 *
 * 在每一个隔间中，由于物件放多了容易损坏，最多只能放v个物体。现在这家人有a个物体，请问最少需要多少个箱子，才能将所有的物体装箱？
 *
 *
 *
 * 输入描述
 * 多组数据，每一行一组数据包含4个数，a,b,k,v,空格隔开
 *
 * 输出描述
 * 输出包含一个数，即最少的箱子数
 *
 * 样例输入
 * 10 3 2 1
 * 10 3 2 2
 * 样例输出
 * 7
 * 3
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int a = sc.nextInt(), b = sc.nextInt(),
                    k = sc.nextInt(), v = sc.nextInt();
            int need = a % v == 0 ? a / v : a / v + 1;
            int left = 0, right = need;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (cal(mid, k, b, need)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
    public static boolean cal(int x, int k, int b, int need) {
        if (x >= need) {
            return true;
        }
        int res = 0;
        if ((k - 1) * x < b) {
            res = k * x;
        } else {
            res = x + b;
        }
        return res >= need;
    }
}
