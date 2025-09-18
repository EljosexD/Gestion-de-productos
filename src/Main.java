import model.Cleaning;
import model.Food;
import model.Product;
import model.Utensils;
import persistence.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository file = new ProductRepository();
        int id, quantity, option,riskLeve,searchId;
        String name,guarantee,expiration,searchName;
        boolean found;
        double price;
        Scanner answer = new Scanner(System.in);
        List<Product> listProduct = new ArrayList<>();
        System.out.println("+--------------------------------+");
        System.out.println("|            Hi User!            |");
        System.out.println("+--------------------------------+");
        file.CreateFile();
        if (file.verifFile()){
            System.out.println("Uploading a product...");
            listProduct = file.downloadProductFile();
            System.out.println("Upload completed");
        }
        do {
            found = false;
            System.out.println("+--------------------------------+");
            System.out.println("|      Product Management        |");
            System.out.println("+--------------------------------+");
            System.out.println("|  1. Create product             |");
            System.out.println("|  2. View products              |");
            System.out.println("|  3. Update product             |");
            System.out.println("|  0. Back to main menu          |");
            System.out.println("+--------------------------------+");
            System.out.print("Choose an option: ");
            option = answer.nextInt();
            answer.nextLine();
            switch (option) {
                case 1:
                    System.out.println("+------------------------------------------------+");
                    System.out.println("|      Choose the product you want to add        |");
                    System.out.println("+------------------------------------------------+");
                    System.out.println("|   (1)Food    (2)Cleaning     (3)Utensils       |");
                    System.out.println("+------------------------------------------------+");
                    option = answer.nextInt();
                    answer.nextLine();
                    switch (option){
                        case 1:
                            System.out.print("Enter ID: ");
                            id = answer.nextInt();
                            answer.nextLine();
                            System.out.print("Enter name: ");
                            name = answer.nextLine();
                            System.out.print("Enter price: ");
                            price = answer.nextDouble();
                            System.out.print("Enter quantity: ");
                            quantity = answer.nextInt();
                            answer.nextLine();
                            System.out.print("Enter expiration date: ");
                            expiration = answer.nextLine();
                            Food productFood = new Food(id,name,price,quantity,expiration);
                            listProduct.add(productFood);
                            break;
                        case 2:
                            System.out.print("Enter ID: ");
                            id = answer.nextInt();
                            answer.nextLine();
                            System.out.print("Enter name: ");
                            name = answer.nextLine();
                            System.out.print("Enter price: ");
                            price = answer.nextDouble();
                            System.out.print("Enter quantity: ");
                            quantity = answer.nextInt();
                            System.out.print("Enter riskLeve date: ");
                            riskLeve = answer.nextInt();
                            answer.nextLine();
                            Cleaning productCleaning= new Cleaning(id,name,price,quantity,riskLeve);
                            listProduct.add(productCleaning);
                            break;
                        case 3:
                            System.out.print("Enter ID: ");
                            id = answer.nextInt();
                            answer.nextLine();
                            System.out.print("Enter name: ");
                            name = answer.nextLine();
                            System.out.print("Enter price: ");
                            price = answer.nextDouble();
                            System.out.print("Enter quantity: ");
                            quantity = answer.nextInt();
                            answer.nextLine();
                            System.out.print("Enter guarantee date: ");
                            guarantee = answer.nextLine();
                            Utensils productUtensils= new Utensils(id,name,price,quantity,guarantee);
                            listProduct.add(productUtensils);
                            break;
                        default:
                    }
                    break;
                case 2:
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                     Choose an option below                     |");
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|   (1) Search by ID    (2) Search by Name    (3) Show All       |");
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.print("Choose an option: ");
                    option = answer.nextInt();
                    answer.nextLine();
                    switch (option){
                        case 1:
                            System.out.println("Insert by ID");
                            searchId = answer.nextInt();
                            answer.nextLine();
                            for (Product p : listProduct) {
                                if (p.getId() == searchId){
                                    p.description();
                                    found = true;
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("product not find");
                            }
                            break;
                        case 2:
                            System.out.println("Insert by Name");
                            searchName = answer.nextLine();
                            for (Product p : listProduct) {
                                if (p.getName().equalsIgnoreCase(searchName)){
                                    p.description();
                                    found = true;
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("product not find");
                            }
                            break;
                        case 3:
                            System.out.println("Viewing all products...");
                            for (Product p : listProduct) {
                                p.description();
                            }
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;
                case 3:
                    System.out.println("Updating a product...");
                        file.uploadWriteFile(listProduct);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
        System.out.println("Goodbye!");
        answer.close();
    }
}