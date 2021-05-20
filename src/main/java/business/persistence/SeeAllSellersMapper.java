package business.persistence;


import business.entities.SeeAllSellers;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeeAllSellersMapper
{
    private static Database database;

    public SeeAllSellersMapper(Database database) {
        this.database = database;
    }


    public List<SeeAllSellers> ShowAllSellers() throws UserException {
        List<SeeAllSellers> SeeSellers = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("email");
                    String address = rs.getString("address");
                    int phone = rs.getInt("phone");
                    String email = rs.getString("email");
                    int password = rs.getInt("password");
                    String role = rs.getString("role");
                    int postcode = rs.getInt("postcode");
                    int credit = rs.getInt("credit");
                    String city = rs.getString("city");

                    SeeSellers.add(new SeeAllSellers(user_id, name, address, phone, email, password, role, postcode, credit, city));
                }
                return SeeSellers;
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
