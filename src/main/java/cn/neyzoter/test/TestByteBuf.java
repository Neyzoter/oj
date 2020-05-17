package cn.neyzoter.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 测试Bytebuf
 * @author Charles Song
 * @date 2020-5-17
 */
public class TestByteBuf {
    public static void main (String[] args) {
        byte[] b1 = {1,2,3,4,5};
        byte[] b2 = {6,7,8,9,10};
        byte[] b3 = {11,12,13,14,15};
        /**
         * wrappedBuffer
         */
        ByteBuf byteBuf1 = Unpooled.wrappedBuffer(b1, b2);
        byteBuf1.markReaderIndex();
        ByteBuf byteBuf2 = Unpooled.wrappedBuffer(b1, b3);
        /**
         * compositeBuffer
         */
        CompositeByteBuf compositeBuffer = Unpooled.compositeBuffer();
        compositeBuffer.addComponents(true, byteBuf1, byteBuf2);
        System.out.println(byteBuf1);
        for (;byteBuf1.readableBytes() > 0;) {
            System.out.print(byteBuf1.readByte());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(byteBuf1);


        System.out.println(compositeBuffer);
        for (; compositeBuffer.readableBytes() > 0;) {
            System.out.print(compositeBuffer.readByte());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(compositeBuffer);

        /**
         * slice
         */
        /*重置*/
        byteBuf1.resetReaderIndex();
        // i：起始index
        // i1：长度
        ByteBuf byteBuf3 = byteBuf1.slice(1, 3);
        ByteBuf byteBuf4 = byteBuf1.slice(3, 3);

        System.out.println(byteBuf3);
        for (;byteBuf3.readableBytes() > 0;) {
            System.out.print(byteBuf3.readByte());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(byteBuf3);
        System.out.println(byteBuf4);
        for (;byteBuf4.readableBytes() > 0;) {
            System.out.print(byteBuf4.readByte());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(byteBuf4);
    }
}
