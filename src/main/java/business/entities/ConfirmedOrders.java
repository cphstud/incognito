package business.entities;

public class ConfirmedOrders {

    private int length;
    private int width;
    private String roof_type;
    private String name;
    private String status;

    public ConfirmedOrders(int length, int width, String roof_type, String name, String status) {
        this.length = length;
        this.width = width;
        this.roof_type = roof_type;
        this.name = name;
        this.status = status;
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
