package ph.com.bpi.oop.m4_activity2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== ATM Withdrawal System ===\n");

	    System.out.println("--- Test 1: Valid Withdrawal ---");
	    ATMSystem.processWithdrawal("1", "5000"); 
	    System.out.println();

	    System.out.println("--- Test 2: Invalid Account Index ---");
	    ATMSystem.processWithdrawal("abc", "5000"); 
	    System.out.println();

	    System.out.println("--- Test 3: Account Not Found ---");
	    ATMSystem.processWithdrawal("10", "5000"); 
	    System.out.println();

	    System.out.println("--- Test 4: Insufficient Funds ---");
	    
	    ATMSystem.accounts[1] = 15000;
	    ATMSystem.processWithdrawal("1", "20000"); 
	    System.out.println();

	    System.out.println("=== All tests completed! ===");

	}

}
