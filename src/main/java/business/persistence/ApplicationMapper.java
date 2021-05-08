package business.persistence;

import business.entities.Application;
import business.exceptions.UserException;

import java.sql.*;
import java.util.List;

public class ApplicationMapper
{
    private Database database;

    public ApplicationMapper(Database database) {
        this.database = database;
    }

    public void createApplication(Application application) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO carport_item SET width = ?, length = ?, roof_type = ?, price = ?, toolroom_width = ?, toolroom_length = ? ";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, application.getWidth());
                ps.setString(2, application.getLength());
                ps.setString(3, application.getRoof_type());
                ps.setString(4, application.getPrice());
                ps.setString(5, application.getToolroom_width());
                ps.setString(6, application.getToolroom_width());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                application.setOrder_id("id");
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
