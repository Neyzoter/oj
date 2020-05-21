package cn.neyzoter.module.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Mqtt Subscriber 订阅者
 * @author Charles Song
 * @date 2020-5-21
 */
public class MqttSubscriber {
    public static void main (String[] args) {
        String subTopic = "testtopic/#";
        String broker = "tcp://114.55.104.50:1883";
        String clientId = "emqx_subscriber";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient client = new MqttClient(broker, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("emqx_subscriber");
            connOpts.setPassword("emqx_subscriber_password".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);

            // 设置回调
            client.setCallback(new PushCallback());

            // 建立连接
            System.out.println("Connecting to broker: " + broker);
            client.connect(connOpts);

            // 订阅
            client.subscribe(subTopic);

            WaitFor.wait(Integer.MAX_VALUE);
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
