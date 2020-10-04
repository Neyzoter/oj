package cn.neyzoter.sword;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class _46_Translate2Word {
    public static void main(String[] args) {

    }
}

class Sol_46_Translate2Word {
    public static final int maxAscii = 'z' - 'a';

    public int translateNum(int num) {
        String val = String.valueOf(num);
        return dfs(val, 0);
    }

    public int dfs(String val, int start) {
        if (start == val.length()) {
            return 1;
        }
        int sum = 0;
        if (val.charAt(start) == '0') {
            return dfs(val, start + 1);
        }
        int left = start, right = start;
        //System.out.println(String.format("%d %d", left, right));
        int v = Integer.parseInt(val.substring(left, ++right));
        while (v <= maxAscii) {
            sum += dfs(val, right);
            if (++right <= val.length()) {
                v = Integer.parseInt(val.substring(left, right));
            } else {
                break;
            }
        }
        return sum;
    }
}