package DAY8_14OCT;


	public class ThreadDemo extends Thread {

	    public void run() {
	        System.out.println("Thread is running...");
	    }

	    public static void main(String[] args) {

	        ThreadDemo obj = new ThreadDemo();

	        obj.start();
	    }
	}

