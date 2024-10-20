import models.Grocery;
import services.Groceryservices;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GroceryManagementGUI {
    private Groceryservices groceryService = new Groceryservices();
    private JFrame frame;
    private JTextField nameField, priceField, brandField, expiryDateField, idField;
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public GroceryManagementGUI() {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GroceryManagementGUI window = new GroceryManagementGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame("Grocery Management System");
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Product Name:");
        lblName.setBounds(20, 20, 100, 30);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(130, 20, 200, 30);
        frame.getContentPane().add(nameField);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 60, 100, 30);
        frame.getContentPane().add(lblPrice);

        priceField = new JTextField();
        priceField.setBounds(130, 60, 200, 30);
        frame.getContentPane().add(priceField);

        JLabel lblBrand = new JLabel("Brand:");
        lblBrand.setBounds(20, 100, 100, 30);
        frame.getContentPane().add(lblBrand);

        brandField = new JTextField();
        brandField.setBounds(130, 100, 200, 30);
        frame.getContentPane().add(brandField);

        JLabel lblExpiryDate = new JLabel("Expiry Date (YYYY-MM-DD):");
        lblExpiryDate.setBounds(20, 140, 200, 30);
        frame.getContentPane().add(lblExpiryDate);

        expiryDateField = new JTextField();
        expiryDateField.setBounds(220, 140, 110, 30);
        frame.getContentPane().add(expiryDateField);

        JButton btnAdd = new JButton("Add Grocery");
        btnAdd.setBounds(20, 180, 150, 30);
        frame.getContentPane().add(btnAdd);

        JButton btnView = new JButton("View All Groceries");
        btnView.setBounds(180, 180, 150, 30);
        frame.getContentPane().add(btnView);

        JButton btnUpdate = new JButton("Update Grocery");
        btnUpdate.setBounds(20, 220, 150, 30);
        frame.getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Delete Grocery");
        btnDelete.setBounds(180, 220, 150, 30);
        frame.getContentPane().add(btnDelete);

        JLabel lblId = new JLabel("Grocery ID:");
        lblId.setBounds(20, 260, 100, 30);
        frame.getContentPane().add(lblId);

        idField = new JTextField();
        idField.setBounds(130, 260, 200, 30);
        frame.getContentPane().add(idField);

        // TextArea and ScrollPane for output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(20, 300, 550, 150);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(scrollPane);

        // Button listeners
        btnAdd.addActionListener(e -> addGrocery());
        btnView.addActionListener(e -> viewAllGroceries());
        btnUpdate.addActionListener(e -> updateGrocery());
        btnDelete.addActionListener(e -> deleteGrocery());
    }

    private void addGrocery() {
        try {
            String productName = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            String brand = brandField.getText();
            String expiryDate = expiryDateField.getText();

            Grocery grocery = new Grocery(productName, price, brand, expiryDate);
            groceryService.addGrocery(grocery);
            outputArea.setText("Grocery added successfully!");
        } catch (Exception ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    private void viewAllGroceries() {
        List<Grocery> groceries = groceryService.getAllGrocerys();
        StringBuilder sb = new StringBuilder();
        for (Grocery g : groceries) {
            sb.append(g.getId()).append(". ").append(g.getProductName())
                    .append(" - ").append(g.getExpiry_date()).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    private void updateGrocery() {
        try {
            int id = Integer.parseInt(idField.getText());
            String newProductName = nameField.getText();
            int newPrice = Integer.parseInt(priceField.getText());
            String newBrand = brandField.getText();
            String newExpiryDate = expiryDateField.getText();

            Grocery grocery = new Grocery(newProductName, newPrice, newBrand, newExpiryDate);
            grocery.setId(id);
            groceryService.updateGrocery(grocery);
            outputArea.setText("Grocery updated successfully!");
        } catch (Exception ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    private void deleteGrocery() {
        try {
            int id = Integer.parseInt(idField.getText());
            groceryService.deleteGrocery(id);
            outputArea.setText("Grocery deleted successfully!");
        } catch (Exception ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }
}
