package cn.neyzoter.test;

import java.util.HashMap;

/**
 * 测试引用传递还是值传递
 * @author neyzoter
 */
public class TestValueOrPointerTrans {
    public static void main(String[] args) {
        MyInteger val = new MyInteger(16);
        System.out.println("before : " + System.identityHashCode(val));
        transWithObject(val);
    }
    public static void transWithObject(MyInteger v) {
        System.out.println("transed : " + System.identityHashCode(v));
    }
}

class MyInteger {
    int val;
    HashMap<Integer, Integer> hm;
    MyInteger(int v) {
        this.val = v;
        hm = new HashMap<>(val);
    }
    public void print() {
        System.out.println(val);
    }
}