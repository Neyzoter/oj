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

/**
 * 服务器<br>
 * https://www.cnblogs.com/snailclimb/p/9086334.html
 * @author Charles Song
 * @date 2020-7-8
 */
public class WebServer {
    public static int count = 0;
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            // 必须是非阻塞
            ssc.configureBlocking(false);
            // 选择器
            Selector selector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer readBuff = ByteBuffer.allocate(1024);
            ByteBuffer writeBuff = ByteBuffer.allocate(128);
            writeBuff.put("received".getBytes());
            writeBuff.flip();

            while (true) {
                int nReady = selector.select();
                System.out.println(String.format("\n------------\n[ %d ] Selector Probed One \n", count++));
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    System.out.println(String.format("[ %d ] interestOps : %d", count++, key.interestOps()));
                    // interestOps == 16
                    if (key.isAcceptable()) {
                        // 创建新的连接，并且把连接注册到selector上，而且，
                        // 声明这个channel只对读操作感兴趣。
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        // 该socket设置为对读感兴趣
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        // interestOps == 1
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);
                        readBuff.flip();
                        System.out.println(String.format("[ %d ] received : %s", count++, new String(readBuff.array())));
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
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
