package com.company.threads.waitNotify;

public class Store {
    private int products = 0;

    synchronized void get() {
        while (products < 1) {
            System.out.println("wait for put");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }

    synchronized void put() {
        while (products >= 25) {
            System.out.println("wait for get");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products++;
        System.out.println("Производитель привез 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }
}
