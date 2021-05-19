package business.entities;

public class CarportItem {
    private int order_id
    private int item_id;
    private int length;
    private int quantity;
    private int price;
    private String description;

    public CarportItem(int item_id, int order_id, int length, int quantity, int price, String description) {
        //item_id
        //ordre_id......
        this.item_id = item_id;
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
