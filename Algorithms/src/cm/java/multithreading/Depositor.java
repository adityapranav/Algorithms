package cm.java.multithreading;

public class Depositor implements Runnable {

	private String threadName;
	private BankAccount a;

	public Depositor(String name, BankAccount a) {
		this.a = a;
		System.out.println("creating the thread with name " + name);
		threadName = name;
	}

	public void run() {
		System.out.println("Running the thread "+threadName);
		a.deposit(100);
			a.notify();
		}
		System.out.println(a.toString());
	}
}
