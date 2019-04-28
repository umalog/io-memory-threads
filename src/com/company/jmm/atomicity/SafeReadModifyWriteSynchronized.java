package com.company.jmm.atomicity;

/**
 * метод incrementNumber потокобезопасен, потому гонки потоков не возникнет
 */
public class SafeReadModifyWriteSynchronized {

    private int number;

    public synchronized void incrementNumber() {
        number++;
    }

    public static void main(String[] args) throws InterruptedException {
        final SafeReadModifyWriteSynchronized rmw = new SafeReadModifyWriteSynchronized();

        for (int i = 0; i < 1_000; i++) {
            new Thread(() -> rmw.incrementNumber(), "Thread" + i).start();
        }

        Thread.sleep(4000);
        System.out.println("Final number (should be 1_000): " + rmw.number);
    }
}
