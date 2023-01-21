import java.util.List;

/**
 * PATTERN: Prototype
 * The prototype pattern allows you to create a new object by copying an existing object, rather than creating a new
 * object from scratch. By using a prototype Pizza object as a starting point, the PizzaBuilder class can use its
 * methods to modify the pizza by adding ingredients, changing the crust type, or set other options.
 * This way, you can create new Pizza objects that are similar to an existing Pizza object, and you don't have to
 * create new objects from scratch.
 */
public class Pizza implements Cloneable{
    private String name;
    private String crust;
    private List<String> ingredients;

    public Pizza(String name) {
        this.name = name;
        crust = "Original"; // Default
    }

    public String getName() {
        return this.name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public Pizza clone() {
        try {
            return (Pizza) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + " with a (" + crust + ") crust and ingredients " + ingredients;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }
}
