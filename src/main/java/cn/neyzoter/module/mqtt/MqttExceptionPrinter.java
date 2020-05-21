package cn.neyzoter.module.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * MqttExceptionPrinter
 * @author Charles Song
 * @date 2020-5-21
 */
public class MqttExceptionPrinter {
    public static void print (MqttException me) {
        System.out.println("reason " + me.getReasonCode());
        System.out.println("msg " + me.getMessage());
        System.out.println("loc " + me.getLocalizedMessage());
        System.out.println("cause " + me.getCause());
        System.out.println("excep " + me);
    }
}
