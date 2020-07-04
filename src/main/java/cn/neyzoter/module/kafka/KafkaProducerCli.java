package cn.neyzoter.module.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Kafka生产者
 * @author Charles Song
 * @date 2020-7-4
 */
public class KafkaProducerCli extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Boolean isAsync;

    public KafkaProducerCli(String topic, Boolean isAsync) {
        Properties props = new Properties();
        // 判别请求是否为完整的条件，是否成功发送
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        // 如果请求失败，生产者自动重试，这里设置重试次数为0
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        // 设置分区未发送的消息个数，每个分区都会对应一个缓存区来存储这些消息
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 1000);
        // 生产者在发送请求前等待一段时间，希望更多的消息填补到未满得到批中
        // 此处设置500ms发送一次，则在数据存储到缓存区后，会等待500ms
        // 不过也不绝对，如果缓存区中已经有其他的消息，可能跟着其他的消息一块发出去了
        props.put(ProducerConfig.LINGER_MS_CONFIG, 500);
        // 生产者可用的缓存总量，如果消息发送速度比其传输到服务器的快，
        // 将会耗尽这个缓存空间。当缓存空间耗尽，其他发送调用将被阻塞，
        // 阻塞时间的阈值通过max.block.ms设定，之后它将抛出一个TimeoutException。
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 2048000);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "cn.neyzoter.module.kafka.AllocationPartitioner");
        producer = new KafkaProducer<>(props);

        this.topic = topic;
        this.isAsync = isAsync;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String messageStr = "Message_" + messageNo;
            long startTime = System.currentTimeMillis();
            // Send asynchronously
            if (isAsync) {
                // 实际上send就是一个异步发送的函数，只是send可以有回调函数
                // 如果回调函数会占用较多的CPU资源，建议在回调函数中创建线程执行
                producer.send(new ProducerRecord<>(topic,
                        messageNo,
                        messageStr), new DemoCallBack(startTime, messageNo, messageStr));
            } else { // Send synchronously
                try {
                    // send还会返回future，可以future获取状态
                    // 需要注意的是future.get()会阻塞
                    producer.send(new ProducerRecord<>(topic,
                            messageNo,
                            messageStr)).get();
                    System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            ++messageNo;
        }
    }
}

class DemoCallBack implements Callback {

    private final long startTime;
    private final int key;
    private final String message;

    public DemoCallBack(long startTime, int key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * A callback method the user can implement to provide asynchronous handling of request completion. This method will
     * be called when the record sent to the server has been acknowledged. When exception is not null in the callback,
     * metadata will contain the special -1 value for all fields except for topicPartition, which will be valid.
     *
     * @param metadata  The metadata for the record that was sent (i.e. the partition and offset). Null if an error
     *                  occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                    "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                            "), " +
                            "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}
