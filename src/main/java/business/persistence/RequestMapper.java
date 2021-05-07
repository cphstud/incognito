package business.persistence;

import business.exceptions.UserException;
import business.entities.Request;

import javax.sql.DataSource;
import java.sql.*;

public class RequestMapper
{
    private Database database;

    public RequestMapper(Database database) {
        this.database = database;
    }



    public void createRequest(Request request) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, request.getWidth());
                ps.setInt(2, request.getLength());
                ps.setString(3, request.getRoof_type());
                ps.setInt(4, request.getToolroom_width());
                ps.setInt(5, request.getToolroom_length());
                ps.setString(6, request.name());
                ps.setString(7, request.getAddress());
                ps.setInt(8, request.getPostcode());
                ps.setInt(9, request.getPhone());

                ps.executeQuery();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                request.setOrder_id(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }


}
