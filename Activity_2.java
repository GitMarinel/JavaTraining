package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("What is your age? ");
		String age = scn.nextLine();
		int intAge = Integer.parseInt(age);
		double doubleAge = intAge;
		System.out.println("Your age as int: " + intAge);
		System.out.println("Your age as double: " + doubleAge);
		scn.close();
	}

}
