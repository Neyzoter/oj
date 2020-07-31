package cn.neyzoter.test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 测试原子
 * @author neyzoter
 */
public class TestAtomic {
    public static void main(String[] args) {
        String name = "init";
        String newName = "inited";
        AtomicStampedReference<String> as = new AtomicStampedReference<>(name, 1);
        System.out.println("Init : " + as.getReference() + "  " + as.getStamp());
        as.compareAndSet(name, newName, as.getStamp(), as.getStamp() + 1);
        System.out.println("After : " + as.getReference() + "  " + as.getStamp());
    }

}
