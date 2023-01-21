import java.util.Collections;
import java.util.List;

/**
 * PATTERN: Builder
 * The Builder pattern is useful for the OrderBuilder class because it allows orders to be added in a flexible way. I
 *
 * By using the Builder pattern, you can keep the logic of creating the orders within the
 * OrderBuilder class, which is responsible for building orders, and you can keep the Order class simple, without the
 * need to include logic for drinking age and others maybe in a future.
 */
public class OrderBuilder {
    private Order order;
    private Customer customer;

    public OrderBuilder() {
        order = new Order();
    }

    public void addPizza(Pizza pizza) {
        order.setPizza(pizza);
    }

    public void addDrink(int drink) {
        switch (drink){
            case 1:
                order.setDrink("Water");
                break;
            case 2:
                order.setDrink("Soda");
                break;
            case 3:
                if (customer.getAge() < 18) {
                    System.out.println("Nope, you're too young to have a beer, I'm giving you water.");
                    order.setDrink("Water");
                }
                else order.setDrink("Beer");
                break;
        }
    }

    public Order build() {
        return order;
    }

    public void addCustomer(Customer customer) {
        order.setCustomer(customer);
        this.customer = customer;
    }
}
