package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		int num1 = Integer.parseInt(scn.nextLine());
		System.out.print("Enter first integer: ");
		int num2 = Integer.parseInt(scn.nextLine());
		
		System.out.println("Sum: " + sum(num1, num2));
		System.out.println("Difference: " + difference(num1, num2));
		System.out.println("Product: " + product(num1, num2));
		
		scn.close();
	}
	
	public static int sum(int num1, int num2) {
		int num = num1 + num2;
		
		return num;
	}
	public static int difference(int num1, int num2) {
		int num = num1 - num2;
		
		return num;
	}
	public static int product(int num1, int num2) {
		int num = num1 * num2;
		
		return num;
	}
}
