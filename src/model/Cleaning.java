package model;

public class Cleaning extends Product {
    private int riskLevel;

    public Cleaning() {
    }

    public Cleaning(int id, String name, double price, int amount, int riskLevel) {
        super(id, name, price, amount);
        this.riskLevel = riskLevel;
    }

    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | Risk level (1-10): " + this.riskLevel);
        System.out.println("| Amount : " + this.amount);
        System.out.println("---------------------------------");
    }

}
