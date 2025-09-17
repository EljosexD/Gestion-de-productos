package model;

public abstract class Product {
    protected int id;
    protected String name;
    protected double price;
    protected int amount;

    public Product() {
    }

    public Product(int id, String name, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public abstract void description();
}
