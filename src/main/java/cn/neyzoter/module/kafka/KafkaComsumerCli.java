package cn.neyzoter.module.kafka;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaComsumerCli extends ShutdownableThread{
    private final KafkaConsumer<Integer, String> consumer;
    private final String topic;
    private final String name;
    public boolean got = false;

    public KafkaComsumerCli(String topic, String name) {
        super("KafkaConsumerExample", false);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "DemoConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // 这里设置为一样是为了测试名字一样是否会起到队列的作用
//        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer");
        // 给消费者取不同的名字，那么每个消费者都会消费某一个partition的消息
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, name);
        this.name = name;

        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
    }

    @Override
    public void doWork() {
        if (!got) {
            consumer.subscribe(Collections.singletonList(this.topic));
            System.out.println(String.format("Current time : %d s" + System.currentTimeMillis() / 1000));
            ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofSeconds(1));
            System.out.println(String.format("Current time : %d s" + System.currentTimeMillis() / 1000));
            for (ConsumerRecord<Integer, String> record : records) {
//                got = true;
                System.out.println("[ " + this.name + " ] Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset() + " from partition " + record.partition());
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
}
