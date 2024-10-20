import models.Grocery;
import services.Groceryservices;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Groceryservices groceryService = new Groceryservices();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Grocery Management System");
            System.out.println("1. Add Grocery");
            System.out.println("2. View All Groceries");
            System.out.println("3. Update Grocery");
            System.out.println("4. Delete Grocery");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Product name:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter price:");
                    int price = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter brand:");
                    String brand = scanner.nextLine();
                    System.out.println("Enter expiry date (YYYY-MM-DD):");
                    
                    
                    String expiry_date = scanner.nextLine();
                    System.out.println("Grocery added!");

                    Grocery grocery = new Grocery(productName, price, brand, expiry_date);
                    groceryService.addGrocery(grocery);
                    break;

                case 2:
                    List<Grocery> groceries = groceryService.getAllGrocerys();
                    for (Grocery s : groceries) {
                        System.out.println(s.getId() + ". " + s.getProductName() + " - " + s.getExpiry_date());
                    }
                    break;

                case 3:
                    System.out.println("Enter grocery ID to update:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter new product name:");
                    String newProductName = scanner.nextLine();
                    System.out.println("Enter new price:");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter new brand:");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter new expiry date (YYYY-MM-DD):");
                   
                  
                    String newExpiry_Date = scanner.nextLine();
                    System.out.println("item updated!");

                    Grocery updateGrocery = new Grocery(newProductName, newPrice, newBrand, newExpiry_Date);
                    updateGrocery.setId(updateId);
                    groceryService.updateGrocery(updateGrocery);
                    break;

                case 4:
                    System.out.println("Enter grocery ID to delete:");
                    int deleteId = scanner.nextInt();
                    groceryService.deleteGrocery(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
