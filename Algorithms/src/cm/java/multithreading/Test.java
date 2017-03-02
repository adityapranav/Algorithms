package cm.java.multithreading;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		BankAccount a = new BankAccount();
		Thread t1 = new Thread(new Depositor("Depositor",a));
		Thread t2 = new Thread(new Withdrawer("Withdrawer", a));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
