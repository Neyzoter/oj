package cn.neyzoter.exam.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] arrtemp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            arrtemp[i] = arr[i];
        }
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            printMid(arr, arrtemp, i);
        }
    }
    public static void printMid(int[] arr, int[] arrtemp, int rmi) {
        int mid = arr.length / 2;
        if (arrtemp[rmi] <= arr[mid]) {
            System.out.println(arr[mid + 1]);
        } else {
            System.out.println(arr[mid]);
        }
    }
}
