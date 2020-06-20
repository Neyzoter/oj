package cn.neyzoter.module.kafka;

/**
 * Kafka应用
 * @author Charles Song
 * @date 2020-6-20
 */
public class KafkaApp {
    public static void main (String[] args) {
        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        KafkaProducerCli producerThread = new KafkaProducerCli(KafkaProperties.TOPIC, isAsync);
        producerThread.start();

        KafkaComsumerCli consumerThread1 = new KafkaComsumerCli(KafkaProperties.TOPIC, "consumer1");
        consumerThread1.start();
        KafkaComsumerCli consumerThread2 = new KafkaComsumerCli(KafkaProperties.TOPIC, "consumer2");
        consumerThread2.start();
    }
}
