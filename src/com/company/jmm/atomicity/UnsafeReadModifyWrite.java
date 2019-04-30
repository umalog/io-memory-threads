package com.company.jmm.atomicity;


/**
 * Операция инкремента не является атомарной
 * Запустив данный пример на многоядерной машине вы получите в итоге значение меньше 1000
 */
public class UnsafeReadModifyWrite {
    private int number;

    public void incrementNumber() {
        number++;
    }

    public static void main(String[] args) throws InterruptedException {
        final UnsafeReadModifyWrite rmw = new UnsafeReadModifyWrite();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                    for (int f = 0; f < 10_000; f++) {
                        rmw.incrementNumber();
                    }
                }, "Thread" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Final number (should be 100_000): " + rmw.number);
    }
}
