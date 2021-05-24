package business.entities;

public class Material {
    int id;
    int length;
    String type;
    String priceUnit;

    public Material(int id) {
        this.id = id;
    }

    public Material(int length, String type, String priceUnit) {
        this.type = type;
        this.priceUnit = priceUnit;
    }

    public void setId(int id) {
        this.id = id;
    }
}
