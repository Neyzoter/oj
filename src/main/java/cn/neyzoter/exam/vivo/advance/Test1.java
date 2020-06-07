package cn.neyzoter.exam.vivo.advance;
/**
 * vivo提前批Test1
 * @author Charles Song
 * @date 2020-6-7
 */
import java.util.Scanner;

public class Test1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[] had = {1,0,0,0,1};
//        int n = 5;
//
//
//        System.out.println(Test1.canPlant(had, 2));

        int n = sc.nextInt();
        int[] had = new int[n];
        for(int i = 0; i < n; i++){
            had[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i ++) {
            if (had[i] == 0) {
                if (canPlant(had, i)) {
                    had[i] = 1;
                    sum ++;
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean canPlant(int[] stat, int i) {
        int left = i - 1;
        int right = i + 1;
        if (left >=0 && right < stat.length) {
            if (stat[left] == 0 && stat[right] == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (left < 0 && right >= stat.length) {
            if (stat[i] == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (left >= 0) {
            if (stat[left] == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (stat[right] == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
