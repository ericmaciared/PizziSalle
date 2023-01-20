import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Data Access Object (DAO) class
public class PizzaDAO {
    // Database connection
    private Connection connection;

    public PizzaDAO() {
        // Initialize the database connection
        connection = getConnection();
    }

    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();

        // Execute the query to retrieve all pizzas from the database
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM pizza")) {
            ResultSet resultSet = statement.executeQuery();

            // Convert the data from the database into Pizza objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(name);
                // TODO:
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizzas;
    }

    public void insertPizza(Pizza pizza) {
        // Convert the Pizza object into data that can be inserted into the database
        //int id = pizza.getId();
        String name = pizza.getName();

        // Execute the insert query
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO pizza (id, name) VALUES (?, ?)")) {
            //statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //other methods like updatePizza, deletePizza,  and getConnection can be written here

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
