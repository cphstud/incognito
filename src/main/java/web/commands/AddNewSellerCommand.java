package web.commands;

import business.entities.AddSeller;
import business.entities.Order;
import business.entities.User;
import business.persistence.OrderMapper;
import business.services.AddNewSellerFacade;
import business.services.OrderFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddNewSellerCommand extends CommandProtectedPage
{
    private AddNewSellerFacade addNewSellerFacade = new AddNewSellerFacade(database);

    public AddNewSellerCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AddSeller addSeller =  addNewSellerFacade.AddNewSeller(name, address, phone, email, password);
        request.setAttribute("addseller", addSeller);


        return pageToShow;
    }


}
