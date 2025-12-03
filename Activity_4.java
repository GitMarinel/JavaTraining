package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = Integer.parseInt(scn.nextLine());
		
		if(age <= 17) {
			System.out.print("Minor");
		}
		else if(!(age <= 17) && !(age >= 60) && age >= 18 || age <= 59) {
			System.out.print("Adult");
		}
		else {
			System.out.print("Senior");
		}
		scn.close();
	}

}
