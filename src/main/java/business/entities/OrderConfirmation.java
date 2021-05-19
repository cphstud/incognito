package business.entities;

import java.sql.Timestamp;

public class OrderConfirmation {
    private Timestamp date;
    private int price;
    private String address;
    private int width;
    private int length;
    private String roof_type;

    public OrderConfirmation(Timestamp date, int price, String address, int width, int length, String roof_type) {
        this.date = date;
        this.price = price;
        this.address = address;
        this.width = width;
        this.length = length;
        this.roof_type = roof_type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }
}
