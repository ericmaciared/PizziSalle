import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizziSalle store = PizziSalle.getInstance();

        /*
        // Prompt the user for their name, phone, and delivery address
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phone = scanner.nextLine();
        System.out.println("Enter your delivery address:");
        String address = scanner.nextLine();
        System.out.println("Is this your first order? (yes/no)");
        String firstOrder = scanner.nextLine();

        Customer customer = new Customer(name, phone, address, firstOrder.equalsIgnoreCase("yes"));

        // Prompt the user for the pizza they want to order
        System.out.println("What type of pizza would you like to order? (Enter the number) ");
        for (int i = 0; i < store.getMenu().size(); i++) {
            System.out.println(i + ": " + store.getMenu().get(i).getName());
        }
        int pizzaIndex = scanner.nextInt();
        scanner.nextLine();
        Pizza pizza = store.getMenu().get(pizzaIndex);

        // Prompt the user for any extra ingredients or modifications
        System.out.println("Would you like to add any extra ingredients or modify the quantity of an ingredient? (yes/no)");
        String addIngredient = scanner.nextLine();
        if (addIngredient.equalsIgnoreCase("yes")) {
            // Use the decorator pattern to add extra ingredients or modify the quantity of an ingredient
            //pizza = new ExtraIngredientDecorator(pizza);
            // Prompt the user for the extra ingredients or modifications
            System.out.println("Enter the extra ingredient or modification:");
            String ingredient = scanner.nextLine();
            pizza.addIngredient(ingredient);
        }

        // Prompt the user for the type of crust and drink they want
        System.out.println("What type of crust would you like? (Enter the number)");
        System.out.println("1: Original");
        System.out.println("2: Thin");
        System.out.println("3: Sicilian");
        int crust = scanner.nextInt();
        pizza.setCrust(crust);
        scanner.nextLine(); // consume newline left-over
        System.out.println("What type of drink would you like? (Enter the number)");
        System.out.println("1: Water");
        System.out.println("2: Soda");
        System.out.println("3: Beer");
        int drink = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        // Create the order
        Order order = new Order(customer, pizza, drink);

        // Store the order in the SQLite database
        order.storeInDatabase();

        // Notify the customer that their order is ready
        order.notifyCustomer();
        */
    }
}