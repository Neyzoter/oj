package cn.neyzoter.module.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Mqtt Publisher 发布者
 * @author Charles Song
 * @date 2020-5-21
 */
public class MqttPublisher {
    public static void main (String[] args) {
        String pubTopic = "MQTT Examples/1";
        String content = "MqttPublisher";
        // Qos2 : exactly once
        int qos = 2;
        // 自行在hosts文件中配置emqx
        // emqx表示直接和服务器连接
        // slb表示负载均衡服务器
        String broker = "tcp://slb:1883";
//        String broker = "tcp://emqx:1883";
        String clientId = "emqx_publisher";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient client = new MqttClient(broker, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("emqx_publisher");
            connOpts.setPassword("emqx_publisher_password".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);

            // 设置回调
            client.setCallback(new PushCallback());

            // 建立连接
            System.out.println("Connecting to broker: " + broker);
            client.connect(connOpts);

            System.out.println("Connected");
            System.out.println("Publishing message: " + content);

            int time = 100;
            while(time-- > 0) {
                // 消息发布所需参数
                MqttMessage message = new MqttMessage((content + " : " + time).getBytes() );
                message.setQos(qos);
                client.publish(pubTopic, message);
                System.out.println("Message published");
                WaitFor.wait(1);
            }
            client.disconnect();
            System.out.println("Disconnected");
            client.close();
            System.exit(0);
        } catch (MqttException me) {
            MqttExceptionPrinter.print(me);
            me.printStackTrace();
        }

    }
}
