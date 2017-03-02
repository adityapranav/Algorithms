package cm.java.multithreading;

public class Withdrawer implements Runnable {

	private String threadName;
	private BankAccount a;

	public Withdrawer(String name, BankAccount a) {
		this.a = a;
		System.out.println("creating the thread with name " + name);
		threadName = name;
	}

	public void run() {
		System.out.println("Running the thread "+threadName);
		synchronized (a) {
			while (a.getBalance() == 0) {
				try {
					a.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		a.withdraw(50);
		System.out.println(a.toString());
	}
}
