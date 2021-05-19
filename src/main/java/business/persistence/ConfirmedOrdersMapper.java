package business.persistence;

import business.entities.ConfirmedOrders;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfirmedOrdersMapper {

    private static Database database;

    public ConfirmedOrdersMapper(Database database) {
        this.database = database;
    }

    public List<ConfirmedOrders> ListOfAllConfirmedOrders() throws UserException, SQLException {
        List<ConfirmedOrders> confirmedOrders = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders INNER JOIN order_status, user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String roof_type = rs.getString("roof_type");
                    String name = rs.getString("email");
                    String status = rs.getString("status");

                    confirmedOrders.add(new ConfirmedOrders(width, length, roof_type, name, status));
                }
                return confirmedOrders;
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
