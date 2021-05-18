package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserCommand extends CommandProtectedPage
{
    private UserFacade userFacade = new UserFacade(database);

    public UserCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String postcode = request.getParameter("postcode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");


        List<User> users = userFacade.showAllUsers(user_id, name, address, postcode, phone, email, role);
        request.setAttribute("users", users);
            return pageToShow;
    }
}
