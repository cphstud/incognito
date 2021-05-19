package business.entities;

import java.sql.Timestamp;

public class Order {

    private int customer_id;
    private int length;
    private int width;
    private Timestamp date;
    private int subtotal;
    private String roof_type;
    private int order_id;

    public Order(int customer_id, int length, int width, Timestamp date, int subtotal, String roof_type, int order_id) {
        this.customer_id = customer_id;
        this.length = length;
        this.width = width;
        this.date = date;
        this.subtotal = subtotal;
        this.roof_type = roof_type;
        this.order_id = order_id;
    }

    public Order(int customer_id, int length, int width, long date, int subtotal, String roof_type) {
        this.customer_id = customer_id;
        this.length = length;
        this.width = width;
        this.roof_type = roof_type;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}