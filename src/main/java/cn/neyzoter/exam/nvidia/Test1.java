package cn.neyzoter.exam.nvidia;


import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] val = new int[4];
        String[] str = sc.nextLine().split(" ");
        int i = 0;
        boolean joker = false, JOKER = false;
        for (String s : str) {
            val[i] = val(s);
            if (s.equals("JOKER")) {
                JOKER = true;
            } else if (s.equals("joker")) {
                joker = true;
            }
            if (joker && JOKER) {
                System.out.println("ERROR");
                return;
            }
            i++;
        }
        System.out.println("++++");
    }
    public static int val(String poke) {
        switch (poke) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J" :
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 1;
            case "joker":
            case "JOKER":
            default:
                return -1;
        }
    }
}
