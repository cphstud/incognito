package web.commands;

import business.entities.Order;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderCommand extends CommandProtectedPage
{
    private OrderFacade orderFacade;


    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String order_id = request.getParameter("order_id");
        String width = request.getParameter("width");
        String length = request.getParameter("length");
        String roof_type = request.getParameter("roof_type");

        orderFacade.createOrder(order_id, length, width, roof_type);

        OrderMapper orderMapper = new OrderMapper(database);

        List<Order> orders = orderMapper.showAllOrders();
        request.setAttribute("orders", orders);



            return pageToShow;
    }


}
