package models;

public class Grocery {
    private int id;
    private String productName;
    private int price;
    private String brand;
    private String expiry_date;

    public Grocery() {}

    public Grocery( String productName, int price, String brand, String expiry_date) {
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.expiry_date = expiry_date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
