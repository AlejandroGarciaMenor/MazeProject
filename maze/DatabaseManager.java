package maze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/robotdb"; 
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public static List<Robot> loadRobots() {
        List<Robot> robots = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM robots")) {
                System.out.println("Database connection established");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int width = resultSet.getInt("width");
                int length = resultSet.getInt("length");
                int bodyColorInt = resultSet.getInt("bodyColor");
                int headColorInt = resultSet.getInt("headColor");
                int eyeColorInt = resultSet.getInt("eyeColor");
                int armColorInt = resultSet.getInt("armColor");
                int legColorInt = resultSet.getInt("legColor");
                Color bodyColor = new Color(bodyColorInt);
                Color headColor = new Color(headColorInt);
                Color eyeColor = new Color(eyeColorInt);
                Color armColor = new Color(armColorInt);
                Color legColor = new Color(legColorInt);
                String bodyShape = resultSet.getString("bodyShape");
                robots.add(new Robot(id, width, length, bodyColor, headColor, eyeColor, armColor, legColor, bodyShape));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Robots loaded from database: " + robots.size());
        return robots;
    }
}
