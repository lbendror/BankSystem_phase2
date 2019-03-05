package banksystem.log;

import java.util.ArrayList;

public class Logger {
	private static ArrayList<Log> Logs = new ArrayList<>();
	
	/* private String driverName;
	
	public Logger(String driverName) {
		this.driverName = driverName;
	}
	*/
	
	public void log(Log log) {
		System.out.println(log.getData());
	}
	
	/*public Log[] getLogs() {
		return null;
	}
	*/
	public ArrayList<Log> getLogs() {
		return Logs;
	
}
}