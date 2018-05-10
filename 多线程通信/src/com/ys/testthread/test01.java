package com.ys.testthread;
/**
 * 两个线程实现依次打印
 * @author cena
 *
 */
public class test01 {
	public static void printNumber(String threadName)  {
		int i=0;
		while(i<3) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
				printNumber("B");
			}
		});
        thread1.start();
        thread2.start();
        
        
	}
}
