package business.entities;

public class CarportItem {
    private int length;
    private int quantity;
    private int price;
    private String description;

    public CarportItem(int i, int length, int quantity, int price, String description) {
        this.length = length;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
