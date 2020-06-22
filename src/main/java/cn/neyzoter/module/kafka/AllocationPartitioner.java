package cn.neyzoter.module.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class AllocationPartitioner implements Partitioner {
    public AllocationPartitioner () {

    }
    @Override
    public void configure(Map<String, ?> configs) {
    }
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int num = cluster.availablePartitionsForTopic(topic).size();
//        System.out.println("Partition num is " + num);
        int keyHash = key.hashCode();
        // 固定
//        return 1;
        // 随着key hash变化
        return keyHash % num;
    }
    @Override
    public void close () {

    }
}
