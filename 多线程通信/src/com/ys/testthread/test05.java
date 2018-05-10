package com.ys.testthread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 线程 A B C 各自开始准备
 * 直到三者都准备完毕
 * 然后再同时运行 
 * @author cena
 *
 */
public class test05 {

	public static void main(String[] args) {
		int runner = 3;
	    CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
	    final Random random = new Random();
	    for (char runnerName='A'; runnerName <= 'C'; runnerName++) {
	        final String rN = String.valueOf(runnerName);
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                long prepareTime = random.nextInt(10000) + 100;
	                System.out.println(rN + "is preparing for time:" + prepareTime);
	                try {
	                    Thread.sleep(prepareTime);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                try {
	                    System.out.println(rN + "is prepared, waiting for others");
	                    cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                } catch (BrokenBarrierException e) {
	                    e.printStackTrace();
	                }
	                System.out.println(rN + "starts running"); // 所有运动员都准备好了，一起开始跑
	            }
	        }).start();
	    }
	}

}
