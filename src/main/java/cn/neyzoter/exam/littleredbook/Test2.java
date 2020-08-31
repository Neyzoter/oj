package cn.neyzoter.exam.littleredbook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * AC 100%
 */
public class Test2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int maxBoxes(int[][] boxes, int n) {
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int delta1 = o1[0] - o2[0];
                return delta1 == 0 ? o2[1] - o1[1] : delta1;
            }
        });
        int[] s = new int[n];
        int res = 0;
        for (int i = 0; i < n ; i++) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l - (l - r) / 2;
                if (s[mid] < boxes[i][1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            s[l] = boxes[i][1];
            if (l == res) {
                res += 1;
            }
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes, _boxes_rows);
        System.out.println(String.valueOf(res));

    }
}

