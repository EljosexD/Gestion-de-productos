package persistence;

import model.Cleaning;
import model.Food;
import model.Product;
import model.Utensils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    File fileVariable = new File("Gestion\\data\\basedate.txt");

    public ProductRepository() {
    }

    public void uploadWriteFile(List<Product> products){
        try {
            FileWriter writer = new FileWriter(fileVariable, false);
            writer.write("Id,Name,Price,Amount,Type,SpecialAttribute\n");
            for (Product p : products) {
                writer.write(p.csvDescriptionProduct() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public ArrayList<Product> downloadProductFile() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader read = new FileReader(fileVariable);
            BufferedReader readReader = new BufferedReader(read);
            String linea;
            while ((linea = readReader.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String name = datos[1];
                double price = Double.parseDouble(datos[2]);
                int amount = Integer.parseInt(datos[3]);
                String type = datos[4];
                String specialAttribute = datos[5];
                Product productFile;
                switch (type) {
                    case "Food":
                        productFile = new Food(id, name, price, amount, specialAttribute);
                        break;
                    case "Cleaning":
                        productFile = new Cleaning(id, name, price, amount, Integer.parseInt(specialAttribute));
                        break;
                    case "Utensil":
                        productFile = new Utensils(id, name, price, amount , specialAttribute);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo desconocido: " + type);
                }
                products.add(productFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    public boolean verifFile(){
        if (this.fileVariable.exists()){
            return true;
        }else {
            return false;
        }
    }
    public void CreateFile() {
        try {
            if (this.fileVariable.createNewFile()){
                FileWriter writer = new FileWriter(fileVariable,true);
                writer.write("Id,Name,Price,Amount,Type,SpecialAttribute\n");
                writer.close();
                System.out.println("Create your databases");
            }else {
                System.out.println("Detected file : " + fileVariable.getName());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
