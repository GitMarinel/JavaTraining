package ph.com.bpi.hello;

import java.util.Scanner;

public class Activity_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = scn.nextLine();
		System.out.print("Hello " + name);
		scn.close();
	}

}
