package services;

import dao.GroceryDAO;
import models.Grocery;

import java.util.List;

public class Groceryservices {
    private GroceryDAO groceryDAO = new GroceryDAO();

    public void addGrocery(Grocery grocery) {
    	groceryDAO.addGrocery(grocery);
    }

    public void updateGrocery(Grocery grocery) {
        groceryDAO.updateGrocery(grocery);
    }

    public void deleteGrocery(int id) {
        groceryDAO.deleteGrocery(id);
    }

    public Grocery getGrocery(int id) {
        return groceryDAO.getGrocery(id);
    }

    public List<Grocery> getAllGrocerys() {
        return groceryDAO.getAllGroceries();
    }
}
