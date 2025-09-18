package model;

import interfaces.IProduct;

public class Utensils extends Product implements IProduct {
    private String guarantee;

    public Utensils() {
    }

    public Utensils(int id, String name, double price, int quantity, String guarantee) {
        super(id, name, price, quantity);
        this.guarantee = guarantee;
    }

    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | guarantee: " + this.guarantee);
        System.out.println("| quantity : " + this.quantity);
        System.out.println("---------------------------------");
    }

    @Override
    public String csvDescriptionProduct() {
        return  (this.id + "," + this.name + "," + this.price + "," + quantity + "," + "Utensils" + "," + this.guarantee);
    }
}
