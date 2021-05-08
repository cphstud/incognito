package business.entities;

public class Application {

    public Application(String width, String length, String roof_type, String toolroom_length, String toolroom_width, String price) {
   //     this.order_id = order_id;
     //   this.quantity = quantity;
       // this.description = description;
       // this.item_id = item_id;
       this.length = length;
        this.price = price;
        this.roof_type = roof_type;
        this.width = width;
        this.toolroom_width = toolroom_width;
        this.toolroom_length = toolroom_length;
    }

    private String order_id;
    private String quantity;
    private String description;
    private String item_id;
    private String length;
    private String price;
    private String roof_type;
    private String width;
    private String toolroom_width;
    private String toolroom_length;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getToolroom_width() {
        return toolroom_width;
    }

    public void setToolroom_width(String toolroom_width) {
        this.toolroom_width = toolroom_width;
    }

    public String getToolroom_length() {
        return toolroom_length;
    }

    public void setToolroom_length(String toolroom_length) {
        this.toolroom_length = toolroom_length;
    }
}