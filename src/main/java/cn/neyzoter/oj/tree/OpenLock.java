package cn.neyzoter.oj.tree;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 752. 打开转盘锁
 * @author Charles Song
 * @date 2020-5-28
 */
public class OpenLock {
    public static void main (String[] args) {
        Solution1_OpenLock.roll("0000");
    }
}

class Solution1_OpenLock {
    public static String INIT_LOCK = "0000";
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedBlockingQueue<>();
        q.add(INIT_LOCK);
        Set<String> deadSet = new HashSet<>();
        for (String end : deadends) {
            deadSet.add(end);
        }
        int times = 0;
        for (;!q.isEmpty();) {
            int num = q.size();
            for (int i = 0; i < num; i ++) {
                String key = q.poll();
                if (!deadSet.contains(key)) {
                    if (target.equals(key)) {
                        return times;
                    }
                    String[] result = roll(key);
                    for (String item : result) {
                        q.add(item);
                    }
                }
                deadSet.add(key);
            }
            times ++;
        }
        return -1;
    }

    public static String[] roll (String key) {
        String[] result = new String[key.length() * 2];
        char[] keyCh = key.toCharArray();
        for (int i = 0; i < key.length(); i ++) {
            char ch = keyCh[i];
            char ch1 = (char) (ch - 1);
            if (ch1 == ('0' - 1)) {
                ch1 = '9';
            }
            char ch2 = (char) (ch + 1);
            if (ch2 == ('9' + 1)) {
                ch2 = '0';
            }
            char[] keyClone = keyCh.clone();
            keyClone[i] = ch1;
            result[2 * i] = String.valueOf(keyClone);
            keyClone = keyCh.clone();
            keyClone[i] = ch2;
            result[2 * i + 1] = String.valueOf(keyClone);
        }
        return result;
    }
}
