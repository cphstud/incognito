package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.ConfirmPaymentFacade;
import business.services.ConfirmedOrdersFacade;
import business.services.CustomerRequestsFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ListOfAllConfirmedOrdersCommand extends CommandProtectedPage
{
    private ConfirmedOrdersFacade confirmedOrdersFacade = new ConfirmedOrdersFacade(database);


    public ListOfAllConfirmedOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {



        List<ConfirmedOrders> confirmedOrders = confirmedOrdersFacade.ListOfAllConfirmedOrders();
        request.setAttribute("confirmedOrders", confirmedOrders);



        return pageToShow;

    }


}

