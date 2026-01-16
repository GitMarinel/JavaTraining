package ph.com.bpi.oop.m4_activity2;

public class ATMSystem {
    public static double[] accounts = {10000, 15000, 20000};

    public static void processWithdrawal(String accountIndex, String amountInput) {
        System.out.println("Account=" + accountIndex + ", Amount=" + amountInput);

        try {
        	
        
            int index = Integer.parseInt(accountIndex);          
            double amount = Double.parseDouble(amountInput);     

            double currentBalance = accounts[index];

            System.out.printf("Current balance: P%.2f%n", currentBalance);
            System.out.printf("Withdrawal: P%.2f%n", amount);

            if (amount > currentBalance) {
                System.out.printf("Insufficient funds! Cannot withdraw P%.2f%n", amount);
                return;
            }

            double newBalance = currentBalance - amount;
            accounts[index] = newBalance;

            System.out.printf("New balance: P%.2f%n", newBalance);
            System.out.println("Withdrawal successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");
        } catch (Exception e) {
            // Catch-all for any other unexpected errors
            System.out.println("Error: Transaction failed!");
            System.out.println("Please try again later.");
        }
    }
}
