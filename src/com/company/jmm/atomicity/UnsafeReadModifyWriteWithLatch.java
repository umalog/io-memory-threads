package com.company.jmm.atomicity;

import java.util.concurrent.CountDownLatch;

/**
 * Поле "number" должно увеличиваться один раз для каждого потока.
 * Однако из-за наличия условия гонки некоторые обновления могут быть потеряны,
 * что приведет к неправильным результатам.
 * Гонка более выражена по причине одновременного старта всех потоков на startSignal.countDown()
 */
public class UnsafeReadModifyWriteWithLatch {
    private static final int NUM_THREADS = 1_000;
    private int number;
    private final CountDownLatch startSignal = new CountDownLatch(1); // Latch на одно countDown для продолжения
    private final CountDownLatch endSignal = new CountDownLatch(NUM_THREADS); // Latch на 1000 countDown

    public void incrementNumber() {
        number++;
    }

    public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
        test();
		}
    }

    public static void test() throws InterruptedException {
        final UnsafeReadModifyWriteWithLatch rmw = new UnsafeReadModifyWriteWithLatch();

        for (int i = 0; i < NUM_THREADS; i++) { // Создаем 1000 потоков
            new Thread(() -> {
                try {
                    rmw.startSignal.await(); // каждый из которых паркуется в ожидании startSignal.countDown
                    rmw.incrementNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rmw.endSignal.countDown(); // по окончании каждого потока оповестить счетчик endSignal
                }

            }, "Thread" + i).start();
        }

//        Thread.sleep(1000);
        rmw.startSignal.countDown(); // Всем стартовать!
        rmw.endSignal.await(); // ждем когда все потоки завершатся.
        System.out.println("Final number (should be 1_000): " + rmw.number);
    }
}
