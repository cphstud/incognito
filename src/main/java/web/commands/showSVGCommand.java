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
        SVG svgOuter = new SVG(0,0,"0 0 855 690", 100, 100);
        svgOuter.addLine(150,650,800,650);
        svgOuter.addLine(100,0,100,600);

        SVG svgInner = new SVG(0,0,"0 0 800 600", 100, 100);
        //svgInner.addRect(100,100, 200, 300);

        for (int x = 0; x < 15; x++)
        {
            svgInner.addRect(100 + 50 * x,0,600,4);
        }

        svgOuter.addSvg(svgInner);

        request.setAttribute("drawing", svgOuter.toString());
        return pageToShow;
    }
}
