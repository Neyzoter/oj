package cn.neyzoter.module.nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 服务器<br>
 * https://www.cnblogs.com/snailclimb/p/9086334.html
 * @author Charles Song
 */
public class WebServerPlus {
    public static int count = 0;
    public static void main(String[] args) {
        try {
            Selector handlerSelector = Selector.open();
            Selector listenSelector = Selector.open();
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
            Runnable listenTask = new ListenTask(listenSelector, handlerSelector);
            Runnable handlerTask = new HandlerTask(handlerSelector);
            tpe.submit(listenTask);
            tpe.submit(handlerTask);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

class ListenTask implements Runnable {
    Selector selector;
    Selector handSelector;
    boolean run;
    public ListenTask(Selector s, Selector hs) {
        selector = s;
        handSelector = hs;
        run = true;
        System.out.println("Listen Task Running");

    }
    @Override
    public void run() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            // 必须是非阻塞
            ssc.configureBlocking(false);
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (run) {
                // 阻塞方式实现，如果是epoll，则会通过
                int nReady = selector.select();
                if (nReady <= 0) {
                    // 会一直输出
                    System.out.println("nReady == 0");
                    // 交出CPU资源
                    Thread.yield();
                    continue;
                }
                System.out.println("\n------------\nSelector Probed Msg \n");
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    System.out.println(String.format("interestOps : %d", key.interestOps()));
                    // interestOps == 16
                    if (key.isAcceptable()) {
                        // 创建新的连接，并且把连接注册到selector上，而且，
                        // 声明这个channel只对读操作感兴趣。
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        // 该socket设置为对读感兴趣
                        // 加入到处理器seletor，专门用于处理数据
                        socketChannel.register(handSelector, SelectionKey.OP_READ);
                        System.out.println("Handler Selector : " + handSelector.toString());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        run = false;
    }
}

class HandlerTask implements Runnable {
    Selector handSelector;
    boolean run;
    public HandlerTask (Selector s) {
        handSelector = s;
        run = true;
        System.out.println("Handler Task Running");
    }
    @Override
    public void run() {
        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        ByteBuffer writeBuff = ByteBuffer.allocate(128);
        writeBuff.put("received".getBytes());
        writeBuff.flip();
        while (run) {
            try {
                // selectNow 非阻塞
                // 不断轮询
                // 返回当前有几个文件描述符可以操作
                int nReady = handSelector.selectNow();
                if (nReady == 0) {
                    // 会一直输出
                    System.out.println("nReady == 0");
                    // 交出CPU资源
                    Thread.yield();
                    continue;
                }
                Set<SelectionKey> keys = handSelector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    // interestOps == 1
                    if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);
                        readBuff.flip();
                        // 如果数据末尾+\r会有问题
                        System.out.println(String.format("receive : %s (%d)  from port : %d", new String(readBuff.array()), readBuff.remaining(), socketChannel.socket().getPort()));
                        // 读到数据后，则对写感兴趣
                        key.interestOps(SelectionKey.OP_WRITE);
                        // interestOps == 4
                    } else if (key.isWritable()) {
                        writeBuff.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuff);
                        // 写数据后对读感兴趣
                        // 如果此处OP_WRITE，也就是会一直写
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        run = false;
    }
}