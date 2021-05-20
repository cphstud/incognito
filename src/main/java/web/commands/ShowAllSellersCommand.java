package web.commands;

import business.entities.SeeAllSellers;
import business.exceptions.UserException;
import business.services.SeeSellersFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowAllSellersCommand extends CommandProtectedPage
{
    private SeeSellersFacade seeSellersFacade = new SeeSellersFacade(database);


    public ShowAllSellersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {


        List<SeeAllSellers> sellers = seeSellersFacade.ShowAllSellers();
        request.setAttribute("seeAllSellers", sellers);

        return pageToShow;

    }
}
