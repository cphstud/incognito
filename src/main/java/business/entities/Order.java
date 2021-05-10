package business.entities;

public class Order {

    private String length;
    private String width;
    private String price;
    private String roof_type;

    public Order(String length, String width, String roof_type) {
        this.length = length;
        this.width = width;
        this.roof_type = roof_type;
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

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }
}