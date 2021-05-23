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
        SVG svgOuter = new SVG(0,0,"0 0 850 720", 100, 100);

        // y-aksen/lodret med text
        svgOuter.addLine(70,0,70,635);
        svgOuter.addlodretText(65,330,"720cm");
        // start pil til y-aksen
        svgOuter.addLine(70,0,80,10);
        svgOuter.addLine(70,0,60,10);
        // slut pil til y-aksen
        svgOuter.addLine(70,635,80,625);
        svgOuter.addLine(70,635,60,625);
        // x-aksen/vandret med text
        svgOuter.addLine(105,685,800,685);
        svgOuter.addvandretText(430,700,"620cm");
        // start pil til x-aksen
        svgOuter.addLine(105,685,115,695);
        svgOuter.addLine(105,685,115,675);
        // slut pil til x-aksen
        svgOuter.addLine(800,685,790,695);
        svgOuter.addLine(800,685,790,675);
        // Vandret spær med mål
        svgOuter.addLine(105,655,800,655);
        svgOuter.addvandretText(135,675,"0,55");
        svgOuter.addvandretText(190,675,"0,55");
        svgOuter.addvandretText(240,675,"0,55");
        svgOuter.addvandretText(295,675,"0,55");
        svgOuter.addvandretText(350,675,"0,55");
        svgOuter.addvandretText(400,675,"0,55");
        svgOuter.addvandretText(455,675,"0,55");
        svgOuter.addvandretText(505,675,"0,55");
        svgOuter.addvandretText(560,675,"0,55");
        svgOuter.addvandretText(615,675,"0,55");
        svgOuter.addvandretText(665,675,"0,55");
        svgOuter.addvandretText(720,675,"0,55");
        svgOuter.addvandretText(775,675,"0,55");
        //start-slut målinger
        svgOuter.addLine(105,660,105,650);
        svgOuter.addLine(160,660,160,650);
        svgOuter.addLine(215,660,215,650);
        svgOuter.addLine(270,660,270,650);
        svgOuter.addLine(320,660,320,650);
        svgOuter.addLine(375,660,375,650);
        svgOuter.addLine(425,660,425,650);
        svgOuter.addLine(480,660,480,650);
        svgOuter.addLine(530,660,530,650);
        svgOuter.addLine(585,660,585,650);
        svgOuter.addLine(640,660,640,650);
        svgOuter.addLine(693,660,693,650);
        svgOuter.addLine(745,660,745,650);
        svgOuter.addLine(800,660,800,650);
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
        // kryds
        svgOuter.addstippledeline(150,50,700,595);
        svgOuter.addstippledeline(150,595,700,50);

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
