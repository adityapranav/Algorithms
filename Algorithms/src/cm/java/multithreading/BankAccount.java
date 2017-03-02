package cm.java.multithreading;

public class BankAccount {
	
	public static int sequence = 1;
	int balance;
	int acctNum;
	
	public BankAccount() {
		acctNum = sequence++;
		balance = 0;
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("successfully deposited "+amount+" in the account "+acctNum);
	}
	public boolean withdraw(int amount) {
		if (balance < amount) {
			System.out.println("cannot withdraw "+amount+" from the account "+acctNum);
			return false;
		} 
		System.out.println("successfully withdrawn "+amount+" from the account "+acctNum);
		balance = balance -amount;
		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("AccountNumber : "+acctNum+"   ");
		sb.append("AccountBalance : "+balance);
		return sb.toString();
	}
	
	public int getBalance() {
		return balance;
	}
}
