package web.commands;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.services.CarportItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowAllCarportItemsCommand extends Command
{
    public String role;
    public String pageToShow;
    private CarportItemFacade carportItemFacade = new CarportItemFacade(database);

    // længde = 780
    // bredde = 600
    // calc beams(l, b) = 2 * 780 + 2 * 600;
    // calc rafts(l, b) = 780 / 55 (runde op til hele tal)
    // calc posts(l, b) = 4 stykker
    // hashmap med antal og type (rafts, posts, beams)

    public ShowAllCarportItemsCommand(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        List<CarportItem> carportItems = carportItemFacade.BillOfMaterials();
        request.setAttribute("carportItems", carportItems);
        return pageToShow;

    }

    public String getRole()
    {
        return role;
    }
}
