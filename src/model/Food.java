package model;

import interfaces.IProduct;

public class Food extends Product implements IProduct {
    private String expirationDate;

    public Food() {
    }

    public Food(int id, String name, double price, int quantity, String expirationDate) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }



    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | Expiration date: " + this.expirationDate);
        System.out.println("| quantity : " + this.quantity);
        System.out.println("---------------------------------");
    }

    @Override
    public String csvDescriptionProduct() {
        return  (this.id + "," + this.name + "," + this.price + "," + quantity + "," + "Food" + "," + this.expirationDate);
    }
}
