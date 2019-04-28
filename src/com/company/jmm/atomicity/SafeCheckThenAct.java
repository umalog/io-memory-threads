package com.company.jmm.atomicity;

/**
 * Потокобезопасный метод
 * Только один поток может получить доступ к методу в данный момент времени.
 */
public class SafeCheckThenAct {
    private int number;

    public synchronized void changeNumber() {
        if (number == 0) {
            System.out.println(Thread.currentThread().getName() + " | Changed");
            number = -1;
        } else {
            System.out.println(Thread.currentThread().getName() + " | Not changed");
        }
    }

    public static void main(String[] args) {
        final SafeCheckThenAct checkAct = new SafeCheckThenAct();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> checkAct.changeNumber(), "Thread" + i).start();
        }
    }
}
