package model;

public class Food extends Product{
    private String expirationDate;

    public Food() {
    }

    public Food(int id, String name, double price, int amount, String expirationDate) {
        super(id, name, price, amount);
        this.expirationDate = expirationDate;
    }


    @Override
    public void description() {
        System.out.println("---------------------------------");
        System.out.println("| ID : " + this.id);
        System.out.println("| Name : " + this.name);
        System.out.println("| Price: " + this.price + " | Expiration date: " + this.expirationDate);
        System.out.println("| Amount : " + this.amount);
        System.out.println("---------------------------------");
    }
}
