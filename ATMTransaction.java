package ph.com.bpi.oop.m4_activity3;

public class ATMTransaction {

	public static void checkBalance(String accountNumber, double balance) {
        System.out.println("Processing balance inquiry...");

        try {
            char accountTypeChar = accountNumber.charAt(0);

            Integer.parseInt(accountNumber);

            String accountTypeName;
            if (accountTypeChar == '1') {
                accountTypeName = "Savings";
            } else if (accountTypeChar == '2') {
                accountTypeName = "Checking";
            } else {
                accountTypeName = "Unknown";
            }

            System.out.println("Account Type: " + accountTypeName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println(String.format("Current Balance: P%.1f", balance));
            System.out.println("Balance inquiry successful!!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account number is empty or invalid!");
        } finally {
            System.out.println("\n========== RECEIPT ==========");
            System.out.println("Transaction Date: December 3, 2025");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("=============================\n");
        }
	}
}
