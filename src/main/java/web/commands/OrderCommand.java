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

public class OrderCommand extends CommandProtectedPage
{
    private OrderFacade orderFacade = new OrderFacade(database);

    public OrderCommand(String pageToShow, String role) {
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
        int subtotal = 0;
        String roof_type = request.getParameter("roof_type");
        System.out.println(u1);
        System.out.println(date);
        System.out.println(width);
        System.out.println(length);
        System.out.println(roof_type);
        Order newOrder =  orderFacade.createOrder(u1.getId(), length, width, date, subtotal, roof_type);


        List<Order> orders = orderFacade.showAllOrders();
        request.setAttribute("orders", orders);
        request.setAttribute("newOrder", newOrder);



            return pageToShow;
    }


}
