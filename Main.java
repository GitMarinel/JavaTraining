package ph.com.bpi.oop.m4_activity5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("=== Account Number Validation Test ===\n");

        // Test cases
        AccountValidator.testValidation("1: Valid account", "1234567890");
        AccountValidator.testValidation("2: Too short", "123");
        AccountValidator.testValidation("3: Contains letters", "12345ABC90");
        AccountValidator.testValidation("4: Contains space", "1234 567890");
        AccountValidator.testValidation("5: Null value", null);
	}

}
