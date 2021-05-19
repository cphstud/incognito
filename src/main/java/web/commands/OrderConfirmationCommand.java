package web.commands;

import business.entities.ConfirmPayment;
import business.entities.Order;
import business.entities.OrderConfirmation;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderConfirmationFacade;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class OrderConfirmationCommand extends CommandProtectedPage
{
    private OrderConfirmationFacade orderConfirmationFacade = new OrderConfirmationFacade(database);

    public OrderConfirmationCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        List<OrderConfirmation> ordercofirmation = orderConfirmationFacade.showOrderConfirmation();
        request.setAttribute("ordercofirmation", ordercofirmation);

        return pageToShow;
    }
}
