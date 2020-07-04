package cn.neyzoter.module.kafka;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.TimeoutException;

import java.time.Duration;
import java.util.*;

/**
 * 需要手动提交commit的消费者客户端
 * @author Charles Song
 * @date 2020-7-4
 */
public class KafkaConsumerCliCommit extends ShutdownableThread {
    private final KafkaConsumer<Integer, String> consumer;
    private final String topic;
    private final String name;

    public static void main (String[] args) {
        KafkaConsumerCliCommit consumerCliCommit = new KafkaConsumerCliCommit(KafkaProperties.TOPIC, "Commit2");
        consumerCliCommit.start();
    }
    public KafkaConsumerCliCommit(String topic, String name) {
        super("KafkaConsumerExample_" + name, false);
        /**
         * 手动控制offset
         */
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaProperties.GROUP_ID);
        // 启动手动
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, name);
        this.name = name;
        consumer = new KafkaConsumer<>(props);
        this.topic = topic;

        /**
         * 手动分配partition
         * 和consumer.subscribe冲突，使用其中一种方式
         */
        TopicPartition partition0 = new TopicPartition(KafkaProperties.TOPIC, 0);
        TopicPartition partition1 = new TopicPartition(KafkaProperties.TOPIC, 1);
        consumer.assign(Arrays.asList(partition0, partition1));
        // 如果宕机，则需要恢复到offset
        resetConsumer();

    }

    @Override
    public void doWork() {
//        consumer.subscribe(Collections.singletonList(this.topic));
        long startMs = System.currentTimeMillis() / 1000;
        ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofSeconds(5));

        /**
         * 手动控制offset
         * 当宕机后，等待consumer重启，则通过seek(TopicPartition, long)来恢复到之前的offset
         */
        // 分别对每个partition进行操作
        for (TopicPartition partition : records.partitions()) {
            List<ConsumerRecord<Integer, String>> partitionRecords = records.records(partition);
            for (ConsumerRecord<Integer, String> record : partitionRecords) {
                System.out.println("[ " + this.name + " ] Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset() + " from partition " + record.partition() +
                        " in " + (int) (System.currentTimeMillis() / 1000 - startMs) + " ms");

            }
            // 获取最近的offset
            long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
            // 提交offset
            try {
                System.out.println("Start sending offset [ " + lastOffset + " ]");
                consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)), Duration.ofSeconds(2));
                System.out.println("Sent offset successfully");
            } catch (TimeoutException te) {
                te.printStackTrace();
            }
        }
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }

    public void resetConsumer () {
        List<TopicPartition> topicPartitions = new ArrayList<>();
        topicPartitions.add(new TopicPartition(KafkaProperties.TOPIC, 0));
        topicPartitions.add(new TopicPartition(KafkaProperties.TOPIC, 1));
        // 设置为最新的offset
        // 当然也可以将offset保存到数据库中，从数据库中读取
        consumer.seekToBeginning(topicPartitions);
    }
}
