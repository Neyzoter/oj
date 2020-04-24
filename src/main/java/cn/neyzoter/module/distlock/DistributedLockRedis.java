package cn.neyzoter.module.distlock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * 分布式锁的实现
 * @author Charles Song
 * @date 2020-4-24
 */
public class DistributedLockRedis {
    /**
     * 成功上锁
     */
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 获取分布式锁，不支持可重入
     * @param jedis jedis实例
     * @param lockKey 锁名称
     * @param requestId 请求ID，通过该请求ID可以解锁
     * @param secondsToExpire 过期时间 s
     * @return 是否成功获取锁
     */
    public static boolean tryAcquire (Jedis jedis, String lockKey, String requestId, int secondsToExpire) {
        // TODO
        // 不支持可重入

        // 设置参数
        SetParams params = new SetParams();
        // nx : 不存在才设置
        // ex : 过期时间
        params.nx();params.ex(secondsToExpire);
        // 设置
        String resualt = jedis.set(lockKey, requestId, params);
        // 设置成功与否
        return LOCK_SUCCESS.equals(resualt);
    }

    /**
     * 释放锁
     * @param jedis jedis
     * @param lockKey 锁名称
     * @param requestId 请求ID
     * @return 是否成功释放锁
     */
    public static boolean tryRelease (Jedis jedis, String lockKey, String requestId) {
        // 脚本
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        // 执行，eval是原子操作
        Long resualt = (Long) jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        // 返回结果
        return RELEASE_SUCCESS.equals(resualt);
    }
}
