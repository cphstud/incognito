package business.entities;

public class Order {

    private String customer_id;
    private String length;
    private String width;
    private String date;
    private String subtotal;
    private String roof_type;


    public Order(String customer_id, String length, String width, String date, String subtotal, String roof_type) {
        this.customer_id = customer_id;
        this.length = length;
        this.width = width;
        this.date = date;
        this.subtotal = subtotal;
        this.roof_type = roof_type;
    }


    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }
}