import java.util.List;
import java.util.Random;

/**
 * PATTERN: Singleton
 *
 * The Singleton pattern is useful for the PizziSalle class because it ensures that only one instance of the class is
 * created, and it provides a global point of access to that instance.
 *
 * In this case, the PizziSalle class represents the restaurant delegations, and it contains the menu and available
 * ingredients. It makes sense to use the Singleton pattern for this class because you only need one instance of
 * the class to represent the delegation, and you want to make sure that there is only one point of access to
 * the menu and ingredients.
 *
 */
public class PizziSalle {
    private static final List<String> pizziSalleDelegations = List.of("Barcelona", "Lleida", "Tarragona", "Girona");
    private String name;
    private List<Pizza> menu;
    private List<String> ingredients;
    private static PizziSalle instance;

    public PizziSalle(String name) {
        this.name = name;

        // Load menu (runs db queries based on current location)
        PizzaDAO pizzaDAO = new PizzaDAO();
        menu = pizzaDAO.getAllPizzas(name);

        // Load list of available inngredients
        ingredients = pizzaDAO.getAllIngredients();
    }

    public static PizziSalle getInstance() {
        if (instance == null) {
            Random random = new Random();
            instance = new PizziSalle(pizziSalleDelegations.get(random.nextInt(0, pizziSalleDelegations.size())));
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    public List<String> getIngredientsMenu() {
        return ingredients;
    }
}
