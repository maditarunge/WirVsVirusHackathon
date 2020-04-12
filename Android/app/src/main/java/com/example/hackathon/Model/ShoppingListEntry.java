package com.example.hackathon.Model;

public class ShoppingListEntry {

    private int id;
    private String description;
    private String brand;
    private String size;

    public ShoppingListEntry(int id, String description, String brand, String size) {
        this(description, brand, size);
        setId(id);
    }

    public ShoppingListEntry(String description, String brand, String size) {
        setDescription(description);
        setBrand(brand);
        setSize(size);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    private void setSize(String size) {
        this.size = size;
    }
}
