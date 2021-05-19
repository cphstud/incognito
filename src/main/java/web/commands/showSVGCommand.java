package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class showSVGCommand extends CommandUnprotectedPage
{
    public showSVGCommand(String pageToShow)
    {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException
    {
        SVG svg = new SVG(0,0,"0 0 855 690", 100, 100);
        svg.addLine(150,650,800,650);
        svg.addLine(100,0,100,600);

        for (int x = 0; x < 15; x++)
        {
            svg.addRect(100 + 50 * x,0,600,4);
        }

        request.setAttribute("drawing", svg.toString());
        return pageToShow;
    }
}
