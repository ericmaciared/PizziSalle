public class Order {
    private Customer customer;
    private Pizza pizza;
    private int drink;

    public Order(Customer customer, Pizza pizza, int drink) {
        this.customer = customer;
        this.pizza = pizza;
        this.drink = drink;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getDrink() {
        return drink;
    }

    public void storeInDatabase() {
        //TODO: Store order in database

    }

    public void notifyCustomer() {
        System.out.println("Order is ready");
    }
}
