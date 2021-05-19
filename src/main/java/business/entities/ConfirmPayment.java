package business.entities;

public class ConfirmPayment {
    private int order_id;
    private int width;
    private int length;
    private String roof_type;
    private String name;
    private String status;
    private int credit;
    private String address;
    private int phone;
    private int postcode;
    private String city;
    private String email;

    public ConfirmPayment(int order_id, int width, int length, String roof_type, String name, String status, int credit, String address, int phone, int postcode, String city) {
        this.order_id = order_id;
        this.width = width;
        this.length = length;
        this.roof_type = roof_type;
        this.name = name;
        this.status = status;
        this.credit = credit;
        this.address = address;
        this.phone = phone;
        this.postcode = postcode;
        this.city = city;
    }

    public ConfirmPayment(String name, String address, int phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
