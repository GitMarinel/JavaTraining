package ph.com.bpi.oop.m3_activity1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// initialize scanner
		Scanner scn = new Scanner(System.in);
		
		//Creating array list and adding product name
		ArrayList<String> list = new ArrayList<String>();
		list.add("Laptop");
		list.add("Mouse");
		list.add("Keyboard");
		list.add("Monitor");
		list.add("Printer");
		
		//Display All Products
		System.out.println("All products");
		for(int x = 0; x <= 4; x++) {
			System.out.println((x+1) + ". " + list.get(x));
		}
		System.out.println("");
		
		//Adding and removing a product
		list.remove(1);
		list.add("Webcam");
		
		System.out.println("After adding and removing products");
		for(int x = 0; x <= 4; x++) {
			System.out.println((x+1) + ". " + list.get(x));
		}
		System.out.print("Enter product name to search: ");
		String product = scn.next();
		
		
		//Checking if the searched product is existing on the list
		if(list.contains(product)) {
			System.out.print("Product found: " + product);
		}
		else {
			System.out.print("Product not found: ");
		}
		scn.close();
	}
	

}
