package cn.neyzoter.module.nio.bytebuff;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试内存映射文件
 * @author Neyzoter Song
 * @date 2020-2-3
 */
public class MappedByteBuffTest {
    private static int count = 10;

    static String path = "/Users/neyzoter/code/java/oj/src/main/java/cn/neyzoter/module/nio/bytebuff/largeFile.txt";

    public static void main(String[] args) throws Exception {
        RandomAccessFile memoryMappedFile = new RandomAccessFile(path, "rw");
        // 将文件映射到内存
        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);
        // 将文本写入到内存映射文件
        for (int i = 0; i < count; i++) {
            out.put((byte) ('A'+(i%26)));
        }
        System.out.println("Writing to Memory Mapped File is completed");

        // reading from memory file in Java
        for (int i = 0; i < 10; i++) {
            System.out.print((char) out.get(i));
        }
        System.out.println("\nReading from Memory Mapped File is completed");
        memoryMappedFile.close();
    }
}
