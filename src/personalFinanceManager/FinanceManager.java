package personalFinanceManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FinanceManager {
	private ArrayList<Transaction>transactions;
	private double totalIncome;
	private double totalExpense;
	private double budget;
	private Scanner scanner;
	
	
	public FinanceManager() {
		transactions = new ArrayList<Transaction>();
		scanner = new Scanner(System.in);
		
		
	}
	
//	Add income
	public void addIncome() {
		int incomeTransactionIdCounter = 100;
		double amount;
		while(true) {
			try {
				System.out.println("Enter the income's amount");
				amount = Integer.parseInt(scanner.nextLine());
				break;
			}catch(NumberFormatException e) {
				System.out.println("INVALID INPUT!! Please Enter a numeric Id.");
			}
		}
		
		
		System.out.println("Enter the Source of Income");
		String categoryOrSource = scanner.nextLine();
		String type = "Income";
		String date = getCurrentDate();
		String id = "IN" + incomeTransactionIdCounter++;
		
//		create an Income transaction
		Transaction transaction = new Transaction(id, amount, type, categoryOrSource, date);
		transactions.add(transaction);
		System.out.println(transaction.toString());

		
//		add income to the total income
		totalIncome += amount;
		
		
	}
//	Add an expense
	public void addExpense() {
		int expenseTransactionIdCounter = 200;
		double amount;
		while(true) {
			try {
				System.out.println("Enter the amount of the expense");
				amount = Integer.parseInt(scanner.nextLine());
				break;
			}catch(NumberFormatException e) {
				System.out.println("INVALID INPUT!! Please Enter a numeric Id.");
			}
		}
		
		System.out.println("Enter the expense category");
		String categoryOrSource = scanner.nextLine();
		String type = "Expense";
		String date = getCurrentDate();
		String id = "EXP" + expenseTransactionIdCounter++;
		
//		Create an expense transation
		Transaction transaction = new Transaction(id, amount, type, categoryOrSource, date);
		transactions.add(transaction);
		System.out.println(transaction.toString());
		
//		Add expense to total expense
		totalExpense += amount;
	}
	
	
	public void setBudget() {
		
		System.out.println("Enter the Food Expense: ");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter the Transport Expense");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter the Clothing Expense: ");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter the friends and family Expense: ");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter the Saving Expense: ");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter the Bills Expense: ");
		budget += Integer.parseInt(scanner.nextLine());
		System.out.println("Budget set to: " + budget);
		
		}
	
	public void viewSummary() {
		double balance = totalIncome - totalExpense;
		System.out.println("Total Income: " + totalIncome);
	    System.out.println("Total Expenses: " + totalExpense);
	    System.out.println("Remaining Balance: " + balance);
	    
	    while(isValidAmount(budget)) {
	    	if (balance > budget) {
	            System.out.println("You are within budget.");
	        } else {
	            System.out.println("Warning: Budget exceeded!");
	        }
	    	break;
	    }
	    
	    
	}
	
	public void listTransaction() {
		if(transactions.isEmpty()) {
			System.out.println("No transaction avaliable!");
		}else {
			for (Transaction transaction : transactions) {
				System.out.println(transaction);
			}
		}
	}
	
//	set up date
	private String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(new Date());
		}
//	To check if budget is set
	public static boolean isValidAmount(double budget) {return budget > 0;}
	
//	public access to scanner
	public Scanner getScanner() {return scanner; }
	
	
//	To close the scanner
	public void closedScanner() { 
		scanner.close();
	}

}
