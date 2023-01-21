import java.util.Collections;
import java.util.List;

/**
 * PATTERN: Prototype Builder
 * The Prototype Builder pattern is useful for the PizzaBuilder class because it allows pizzas to be added with extra
 * Ingredients in a flexible way. It is not strictly a builder class as it takes a prototype as a starting point, even
 * though the logic and implementation is the same.
 *
 * By using the Prototype Builder pattern, you can keep the logic of creating the pizzas within the
 * PizzaBuilder class, which is responsible for building and modifying the pizzas, and you can keep the Pizza class
 * simple, without the need to include logic for adding and removing ingredients. Also, this pattern allows for greater
 * flexibility in creating new types of pizzas, as you can use a pre-existing Pizza object as a starting point, and
 * then make small modifications to it.
 */
public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder(Pizza prototype) {
        pizza = prototype.clone();
    }

    public void addIngredient(String ingredient) {
        List<String> ingredients = pizza.getIngredients();
        int count = Collections.frequency(ingredients, ingredient);
        if (count < 10) {
            pizza.addIngredient(ingredient);
        }
        else System.out.println("Maximum number of " + ingredient + " added.");
    }

    public void setCrust(int crust) {
        switch (crust){
            case 1:
                pizza.setCrust("Original");
                break;
            case 2:
                pizza.setCrust("Thin");
                break;
            case 3:
                pizza.setCrust("Sicilian");
                break;
        }
    }

    public Pizza build() {
        return pizza;
    }
}
