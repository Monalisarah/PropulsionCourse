package runnableAndThread;

public class RunnableDemo {

	public static void main(String[] args) {
		// 1.normal class
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();

		// 2.anonymous class
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I’m running in a different thread: " + Thread.currentThread().getName());
			}
		}).start();
		
		// 3. lambda expression
		new Thread(()-> {
			
			System.out.println("I’m running in a different thread: " + Thread.currentThread().getName());
			
			
		}).start();
	}

}
