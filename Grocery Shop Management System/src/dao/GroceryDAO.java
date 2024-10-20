package dao;

import db.DatabaseConnection;
import models.Grocery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryDAO {

    public void addGrocery(Grocery grocery) {
        String query = "INSERT INTO groceries (productName, price, brand, expiry_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, grocery.getProductName());
            stmt.setInt(2,grocery.getPrice());
            stmt.setString(3,grocery.getBrand());
            stmt.setString(4, grocery.getExpiry_date());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGrocery(Grocery grocery) {
        String query = "UPDATE groceries SET productName=?, price=?, brand=?, expiry_date=? WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

        	 stmt.setString(1, grocery.getProductName());
             stmt.setInt(2,grocery.getPrice());
             stmt.setString(3,grocery.getBrand());
             stmt.setString(4, grocery.getExpiry_date());
            stmt.setInt(5, grocery.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGrocery(int id) {
        String query = "DELETE FROM groceries WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Grocery getGrocery(int id) {
        String query = "SELECT * FROM groceries WHERE id=?";
        Grocery grocery = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                grocery = new Grocery(rs.getString("productName"), rs.getInt("price"),
                                      rs.getString("brand"), rs.getString("expiry_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grocery;
    }

    public List<Grocery> getAllGroceries() {
        String query = "SELECT * FROM groceries";
        List<Grocery> groceries = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	Grocery grocery = new Grocery( rs.getString("productName"),
                        rs.getInt("price"), rs.getString("price"), rs.getString("expiry_date"));
                groceries.add(grocery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groceries;
    }
}
