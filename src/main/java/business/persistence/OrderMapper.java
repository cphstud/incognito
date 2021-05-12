package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    private static Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public Order createOrder(Order order) throws UserException {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders SET width = ?, length = ?, roof_type = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, order.getLength());
                ps.setInt(2, order.getWidth());
                ps.setString(3, order.getRoof_type());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                order.setOrder_id(id);

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
        return order;
    }

    public List<Order> showAllOrders() throws UserException {

        List<Order> orders = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM orders";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int customer_id = rs.getInt("customer_id");
                    int order_id = rs.getInt("order_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    long date = rs.getLong("date");
                    int sub_total = rs.getInt("subtotal");
                    String roof_type = rs.getString("roof_type");

                    orders.add(new Order(customer_id, length, width, date, sub_total, roof_type, order_id));
                }
                return orders;
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
