package business.persistence;

import business.entities.CarportItem;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillOfMaterialsMapper {

    private static Database database;

    public BillOfMaterialsMapper(Database database) {
        this.database = database;
    }

    public List<CarportItem> BillOfMaterials() throws UserException, SQLException {
        List<CarportItem> carportItems = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport_item";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    String description = rs.getString("description");

                    carportItems.add(new CarportItem(length, width, quantity, price, description));
                }
                return carportItems;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }

    public void getTotalPrice() {

    }

    public void addItem() {

    }

}
