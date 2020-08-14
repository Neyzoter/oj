package cn.neyzoter.test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 测试原子
 * @author neyzoter
 */
public class TestAtomic {
    public static void main(String[] args) {
        testAtomicLong();
    }

    public static void testAtomicLong(){
        AtomicLong l = new AtomicLong(10);
        if (l.compareAndSet(10, 11)) {
            System.out.println("l cas ok!");
        } else {
            System.out.println("l cas not ok!");
        }
        if (l.compareAndSet(13, 14)) {
            System.out.println("l cas ok!");
        } else {
            System.out.println("l cas not ok!");
        }
    }
    public static void testAtomicStampedReference() {
        String name = "init";
        String newName = "inited";
        AtomicStampedReference<String> as = new AtomicStampedReference<>(name, 1);
        System.out.println("Init : " + as.getReference() + "  " + as.getStamp());
        as.compareAndSet(name, newName, as.getStamp(), as.getStamp() + 1);
        System.out.println("After : " + as.getReference() + "  " + as.getStamp());

    }

}
