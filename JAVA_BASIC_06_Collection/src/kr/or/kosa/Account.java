package kr.or.kosa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private List<Transaction> transactions;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	


	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>();
	}

	public void deposit(long amount) {
		System.out.println(amount + "원 입급하셨습니다.");
		this.balance = balance + amount;
		Transaction transaction = new Transaction();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH시mm분");
		transaction.setTransactionDate((String)now.format(dtf1));
		transaction.setTransactionTime((String)now.format(dtf2));
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setKind("입금");
		transactions.add(transaction);
	}

	public void withdraw(long amount) {
		 if (amount > balance) {
			 System.out.println("잔액이 부족하여 출금할 수 없습니다.");
		      return;
		}
		System.out.println(amount + "원 출급하셨습니다.");
		this.balance -= amount;
		Transaction transaction = new Transaction();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH시mm분");
		transaction.setTransactionDate((String)now.format(dtf1));
		transaction.setTransactionTime((String)now.format(dtf2));
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setKind("출금");
		transactions.add(transaction);
	}

	public long getBalance() {
		return this.balance;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNo + ", 이름=" + name + ", 잔액=" + balance + "]";
	}
	
	
}
