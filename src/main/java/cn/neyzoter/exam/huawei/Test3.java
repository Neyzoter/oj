package cn.neyzoter.exam.huawei;

import java.util.Scanner;

/**
 * Test3
 * 100% AC
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strSplit = str.split(",");
        String string = strSplit[0];
        int n = Integer.parseInt(strSplit[1]);
        String[][] strCont = new String[1744][n];
        for (int i = 0; i < 1744; i++) {
            for (int j = 0; j < n; j++) {
                strCont[i][j] = "";
            }
        }
        boolean leftInc = true;
        for (int left = 0, right = n - 1, i = 0, row = 0; i < string.length(); row++) {
            strCont[row][left] = String.valueOf(string.charAt(i));
            i++;
            if (left == right) {
                leftInc = false;
                left --;
                right ++;
            } else {
                if (i < string.length()) {
                    strCont[row][right] = String.valueOf(string.charAt(i));
                    i++;
                    if (left == 0) {
                        leftInc = true;
                    }
                    if (leftInc) {
                        left++;
                        right--;
                    } else {
                        left--;
                        right++;
                    }

                }

            }
        }
        for (int j = 0; j < strCont[0].length; j++) {
            for (int i = 0; i < strCont.length; i++) {
                System.out.print(strCont[i][j]);
            }
        }
    }
}
