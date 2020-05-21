package cn.neyzoter.module.mqtt;

public class WaitFor {
    public static void wait (int s) {
        int time = s;
        while (time -- > 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
