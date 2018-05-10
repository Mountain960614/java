package com.ys.testthread;
/**
 * 两个线程实现A打印123后B再打印123
 * @author cena
 *
 */
public class test02 {

	public static void printNumber(String threadName)  {
		int i=1;
		while(i<4) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(threadName+":"+i++);
		}
	}
	public static void main(String[] args) {
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				printNumber("A");
				
			}
		});
        Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printNumber("B");
			}
		});
        thread1.start();
        thread2.start();
        
        
	}
}
