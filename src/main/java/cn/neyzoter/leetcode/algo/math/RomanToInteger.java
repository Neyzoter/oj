package cn.neyzoter.leetcode.algo.math;

import java.util.HashMap;

/**
 * 13 罗马数字转整数
 */
public class RomanToInteger {
    public static void main(String[] args){
        String[] strs = {"III","IV","IX","LVIII","MCMXCIV"};
        Solution1_RomanToInteger solution1_romanToInteger = new Solution1_RomanToInteger();
        for (String str : strs){
            System.out.println(str);
            System.out.println("\t"+solution1_romanToInteger.romanToInt(str));
        }

    }
}

class Solution1_RomanToInteger{
    public static HashMap<Character, Integer> hashmap = new HashMap<>();
    Solution1_RomanToInteger(){
        hashmap.put('I',1);hashmap.put('V',5);hashmap.put('X',10);
        hashmap.put('L',50);hashmap.put('C',100);hashmap.put('D',500);
        hashmap.put('M',1000);
    }
    public int romanToInt(String str){
        char[] chs = str.toCharArray();
        int sum = 0;int len = chs.length;int i;
        for (i = 0 ; i < len - 1 ; i++){
            if (chs[i] == 'I' && (chs[i + 1] == 'V' || chs[i + 1] == 'X')){
                sum -= hashmap.get(chs[i]);
                sum += hashmap.get(chs[i+1]);
                i++;
            }else if (chs[i] == 'X' && (chs[i + 1] == 'L' || chs[i + 1] == 'C')){
                sum -= hashmap.get(chs[i]);
                sum += hashmap.get(chs[i+1]);
                i++;
            }else if (chs[i] == 'C' && (chs[i + 1] == 'D' || chs[i + 1] == 'M')){
                sum -= hashmap.get(chs[i]);
                sum += hashmap.get(chs[i+1]);
                i++;
            }else {
                sum += hashmap.get(chs[i]);
            }
        }
        if (i < len){
            sum += hashmap.get(chs[i]);
        }
        return sum;

    }
}