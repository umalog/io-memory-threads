package com.company.jmm.visibility;

/**
 * кеш потока запомнил состояние ready == false.
 * Программа никогда не завершиться.
 */
public class NoVisibility {
	private static boolean ready;

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (ready) {
						System.out.println("Reader Thread - Flag change received. Finishing thread.");
						break;
					}
				}
			}
		}).start();
		
		Thread.sleep(3000);
		System.out.println("Прошла куча времени - присвоим флаг");
		ready = true;
	}
}