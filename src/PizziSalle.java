import java.util.List;
import java.util.Random;

/**
 * PATTERN: Singleton
 *
 */
public class PizziSalle {
    private static final List<String> pizziSalleDelegations = List.of("PizziSalle Barcelona", "PizziSalle Lleida", "PizziSalle Tarragona", "PizziSalle Girona");
    private String name;
    private List<Pizza> menu;
    private static PizziSalle instance;

    public PizziSalle(String name) {
        this.name = name;

        //TODO: Load menu
        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.getAllPizzas();
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
}
