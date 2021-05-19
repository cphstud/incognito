package business.entities;

public class SeeProducts {
    private int order_id;
    private int width;
    private int length;
    private String roof_type;
    private String name;
    private String status;

    public SeeProducts(int width, int length, String roof_type, String name, String status) {
        this.width = width;
        this.length = length;
        this.roof_type = roof_type;
        this.name = name;
        this.status = status;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
