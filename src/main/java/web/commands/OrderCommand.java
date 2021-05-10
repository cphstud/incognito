package web.commands;

import business.entities.Order;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderCommand extends CommandUnprotectedPage
{
    private OrderFacade orderFacade;



    public OrderCommand(String pageToShow)
    {
        super(pageToShow);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String width = request.getParameter("width");
        String length = request.getParameter("length");
        String customer_id = request.getParameter("customer_id");
        String date = request.getParameter("date");
        String subtotal = request.getParameter("subtotal");
        String roof_type = request.getParameter("roof_type");

        orderFacade.createOrder(customer_id, length, width, date, subtotal, roof_type);

        OrderMapper orderMapper = new OrderMapper(database);

        List<Order> orders = orderMapper.showAllOrders();
        request.setAttribute("orders", orders);



            return pageToShow;
        }


}
