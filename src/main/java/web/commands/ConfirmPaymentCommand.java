package web.commands;

import business.entities.ConfirmPayment;
import business.entities.Order;
import business.entities.Requests;
import business.entities.User;
import business.exceptions.UserException;
import business.services.ConfirmPaymentFacade;
import business.services.CustomerRequestsFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ConfirmPaymentCommand extends CommandProtectedPage
{
    private ConfirmPaymentFacade confirmPaymentFacade = new ConfirmPaymentFacade(database);


    public ConfirmPaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {



        List<ConfirmPayment> payment = confirmPaymentFacade.ViewAllConfirmedPayments();
        request.setAttribute("payment", payment);

        return pageToShow;

    }


}

