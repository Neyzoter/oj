package cn.neyzoter.test;

import java.util.HashMap;

public class Shuzu {
    public static void main(String[] args) {
        int[][] a = {{1,}, {1,2}};
        System.out.println(a[0].length);
        System.out.println(a[1].length);
        HashMap<String, String> hm = new HashMap<>();
        hm.put("username", "d");
        hm.put("psw", "p");
        hm.put("id", "123");
        System.out.println(hm.toString());
    }
}
