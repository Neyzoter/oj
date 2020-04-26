package cn.neyzoter.test;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static java.lang.Thread.sleep;

/**
 * 测试Java的Pipe
 * @author Charles Song
 * @date 2020-4-26
 */
public class TestPipe {
    public static void main (String[] args) {
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream();
            pipedOutputStream.connect(pipedInputStream);
            Runnable task1 = () -> produce(pipedOutputStream);
            Runnable task2 = () -> consume(pipedInputStream);
            new Thread(task1).start();
            new Thread(task2).start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 生产者
     * @param stream 消息
     */
    public static void produce (PipedOutputStream stream) {
        try {
            for (int i = 0; i < 10 ; i ++) {
                String msg = String.format("Msg[%d] : ...", i);
                stream.write(msg.getBytes());
                stream.flush();
                sleep(1000);
                stream.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void consume (PipedInputStream stream) {
        try {
            while (stream.read() != -1) {
                int num = stream.available();
                byte[] buf = new byte[num];
                int readNum = stream.read(buf, 0, num);
                System.out.println(String.format("Read %d bytes", readNum));
                System.out.println(new String(buf));
            }
            stream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
