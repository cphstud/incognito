package web.commands;

import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String roof_type = request.getParameter("roof_type");

        orderFacade.createOrder(width, length, roof_type);



            return pageToShow;
        }


}
