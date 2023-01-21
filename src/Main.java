import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizziSalle store = PizziSalle.getInstance();
        OrderBuilder orderBuilder = new OrderBuilder();

        // Prompt the user for their name, phone, and delivery address
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phone = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your delivery address:");
        String address = scanner.nextLine();
        System.out.println("Is this your first order? (yes/no)");
        String firstOrder = scanner.nextLine();

        System.out.println("Welcome to PizziSalle " + store.getName() + "!");
        orderBuilder.addCustomer(new Customer(name, phone, age, address,
                firstOrder.equalsIgnoreCase("yes"), store.getName()));

        // Prompt the user for the pizza they want to order
        System.out.println("What type of pizza would you like to order? (Enter the number) ");
        for (int i = 0; i < store.getMenu().size(); i++) {
            System.out.println(i + ": " + store.getMenu().get(i).getName());
        }
        int pizzaIndex = scanner.nextInt();
        scanner.nextLine();
        PizzaBuilder pizzaBuilder = new PizzaBuilder(store.getMenu().get(pizzaIndex));
        orderBuilder.addPizza(pizzaBuilder.build());

        // Prompt the user for any extra ingredients or modifications
        System.out.println("Would you like to add any extra ingredients or add to the quantity of an ingredient? (yes/no)");
        String addIngredient = scanner.nextLine();
        while (addIngredient.equalsIgnoreCase("yes")){
            // Print out ingredient list
            for (int i = 0; i < store.getIngredientsMenu().size(); i++) {
                System.out.println(i + ": " + store.getIngredientsMenu().get(i));
            }
            // Prompt the user for the extra ingredients or modifications
            System.out.println("Enter the extra ingredient or modification: (Enter the number)");
            int ingredientIndex = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many more "+ store.getIngredientsMenu().get(ingredientIndex ) +" would you like: (Enter the number, Max. 10)");
            int ingredientAmount = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < ingredientAmount; i++) {
                pizzaBuilder.addIngredient(store.getIngredientsMenu().get(ingredientIndex));
            }

            System.out.println("Would you like to add any extra ingredients or add to the quantity of an ingredient? (yes/no)");
            addIngredient = scanner.nextLine();
        }

        // Prompt the user for the type of crust and drink they want
        System.out.println("What type of crust would you like? (Enter the number)");
        System.out.println("1: Original");
        System.out.println("2: Thin");
        System.out.println("3: Sicilian");
        int crust = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        pizzaBuilder.setCrust(crust);

        System.out.println("What type of drink would you like? (Enter the number)");
        System.out.println("1: Water");
        System.out.println("2: Soda");
        System.out.println("3: Beer");
        int drink = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        orderBuilder.addDrink(drink);

        // Create the order
        Order order = orderBuilder.build();

        // Notify the customer that their order is ready
        order.notifyCustomer();
    }
}