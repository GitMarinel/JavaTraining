
package ph.com.bpi.oop.m3_activity2;

import java.util.Scanner;
import java.util.HashSet;

public class Main {
    private static int choice;
    static Scanner scn = new Scanner(System.in);
    static HashSet<String> products = new HashSet<>();

    public static void main(String[] args) {
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        do {
            choice = menu(); // read choice safely

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

    // MENU
    public static int menu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Search a product");
        System.out.println("2. Add product");
        System.out.println("3. Print all products and count");
        System.out.println("4. Exit");
        System.out.print("> ");

        String line = scn.nextLine().trim();

        if (line.isEmpty()) return 0;

        // parse integer safely
        try {
            int c = Integer.parseInt(line);
            return c;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void choice1() {
        System.out.print("Enter product name to search: ");
        String name = scn.nextLine().trim(); // <-- use nextLine()

        if (products.contains(name)) {
            System.out.println("Product found: " + name + "\n");
        } else {
            System.out.println("Product not found: " + name + "\n");
        }
    }

    public static void choice2() {
        System.out.print("Enter product name to add: ");
        String name = scn.nextLine().trim(); // <-- use nextLine()

        if (!products.contains(name)) {
            products.add(name);
            System.out.println("Product added: " + name + "\n");
        } else {
            System.out.println("Product not added: " + name + " (already exists)\n");
        }
    }

    public static void choice3() {
        System.out.println("All products:");
        for (String name : products) {
            System.out.println(name);
        }
        System.out.println("Total unique products: " + products.size() + "\n");
    }
}
