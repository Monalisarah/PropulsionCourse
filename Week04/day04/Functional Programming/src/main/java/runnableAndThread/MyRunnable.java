package runnableAndThread;

public class MyRunnable implements Runnable {

	int multiplyTwoByTwo() {
		return 2 * 2;
	}
	@Override
	public void run() {
		System.out.println("I’m running in a different thread: " + Thread.currentThread().getName());
		System.out.println("Print out 2 times 2"+ multiplyTwoByTwo());
	}
	
}
