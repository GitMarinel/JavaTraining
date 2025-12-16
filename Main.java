package ph.com.bpi.oop.m3_activity3;


import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int choice;
	static Scanner scn = new Scanner(System.in);
	static Map <String, Integer> products = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		products.put("Laptop", 50000);
		products.put("Mouse", 500);
		products.put("Keyboard", 1000);
		products.put("Monitor", 7000);
		products.put("Printer", 300);
		
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
		                	choice4();
		                    break;
		             case 5:
		                	System.out.println("Exiting......");
		                    break;
		             default:
		                    System.out.println("Invalid input\n");
		                    break;
		       }

		 } while (choice != 5);

		
		 scn.close();
	}
	
	//MENU
	public static int menu() {
		System.out.println("===== MENU =====");
        System.out.println("1. Search a product");
        System.out.println("2. Add product");
        System.out.println("3. Print all products and count");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
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
        else if (line.equals("5")){
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
		if(products.containsKey(name)) {
			System.out.println("Product found! product price: " + products.get(name));
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
		System.out.print("Enter price: ");
		
		while (!scn.hasNextInt()) {
			
			scn.next();
			System.out.print("Enter price: ");

		 }
		int price = scn.nextInt();
		
		
		
		//Checking if product already exist if not add it to the list
		if(!(products.containsKey(name))) {
			products.put(name, price);
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
		 for (String i : products.keySet()) {
		      System.out.println(i + " - " + products.get(i));
		    }
		
		System.out.println("Total unique products " + products.size());
	}
	
	public static void choice4() {
		String smallestKey = null;
		int smallestValue = Integer.MAX_VALUE;

		for (Map.Entry<String, Integer> entry : products.entrySet()) {
		if (entry.getValue() < smallestValue) {
		smallestValue = entry.getValue();
		smallestKey = entry.getKey();
		}
		}

		System.out.println("Cheapest product: " + smallestKey + " - " + smallestValue);
	}
	

}