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
    private OrderFacade orderFacade;

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
       // int customer_id = Integer.parseInt(request.getParameter("customer_id"));
      //  String date = request.getParameter("date");
       // int subtotal = Integer.parseInt(request.getParameter("subtotal"));
        int subtotal = 0;
        String roof_type = request.getParameter("roof_type");
        System.out.println(u1);
        System.out.println(date);
        System.out.println(width);
        System.out.println(length);
        System.out.println(roof_type);
      //  orderFacade.createOrder(u1.getId(), length, width, date, subtotal, roof_type);

      //  OrderMapper orderMapper = new OrderMapper(database);

     //   List<Order> orders = orderMapper.showAllOrders();
      //  request.setAttribute("orders", orders);



            return pageToShow;
        }


}
