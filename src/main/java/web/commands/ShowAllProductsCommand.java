package web.commands;

import business.entities.CarportItem;
import business.entities.ConfirmedOrders;
import business.entities.SeeProducts;
import business.exceptions.UserException;
import business.services.ProductsFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ShowAllProductsCommand extends CommandUnprotectedPage
{
    private ProductsFacade productsFacade = new ProductsFacade(database);

    public ShowAllProductsCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {


        List<SeeProducts> seeProducts = productsFacade.ShowAllProductsMapper();
        request.setAttribute("seeProducts", seeProducts);

        return pageToShow;

    }
}
