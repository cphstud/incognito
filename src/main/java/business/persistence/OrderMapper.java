package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;

public class OrderMapper
{
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders SET width = ?, length = ?, roof_type = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, order.getLength());
                ps.setString(2, order.getWidth());
                ps.setString(3, order.getRoof_type());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
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
