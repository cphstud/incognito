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
        svg.addRect(10,10,100,100);
        svg.addRect(150,10,100,100);
        svg.addRect(10,120,100,100);
        svg.addRect(150,120,100,100);

        request.setAttribute("drawing", svg.toString());
        return pageToShow;
    }
}
