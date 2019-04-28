package com.company.jmm.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger потокобезопасен, потому гонки потоков не возникнет
 */
public class SafeReadModifyWriteAtomic {

    private final AtomicInteger number = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        final SafeReadModifyWriteAtomic rmw = new SafeReadModifyWriteAtomic();

        for (int i = 0; i < 1_000; i++) {
            new Thread(() -> rmw.number.getAndIncrement(), "Thread" + i).start();
        }

        Thread.sleep(4000);
        System.out.println("Final number (should be 1_000): " + rmw.number);
    }
}
