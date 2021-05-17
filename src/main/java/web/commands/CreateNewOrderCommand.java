package web.commands;

import business.entities.Order;
import business.entities.User;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CreateNewOrderCommand extends CommandProtectedPage
{
    private OrderFacade orderFacade = new OrderFacade(database);

    public CreateNewOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        HttpSession session = request.getSession();
        User u1 = (User) session.getAttribute("user");
        long date = System.currentTimeMillis();


        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        String roof_type = request.getParameter("roof_type");
        int subtotal = 0;

        Order newOrder =  orderFacade.createOrder(u1.getId(), length, width, date, subtotal, roof_type);
        request.setAttribute("newOrder", newOrder);


            return pageToShow;
    }


}
