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
        SVG svgOuter = new SVG(0,0,"0 0 850 690", 100, 100);
        // y-aksen/lodret
        svgOuter.addLine(70,0,70,635);
        // x-aksen/vandret
        svgOuter.addLine(105,670,800,670);
        // tag side bund
        svgOuter.addLine(105,640,800,640);
        //rem bund
        svgOuter.addLine(105,595,800,595);
        svgOuter.addLine(105,600,800,600);
        // rem top
        svgOuter.addLine(105,50,800,50);
        svgOuter.addLine(105,45,800,45);
        // stolper top
        svgOuter.addRect( 180, 42, 10, 10);
        svgOuter.addRect( 500, 42, 10, 10);
        svgOuter.addRect( 760, 42, 10, 10);
        // stolper bund
        svgOuter.addRect( 180, 593, 10, 10);
        svgOuter.addRect( 500, 593, 10, 10);
        svgOuter.addRect( 760, 593, 10, 10);


        svgOuter.addLine(105,0,800,0);// tage side top


        SVG svgInner = new SVG(0,0,"0 0 800 600", 100, 100);

        for (int x = 0; x < 14; x++)
        {
            svgInner.addRect(100 + 50 * x,0,600,4);
        }

        svgOuter.addSvg(svgInner);

        request.setAttribute("drawing", svgOuter.toString());
        return pageToShow;
    }
}
