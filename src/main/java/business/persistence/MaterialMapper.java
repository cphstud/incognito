package business.persistence;

import business.entities.CarportItem;
import business.entities.Material;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class MaterialMapper {
    Database database;


    public MaterialMapper(Database database) {
        this.database = database;
    }

    public Material getCarportItemById(int id) throws UserException {
        Material material = null;

        try (
                Connection connection = database.connect()) {
                String sql = "SELECT * FROM materials WHERE id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("id");

                    material = new Material(id);

                }
            } catch (SQLException throwables) {
                throw new UserException("fejl.....");
            }
        } catch (SQLException throwables)
        {
            throw new UserException("fejl.....");
        }
        return material;
    }

}
