package ph.com.bpi.oop.Exercise1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner scn = new Scanner(System.in);
			
		//Get User input
		System.out.print("Enter brand for car1: ");
		String brand = scn.nextLine();
		System.out.print("Enter color for car1: ");
		String color = scn.nextLine();
		System.out.println("");
		
		//Setting details for Car1
		Car car1 = new Car(brand, color, 2);
		//Show the Details for Car1
		car1.Show();
		Car car2 = new Car();
		System.out.println("");
		//Show the Details for Car2
		car2.Show();
				
		scn.close();
	}

}
