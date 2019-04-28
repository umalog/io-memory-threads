package com.company.jmm.visibility;

/**
 * volatile не сохраняется в кеше.
 */
public class Visibility {
	private static volatile boolean ready;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while (true) {
				if (ready) {
					System.out.println("Reader Thread - Flag change received. Finishing thread.");
					break;
				}else System.out.println();
			}
		}).start();
		
		Thread.sleep(3000);
		System.out.println("Прошла куча времени - присвоим флаг");
		ready = true;
	}
}