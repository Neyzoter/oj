package cn.neyzoter.module.kafka;

/**
 * Kafka应用
 * @author Charles Song
 * @date 2020-7-4
 */
public class KafkaApp {
    public static void main (String[] args) {
        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        KafkaProducerCli producerThread = new KafkaProducerCli(KafkaProperties.TOPIC, isAsync);
        producerThread.start();

//        KafkaComsumerCli consumerThread1 = new KafkaComsumerCli(KafkaProperties.TOPIC, "consumer1");
//        consumerThread1.start();
        KafkaConsumerCliCommit consumerCliCommitThread = new KafkaConsumerCliCommit(KafkaProperties.TOPIC, "Commit2");
        consumerCliCommitThread.start();
//        KafkaComsumerCli consumerThread2 = new KafkaComsumerCli(KafkaProperties.TOPIC, "consumer2");
//        consumerThread2.start();
    }
}
