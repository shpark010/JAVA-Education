package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<Account> accounts;
	private int totalAccount;
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void setTotalAccount(int totalAccount) {
		this.totalAccount = totalAccount;
	}

	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.totalAccount = 0;
	}
	
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		this.totalAccount++;
	}
	
	//계좌번호로 계좌 찾기(단일 계좌 출력)
	public Account getAccount(String accountNo) {
		Account aInfo = null;
		for (Account account : accounts) {
			if(account.getAccountNo().equals(accountNo)) {
				aInfo = account;
			}
		}
		return aInfo;
	}
	//소유자명으로 계좌 찾기(여러 개좌 출력 가능)
	public List<Account> findAccounts(String name) {
		List<Account> aInfos = new ArrayList<Account>();
		for (Account account : accounts) {
			if(account.getName().equals(name)) {
				aInfos.add(account);
			}
		}
		return aInfos;
	}
	//모든 계좌 보기
	public List<Account> getAccounts() {
		return this.accounts;
	}
	//생성된 계좌 개수 보기
	public int getTotalAccount() {
		return this.totalAccount;
	}
}
