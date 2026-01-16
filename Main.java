package ph.com.bpi.oop.m4_activity3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==== ATM BALANCE INQUIRY SYSTEM ====\n");

        System.out.println("--- Test Case 1: Valid Savings Account ---");
        ATMTransaction.checkBalance("100123456", 15000.00);

        System.out.println("--- Test Case 2: Valid Checking Account ---");
        ATMTransaction.checkBalance("200987654", 25000.00);

        System.out.println("--- Test Case 3: Invalid Account Number Format ---");
        ATMTransaction.checkBalance("ABC12345", 15000.00);

        System.out.println("--- Test Case 4: Empty Account Number ---");
        ATMTransaction.checkBalance("", 15000.00);

	}

}
