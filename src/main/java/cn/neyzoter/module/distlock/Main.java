package cn.neyzoter.module.distlock;

import redis.clients.jedis.Jedis;

import static java.lang.Thread.sleep;

/**
 * 分布式锁的测试
 * @author Charles Song
 * @date 2020-4-24
 */
public class Main {
    public static void main (String[] args) {
        try {
            Jedis jedis = new Jedis();
            String lockKey = "lockKey1";
            String requestId = "AD231DE4D";
            int secondsToExpire = 1000;
            System.out.println("testAcqLock ... ");
            testAcqLock(jedis, lockKey, requestId, secondsToExpire);
            sleep(2000);
            System.out.println("testAcqLock ... ");
            testAcqLock (jedis, lockKey, requestId, secondsToExpire);
            sleep(2000);
            System.out.println("testRlsLock ... ");
            testRlsLock(jedis, lockKey, requestId);
        } catch (Exception e) {
            System.err.println(e);
        }

    }
    public static void testAcqLock (Jedis jedis, String lockKey, String requestId, int secondsToExpire) {
        if (DistributedLockRedis.tryAcquire(jedis, lockKey, requestId, secondsToExpire)) {
            System.out.println("Acq Lock success.");
        } else {
            System.out.println("Acq Lock failed.");
        }
    }
    public static void testRlsLock (Jedis jedis, String lockKey, String requestId) {
        if (DistributedLockRedis.tryRelease(jedis, lockKey, requestId)) {
            System.out.println("Release Lock success.");
        } else {
            System.out.println("Release Lock failed.");
        }
    }
}
