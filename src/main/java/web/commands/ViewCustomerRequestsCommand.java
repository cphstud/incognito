package web.commands;

import business.entities.Order;
import business.entities.Requests;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CustomerRequestsFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ViewCustomerRequestsCommand extends CommandProtectedPage
{
    private CustomerRequestsFacade customerRequestsFacade = new CustomerRequestsFacade(database);


    public ViewCustomerRequestsCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        List<Requests> requests = customerRequestsFacade.ViewAllCustomoerRequests();
        request.setAttribute("requests", requests);
        return pageToShow;

    }


}

