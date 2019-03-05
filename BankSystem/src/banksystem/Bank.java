package banksystem;

import banksystem.clients.Client;
import banksystem.log.Log;
import banksystem.log.Logger;
import banksystem.utils.ArraysHelper;

public class Bank {
	
	//private Client[] clients;
	private ArrayList<Client> clients;
	private float balance;
	private Logger logService;
	
	public Bank() {
		//clients = new Client[100];
		clients = new ArrayList<>();
		logService = new Logger("");
	}
	
	public void getBalance() {
		if (INSTANCE == null) {
			INSTANCE = new Bank();
		}
		return INSTANCE;
	}
	
	public static void addCommission(float commission) {
		commission += commission;
	}
	
	public float setBalance() {
		float newBalance = 0;
		for (Client client : clients) {
			newBalance += client.getFortune();
		}
		this.balance = newBalance;
		return balance;
	}
	
	public void addClient(Client client) {
		clients.add(client);
		setBalance();
	}
	
	/*public void addClient(Client client) {
		int index = ArraysHelper.getNextEmptyArrayIndex(clients);
		clients[index] = client;
		setBalance();
	}
	*/
	/*
	public void removeClient(int id) {
		
		Client clientToRemove = null;
		int clientToRemoveIndex = -1;
		
		for (int i=0; i<clients.length; i++) {
			if (clients[i].getId() == id) {
				clientToRemove = clients[i];
				clientToRemoveIndex = i;
				break;
			}
		}
		*/
		
		Log log = new Log(System.currentTimeMillis(), id, "Remove client " + id + " from bank", clientToRemove.getFortune());
		logService.log(log);
		
		clients[clientToRemoveIndex] = null;
		
		setBalance();
	}

	public Client[] getClients() {
		return clients;
	}
	
	public void viewLogs() {
	}
	
	public void startAccountUpdater() {
	}
}
