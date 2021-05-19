package business.persistence;

import business.entities.ConfirmPayment;
import business.exceptions.UserException;
import com.sun.corba.se.pept.transport.ContactInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfirmPaymentMapper {

    private static Database database;

    public ConfirmPaymentMapper(Database database) {
        this.database = database;
    }

    public List<ConfirmPayment> ViewAllConfirmedPayments() throws UserException, SQLException {
        List<ConfirmPayment> confirmPayment = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders INNER JOIN order_status, user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof_type = rs.getString("roof_type");
                    String name = rs.getString("email");
                    String status = rs.getString("status");
                    int credit = rs.getInt("credit");
                    String address = rs.getString("address");
                    int phone = rs.getInt("phone");
                    int postcode = rs.getInt("postcode");
                    String city = rs.getString("city");

                    confirmPayment.add(new ConfirmPayment(order_id, width, length, roof_type, name, status, credit, address, phone, postcode, city));
                }
                return confirmPayment;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
    }

    public ConfirmPayment ShowContactInformation(ConfirmPayment confirmPayment) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, confirmPayment.getName());
                ps.setString(2, confirmPayment.getAddress());
                ps.setInt(3, confirmPayment.getPhone());
                ps.setString(4, confirmPayment.getEmail());


                ps.executeQuery();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                confirmPayment.setOrder_id(id);

            }
        }

        return confirmPayment;
    }

}
