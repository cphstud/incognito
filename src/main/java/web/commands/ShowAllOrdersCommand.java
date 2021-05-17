package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowAllOrdersCommand extends CommandProtectedPage
{
    private OrderFacade orderFacade = new OrderFacade(database);

    public ShowAllOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

             List<Order> orders = orderFacade.showAllOrders();
            request.setAttribute("orders", orders);
            return pageToShow;

    }


}

