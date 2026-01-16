package ph.com.bpi.oop.m4_activity5;

public class AccountValidator {
	
	public static String validateAccountNumber(String accountNumber)
            throws InvalidAccountNumberException {

        // 1. Check for null
        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null");
        }

        // 2. Check for format (only digits)
        for (char c : accountNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidAccountFormatException("Account number must contain only digits");
            }
        }

        // 3. Check length
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
        }

        // 4. If valid
        return "Valid account number: " + accountNumber;
    }

	public static void testValidation(String testName, String accountNumber) {
        System.out.println("Test " + testName + ":" + " (" + accountNumber + ")");

        try {
            String result = validateAccountNumber(accountNumber);
            System.out.println("Valid account: " + accountNumber);
            System.out.println(result);
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAccountFormatException e) {
            System.out.println("Warning: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        System.out.println();
    }
}
