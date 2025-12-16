package ph.com.bpi.oop.m3_activity2;

import java.util.Scanner;
import java.util.HashSet;

public class Main {
	private static int choice;
	static Scanner scn = new Scanner(System.in);
	static HashSet <String> products = new HashSet<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
		
		do {
		       choice = menu(); // read choice safely
		            
		       // Handle choices
		       switch (choice) {
		             case 1:
		                	choice1();
		                    break;
		             case 2:
		                    choice2();
		                    break;
		             case 3:
		                    choice3();
		                    break;
		             case 4:
		                	System.out.println("Exit");
		                    break;
		             default:
		                    System.out.println("Invalid input\n");
		                    break;
		       }

		 } while (choice != 4);

		
		 scn.close();
	}
	
	//MENU
	public static int menu() {
		System.out.println("===== MENU =====");
        System.out.println("1. Search a product");
        System.out.println("2. Add product");
        System.out.println("3. Print all products and count");
        System.out.println("4. Exit");
        System.out.print("> ");

        String line = scn.next().trim();
        
        
        //Input Checker
        if(line.isEmpty()) {
        	return 0;
        }
        else if (line.equals("1")){
        	choice = Integer.parseInt(line);
        	return choice;
        }
        else if (line.equals("2")){
        	choice = Integer.parseInt(line);
        	return choice;
        }
        else if (line.equals("3")){
        	choice = Integer.parseInt(line);
        	return choice;
        }
        else if (line.equals("4")){
        	choice = Integer.parseInt(line);
        	return choice;
        }
        else {
        	return 0;
        }
	}
	public static void choice1() {
		System.out.print("Enter product name to search: ");
		String name = scn.next();
		
		//Search process if a product exist
		if(products.contains(name)) {
			System.out.println("Product found: " + name);
			System.out.println("");
		}
		else {
			System.out.println("Product not found: ");
			System.out.println("");
		}
	}
	public static void choice2() {
		System.out.print("Enter product name to add: ");
		String name = scn.next();
		
		//Checking if product already exist if not add it to the list
		if(!(products.contains(name))) {
			products.add(name);
			System.out.println("Product added: " + name);
			System.out.println("");
		}
		else {
			System.out.println("Product not added: ");
			System.out.println("");
		}
	}
	public static void choice3() {
		System.out.println("All products: ");
		//Displays all the products and the total count
		for(String name: products) {
			System.out.println(name);
		}
		System.out.println("Total unique products " + products.size());
	}
	

}
