package cn.neyzoter.module.kafka;

import kafka.server.DelayedOperation;
import kafka.server.DelayedProduce;
import kafka.server.ProduceMetadata;

/**
 * Kafka的延迟队列
 * tryComplete：尝试完成，外部事件发生时会尝试完成延迟的操作。该方法返回值为true，表示可以完成延迟操作，会调用强制完成的方法（forceComplete）。返回值为false，表示不可以完成延迟操作。
 *
 * forceComplete：强制完成，两个地方调用，尝试完成方法（tryComplete）返回true时；延迟操作超时时。
 *
 * run：线程运行，延迟操作超时后，会调用线程的运行方法，只会调用一次，因为超时就会发生一次。超时后会调用强制完成方法（forceComplete），如果返回true，会调用超时的回调方法。
 *
 * onComplete：完成的回调方法。
 *
 * onExpiration：超时的回调方法。
 *
 */
public class DelayQueue {
    public static void main(String[] args) {
        DelayedOperation delayedOperation = new DelayedOperation(1000, null) {
            @Override
            public void onComplete() {
                // 完成的回调方法
            }

            @Override
            public boolean tryComplete() {
                // 尝试完成，外部事件发生时会尝试完成延迟的操作。
                // 该方法返回值为true，表示可以完成延迟操作，会调用强制完成的方法（forceComplete）。返回值为false，表示不可以完成延迟操作。
                return false;
            }

            @Override
            public void onExpiration() {
                // 超时回掉方法
            }
        };
//        DelayedProduce dp = new DelayedProduce(1000, );
    }
}
