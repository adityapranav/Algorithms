package cm.java.multithreading;

import java.util.HashMap;

public class AccountPool {
	 private  HashMap<Integer,BankAccount> accountPool = null;
	 private  static AccountPool instance;
	 private AccountPool() {
		 accountPool = new HashMap<Integer, BankAccount>();
	 }
	 public static AccountPool getInstance() {
		 if (instance == null)
			 return new AccountPool();
		 return instance;
	 }
	 public void insert(BankAccount b, int key) {
		 accountPool.put(key, b);
	 }
	 public BankAccount get(int acctNum) {
		 return accountPool.get(acctNum);
	 }
}
