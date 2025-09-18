package model;

import interfaces.IProduct;

public class Cleaning extends Product implements IProduct {
    private int riskLevel;

    public Cleaning() {
    }

    public Cleaning(int id, String name, double price, int quantity, int riskLevel) {
        super(id, name, price, quantity);
        this.riskLevel = riskLevel;
    }


    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | Risk level (1-10): " + this.riskLevel);
        System.out.println("| quantity : " + this.quantity);
        System.out.println("---------------------------------");
    }

    @Override
    public String csvDescriptionProduct() {
        return  (this.id + "," + this.name + "," + this.price + "," + quantity + "," + "Cleaning" + "," + this.riskLevel);
    }
}
