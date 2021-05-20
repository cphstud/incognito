package business.persistence;

import business.entities.AddSeller;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;

public class AddNewSellerMapper {

    private static Database database;

    public AddNewSellerMapper(Database database) {
        this.database = database;
    }

    public AddSeller AddNewSeller(AddSeller seller) throws UserException {


        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO user SET name = ?, address = ?, phone = ?, email = ?, password = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, seller.getName());
                ps.setString(2, seller.getAddress());
                ps.setString(3, seller.getPhone());
                ps.setString(4, seller.getEmail());
                ps.setString(5, seller.getPassword());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

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
        return seller;
    }

}
