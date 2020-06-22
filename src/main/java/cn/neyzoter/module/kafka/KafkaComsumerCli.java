package cn.neyzoter.module.kafka;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class KafkaComsumerCli extends ShutdownableThread{
    private final KafkaConsumer<Integer, String> consumer;
    private final String topic;
    private final String name;

    public KafkaComsumerCli(String topic, String name) {
        super("KafkaConsumerExample_" + name, false);
        /**
         * 自动控制offset
         */
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaProperties.GROUP_ID);
        // 自动提交Offset，为了提高系统的容错性，可以设置为false
        // 然后在消费成功后，在通过consumer.commitSync()来进行offset提交
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        // 自动提交间隔
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 如果它停止心跳的时间超过session.timeout.ms,那么就会认为是故障的，它的分区将被分配到别的进程。
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        // 自动设置Offset到
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // 这里设置为一样是为了测试名字一样是否会起到队列的作用
//        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer");
        // 给消费者取不同的名字，那么每个消费者都会消费某一个partition的消息
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, name);

        this.name = name;

        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
//        consumer.subscribe(Collections.singletonList(this.topic));

        /**
         * 手动分配partition
         * 和consumer.subscribe冲突
         */
        TopicPartition partition2 = new TopicPartition(KafkaProperties.TOPIC, 2);
        consumer.assign(Arrays.asList(partition2));

    }

    @Override
    public void doWork() {
//        consumer.subscribe(Collections.singletonList(this.topic));
        long startMs = System.currentTimeMillis() / 1000;
        ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofSeconds(5));

        for (ConsumerRecord<Integer, String> record : records) {
            System.out.println("[ " + this.name + " ] Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset() + " from partition " + record.partition() +
                    " in " + (int) (System.currentTimeMillis() / 1000 - startMs) + " ms");
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
}
