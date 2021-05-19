package business.persistence;

import business.entities.Order;
import business.entities.OrderConfirmation;
import business.exceptions.UserException;
import business.services.OrderFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderConfirmationMapper
{
    private static Database database;

    public OrderConfirmationMapper(Database database) {
        this.database = database;
    }


    public List<OrderConfirmation> showOrderConfirmation() throws UserException {
        List<OrderConfirmation> OrderConfirmation = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM orders INNER JOIN user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int price = rs.getInt("price");
                    String address = rs.getString("address");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    Timestamp date = rs.getTimestamp("date");
                    String roof_type = rs.getString("roof_type");

                    OrderConfirmation.add(new OrderConfirmation(date, price, address, width, length, roof_type));
                }
                return OrderConfirmation;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }



}
