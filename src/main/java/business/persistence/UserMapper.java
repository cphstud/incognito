package business.persistence;

import business.entities.ConfirmPayment;
import business.entities.Order;
import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
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

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT user_id, role FROM user WHERE email = ? AND password = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }


    public List<User> showAllUsers() throws UserException {

        List<User> users = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM user";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String postcode = rs.getString("postcode");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String role = rs.getString("role");

                    users.add(new User(user_id, email, password, role, name, phone, address, postcode));

                }
                return users;
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

    public User getUserById(int userid) throws Exception {
        User user;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user WHERE user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, userid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    userid = rs.getInt("user_id");
                    String name = "Daniel";
                    String address = "Nørgaardsvej 30 2800, Kongens Lyngby";
                    String phone = "36154504";
                    String email = "kontakt@cphbusiness.dk";
                    String role = rs.getString("role");
                  //  String password = rs.getString("password");
                    String password = "";
                  //  String address = rs.getString("address");

                    user = new User(userid, email, password, role, name, phone, password, address);
                 //   int id, String email, String password, String role, String name, String phone)


                } else
                {
                    throw new UserException("der sket en fejl...");
                }

            }
        }

        return user;
    }
}
