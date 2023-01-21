import javax.print.DocFlavor;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Order {
    private Customer customer;
    private Pizza pizza;
    private String drink;

    public Order() {}

    public void notifyCustomer() {
        System.out.println("Here's your order:");
        System.out.println("Order for: " + customer.toString());
        System.out.println("Pizza: " + pizza.toString());
        System.out.println("Drink: " + drink);

        System.out.println("Thank you for eating at PizziSalle " + customer.getDelegation() + ". Come back soon!");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
