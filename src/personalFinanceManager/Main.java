package personalFinanceManager;

public class Main {

	public static void main(String[] args) {
		FinanceManager financeManager = new	FinanceManager();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n--- Personal Finance Manager ---");
		    System.out.println("1. Add Income");
		    System.out.println("2. Add Expense");
		    System.out.println("3. Set Budget");
		    System.out.println("4. View Summary");
		    System.out.println("5. View Transactions");
		    System.out.println("6. Exit");
		    
		    
		    try {
		    	int choice = Integer.parseInt(financeManager.getScanner().nextLine());
		    	
		    	
		    	switch (choice){
		    		case 1 -> financeManager.addIncome();
		    		case 2 -> financeManager.addExpense();
		    		case 3 -> financeManager.setBudget();
		    		case 4 -> financeManager.viewSummary();
		    		case 5 -> financeManager.listTransaction();
		    		case 6 -> {		    	
						exit = true;
						financeManager.closedScanner();
						System.out.println("GoodBye");
		    		}
		    	}
		    }catch(NumberFormatException e ) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
		

	}

}
