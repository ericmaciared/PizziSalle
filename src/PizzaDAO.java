import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

// Data Access Object (DAO) class
/**
 * PATTERN: Adapter
 * Used to adapt the Pizza class and its methods to the SQLite database.
 * The PizzaDAO class is an adapter class that connects the Pizza class and its methods to the SQLite database,
 * so that the Pizza class does not need to know anything about the database. This allows to change the underlying
 * database technology without affecting the Pizza class.
 * The PizzaDAO class provides an abstraction layer between the Pizza class and the SQLite database, allowing the
 * Pizza class to interact with the database through a simplified interface. This simplifies the code of the Pizza
 * class and makes it more reusable, as it does not need to be tied to a specific database technology.
 * Additionally, The PizzaDAO class can also handle database-specific operations such as opening and closing
 * connections, handling transactions, and executing SQL statements. This way the Pizza class can focus on its main
 * responsibility which is to handle the logic of a Pizza structure.
 * By using the Adapter pattern, you can separate the concerns of the business logic and the data access logic in your
 * program, which makes it more maintainable, testable and flexible.
 */
public class PizzaDAO {
    // Database connection
    private Connection connection;

    public PizzaDAO() {
        // Initialize the database connection
        connection = getConnection();
        //initializeTables(); // Run this to set the relation table between ingredients and pizza
    }

    private void initializeTables() {
        try {
            Scanner scanner = new Scanner(new File("src/pizzas.txt"));

            while (scanner.hasNext()) {
                List<String> line = List.of(scanner.nextLine().split("[:,]"));
                String pizza = line.get(0);
                String pizzaIdQuery = "SELECT id from pizza WHERE name = '" + pizza + "'";

                // Add base two elements for every pizza
                StringBuilder query = new StringBuilder("INSERT INTO pizza_ingredients (pizza_id, ingredient_id) " +
                        "VALUES ((" + pizzaIdQuery + "), (SELECT id FROM ingredient WHERE name = 'Cheese')), " +
                        "((" + pizzaIdQuery + "), (SELECT id FROM ingredient WHERE name = 'Tomato Sauce'))");

                for (String ingredient: line.subList(1, line.size())) {
                    query.append(",((").append(pizzaIdQuery).append("), (SELECT id FROM ingredient WHERE name = '").append(ingredient).append("'))");
                }

                query.append(";");
                // Execute the insert query
                try {
                    Statement statement = connection.createStatement();
                    System.out.println(query.toString());
                    statement.executeUpdate(query.toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Pizza> getAllPizzas(String name) {
        List<Pizza> pizzas = new ArrayList<>();

        // Execute the query to retrieve all pizzas from the database
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM pizza WHERE exclusive = '" + name +"' OR exclusive IS NULL;")) {
            ResultSet resultSet = statement.executeQuery();
            // Convert the data from the database into Pizza objects
            while (resultSet.next()) {
                String pizzaName = resultSet.getString("name");
                Pizza current = new Pizza(pizzaName);
                // Add pizza ingredients
                current.setIngredients(getPizzaIngredients(pizzaName));
                pizzas.add(current);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizzas;
    }


    public List<String> getAllIngredients() {
        List<String> ingredients = new ArrayList<>();

        // Execute the query to retrieve all pizzas from the database
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM ingredient;")) {
            ResultSet resultSet = statement.executeQuery();
            // Convert the data from the database into Pizza objects
            while (resultSet.next()) {
                String ingredientName = resultSet.getString("name");
                // Add ingredients
                ingredients.add(ingredientName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public List<String> getPizzaIngredients(String pizza) {
        List<String> ingredients = new ArrayList<>();

        // Execute the query to retrieve all pizzas from the database
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT i.name from ingredient as i, pizza as p, pizza_ingredients as pi" +
                        "              WHERE p.name = '"+pizza+"' AND pi.pizza_id = p.id AND pi.ingredient_id = i.id;")) {
            ResultSet resultSet = statement.executeQuery();
            // Convert the data from the database into Pizza objects
            while (resultSet.next()) {
                ingredients.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private Connection getConnection() {
        // Code to get a connection to the database
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Specify the path to the SQLite database file
            String url = "jdbc:sqlite:pizza.sqlite";

            // Open a connection to the database
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
