package business.persistence;

import business.entities.CarportItem;
import business.entities.SeeProducts;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllProductsMapper {

    private static Database database;

    public ShowAllProductsMapper(Database database) {
        this.database = database;
    }

    public List<SeeProducts> ShowAllProducts() throws UserException, SQLException {
        List<SeeProducts> seeProducts = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user INNER JOIN orders";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String roof_type = rs.getString("roof_type");
                    String name = rs.getString("email");
                    String status = rs.getString("roof_type");

                    seeProducts.add(new SeeProducts(width, length, roof_type, name, status));
                }
                return seeProducts;
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
