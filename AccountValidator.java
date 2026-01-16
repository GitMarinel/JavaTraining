package ph.com.bpi.oop.m4_activity4;

public class AccountValidator {

	public static void validateAccountNumber(String accountNumber) throws Exception {
        if (accountNumber == null) {
            throw new NullPointerException("Cannot be null");
        }

        if (accountNumber.length() != 10) {
            throw new Exception("Must be 10 digits");
        }

        System.out.println("Valid account: " + accountNumber);
    }
	
	public static void validate(String accountNumber) {
        try {
            validateAccountNumber(accountNumber);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
