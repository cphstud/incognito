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
        svgOuter.addLine(110,685,800,685);
        // mål til Vandret spær
        svgOuter.addLine(110,660,800,660);
        //rem bund
        svgOuter.addLine(110,595,800,595);
        svgOuter.addLine(110,600,800,600);
        // rem top
        svgOuter.addLine(110,50,800,50);
        svgOuter.addLine(110,45,800,45);
        // stolper top
        svgOuter.addRect( 180, 42, 10, 10);
        svgOuter.addRect( 500, 42, 10, 10);
        svgOuter.addRect( 760, 42, 10, 10);
        // stolper bund
        svgOuter.addRect( 180, 593, 10, 10);
        svgOuter.addRect( 500, 593, 10, 10);
        svgOuter.addRect( 760, 593, 10, 10);
        // tage side top
        svgOuter.addLine(110,0,800,0);
        // tag side bund
        svgOuter.addLine(110,637,800,637);

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
