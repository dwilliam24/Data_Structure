package Restaurant;

import javax.swing.*;

public class FoodItem {
    private ImageIcon image;
    private String name;
    private String description;
    private Double cost;
    private int quantity;

    public FoodItem(ImageIcon image, String name, String description, Double cost, int quantity) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = quantity;
    }

    public ImageIcon getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
