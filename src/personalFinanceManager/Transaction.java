package personalFinanceManager;


public class Transaction {
	private String id;
	private double amount;
	private String type;
	private String categoryOrSource;
	private String date;
	
//	constructor to initialise Transaction
	public Transaction (String id, double amount, String type, String categoryOrSource, String date) {
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.categoryOrSource = categoryOrSource;
		this.date = date;
		
	}
	
//	getters
	public String getId() {return id;}
	public double getAmount() {return amount;}
	public String getType() {return type;}
	public String getCategoryOrSource() {return categoryOrSource;}
	public String getDate() {return date;}
	
	
	
//	Converts a Transaction object into a human-readable string for display.
	public String toString() {
		return "ID: " + id + ", Type: " + type + ", Amount: sh." + amount + ", Category/Source: " + categoryOrSource + ", Date: " + date;
	}

//	To check if money is available for transaction
	public static boolean isValidAmount(double amount) {return amount > 0;}
	
}

