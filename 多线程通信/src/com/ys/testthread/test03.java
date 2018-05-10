package com.ys.testthread;
/**
 *  A 在打印完 1 后
 *  再让 B 打印 1, 2, 3
 *  最后再回到 A 继续打印 2, 3
 * @author cena
 *
 */
public class test03 {
	public static void main(String[] args) {
		Object lock=new Object();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("A: "+1);
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A: "+2);
					System.out.println("A: "+3);
				}
			}
		});
        Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock) {
					System.out.println("B: "+1);
					System.out.println("B: "+2);
					System.out.println("B: "+3);
					lock.notify();
				}
			}
		});
        thread1.start();
        thread2.start();
	}
	
}
