package cn.neyzoter.test;

import java.util.concurrent.locks.StampedLock;

/**
 * 测试StampedLock
 * @author Charles Song
 * @date 2020-5-18
 */
public class TestStampedLock {
    private double x, y;
    private final StampedLock sl = new StampedLock();
    public static void main (String[] args) {
        TestStampedLock test = new TestStampedLock();
//        test.moveIfAtOrigin(2.0, 5.0);
//        test.move(1.0, 2.0);
        System.out.println("distance : " + test.distanceFromOrigin());
    }

    /**
     * 写锁（排他锁）
     * @param deltaX 给x增加的值
     * @param deltaY 给y增加的值
     */
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        System.out.println("[move] stamp : " + stamp);
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
            System.out.println("[move] stamp : " + stamp);
        }
    }

    /**
     * 乐观读锁/读锁（共享锁）
     * @return 返回x和y的距离
     */
    double distanceFromOrigin() {
        // 获取乐观读锁
        long stamp = sl.tryOptimisticRead();
        System.out.println("[distanceFromOrigin] stamp : " + stamp);
        double currentX = x, currentY = y;
        this.moveIfAtOrigin(3.0, 4.0);
        // 如果stamp失效，则需要设置读锁（共享锁，只可以读，不可以写）
        // 来重新读取，如果没有失效则直接返回
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            System.out.println("[distanceFromOrigin] stamp : " + stamp);
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 如果是初始值，则进行赋值
     * @param newX 新的x值
     * @param newY 新的y值
     */
    void moveIfAtOrigin(double newX, double newY) {
        long stamp = sl.readLock();
        System.out.println("[moveIfAtOrigin 1] stamp : " + stamp);
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);
                System.out.println("[moveIfAtOrigin 2] stamp : " + stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }
                else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                    System.out.println("[moveIfAtOrigin 3] stamp : " + stamp);
                }
            }
        } finally {
            sl.unlock(stamp);
            System.out.println("[moveIfAtOrigin 4] stamp : " + stamp);
        }
    }
}
