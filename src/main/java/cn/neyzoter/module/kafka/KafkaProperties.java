package cn.neyzoter.module.kafka;

public class KafkaProperties {
    public static final String TOPIC = "topic1";
    /**
     * 服务器地址
     * 需要更改为你的Kafka服务器地址和port
     */
    public static final String KAFKA_SERVER_URL = "kafka-1";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC2 = "topic2";
    public static final String TOPIC3 = "topic3";
    public static final String CLIENT_ID = "SimpleConsumerDemoClient";
    public static final String GROUP_ID = "DemoConsumer";

    private KafkaProperties() {}
}