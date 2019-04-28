package com.company.jmm.raceCondition;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceCondition {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            Thread thread = new ResThread(counter);
            threads.add(thread);
//            thread.start(); // успевают отрабатывать ДО старта следующего
        }
        threads.parallelStream().forEach(Thread::start); // Запустим всех разом!
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Count = " + counter.count);
    }
}

class Counter {
    public int count;

    public /*synchronized*/ void increment() {
        this.count++;
    }
}

class ResThread extends Thread {
    private final Counter counter;

    public ResThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
