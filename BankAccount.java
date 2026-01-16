package ph.com.bpi.oop.m4_activity1;

public class BankAccount {
	

    public static String getAccountName(String accountNumber) {
        if ("ACC-001".equals(accountNumber)) {
            return "Juan Dela Cruz";
        } else if ("ACC-002".equals(accountNumber)) {
            return "Maria Santos";
        } else {
            return null;
        }
    }

	public static void testCase(String accountNumber) {
	    System.out.println("Looking up account: " + accountNumber);
	    
	    try {
	        String name = getAccountName(accountNumber);
	        String upperName = name.toUpperCase();
	        System.out.println("Account holder: " + upperName);
	    } catch (NullPointerException e) {
	        System.out.println("Error: Account not found!");
	    }
	}


}
