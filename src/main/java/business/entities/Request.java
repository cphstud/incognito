package business.entities;

public class Request {


    public Request(int order_id, int quantity, String description, int item_id, int length, int price, String roof_type, int width, int toolroom_width, int toolroom_length, String name, String address, int postcode, int phone) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.description = description;
        this.item_id = item_id;
        this.length = length;
        this.price = price;
        this.roof_type = roof_type;
        this.width = width;
        this.toolroom_width = toolroom_width;
        this.toolroom_length = toolroom_length;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }


    private int order_id;
    private int quantity;
    private String description;
    private int item_id;
    private int length;
    private int price;
    private String roof_type;
    private int width;
    private int toolroom_width;
    private int toolroom_length;
    private String name;
    private String address;
    private int postcode;
    private int phone;

    public int getOrder_id() {
        return order_id;
    }

    public int getPhone() {
        return phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public int getWidth() {
        return width;
    }

    public int getToolroom_width() {
        return toolroom_width;
    }

    public int getToolroom_length() {
        return toolroom_length;
    }

    public String name() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setToolroom_width(int toolroom_width) {
        this.toolroom_width = toolroom_width;
    }

    public void setToolroom_length(int toolroom_length) {
        this.toolroom_length = toolroom_length;
    }
}
