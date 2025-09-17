package model;

public class Utensils extends Product{
    private String guarantee;

    public Utensils() {
    }

    public Utensils(int id, String name, double price, int amount, String guarantee) {
        super(id, name, price, amount);
        this.guarantee = guarantee;
    }

    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | guarantee: " + this.guarantee);
        System.out.println("| Amount : " + this.amount);
        System.out.println("---------------------------------");
    }
}
