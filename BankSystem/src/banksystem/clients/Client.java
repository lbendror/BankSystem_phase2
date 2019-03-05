package banksystem.clients;

import banksystem.Account;
import banksystem.log.Log;
import banksystem.log.Logger;
import banksystem.utils.ArraysHelper;
import java.util.ArrayList;

public abstract class Client {

	private int id;
	private String name;
	private float balance;
	//private Account[] accounts;
	private ArrayList<Account> accounts;
	
	protected float commissionRate = 0;
	protected float interestRate = 0;
	
	protected Logger logger;
	
	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		//accounts = new Account[5];
		accounts = new ArrayList<>();
		logger = new Logger(null);
	}

	public void addAccount(Account account) {
		accounts.add(account);
		Log log = new Log(new Date(), id, "Add new account", account.getBalance());
		//int index = ArraysHelper.getNextEmptyArrayIndex(accounts);
		//accounts[index] = account;
		//Log log = new Log(System.currentTimeMillis(), id, "Add new account", account.getBalance());
		logger.log(log);
	}
	
	public Account getAccount(int index) {
		return accounts.get[index];
	}
	
	public void removeAccount(int id) {
		
		int accountToRemoveIndex = -1;
		Account accountToRemove = null;
		
		for (int i=0; i<accounts.length; i++) {
			if (accounts[i].getId() == id) {
				accountToRemoveIndex = i;
				accountToRemove = accounts[i];
				break;
			}
		}
		
		balance += accountToRemove.getBalance();
		
		Log log = new Log(System.currentTimeMillis(), this.id, "Remove account " + accountToRemove.getId(), accountToRemove.getBalance());
		logger.log(log);
		
		accounts[accountToRemoveIndex] = null;
	}
	
	public void deposit(float amount) {
		
		float commission = amount * commissionRate;
		balance += (amount - commission);
	}
	
	public void withdraw(float amount) {
		
		float commission = amount * commissionRate;
		balance -= (amount + commission);
	}
	
	public void autoUpdateAccounts() {
		
		for (Account account : accounts) {
			
			float accountBalance = account.getBalance();
			float newBalance = accountBalance + (accountBalance * interestRate);
			account.setBalance(newBalance);
			
			Log log = new Log(System.currentTimeMillis(), id, "Update account " + account.getId() + " according to interest rate of " + interestRate + "%", newBalance);
			logger.log(log);
		}
	}
	
	public float getFortune() {
		
		float fortune = balance;
		
		for (Account account : accounts) {
			fortune += account.getBalance();
		}
		
		return fortune;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}
}
