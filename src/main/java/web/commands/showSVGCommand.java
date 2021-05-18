package web.commands;

import business.exceptions.UserException;

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
        String svg = "<svg  xmlns=\"http://www.w3.org/2000/svg\"\n" +
                "      width=\"300\" height=\"300\"  viewBox=\"0 0 255 210\">\n" +
                "\n" +
                "    viewBox=\"0 0 220 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <rect x=\"55\" y=\"-22\" width=\"200\" height=\"200\" stroke=\"black\" fill=\"white\"/>\n" +
                "\n" +
                "    svg viewBox=\"0 0 100 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <line x1=\"300\" y1=\"-10\" x2=\"55\" y2=\"-10\" stroke=\"black\" />\n" +
                "\n" +
                "    svg viewBox=\"0 0 100 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <line x1=\"300\" y1=\"165\" x2=\"55\" y2=\"165\" stroke=\"black\" />\n" +
                "\n" +
                "    viewBox=\"0 0 220 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <rect x=\"80\" width=\"5\" height=\"5\" stroke=\"black\" y=\"-13\" fill=\"black\"/>\n" +
                "\n" +
                "    viewBox=\"0 0 220 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <rect x=\"220\" width=\"5\" height=\"5\" stroke=\"black\" y=\"-13\" fill=\"black\"/>\n" +
                "\n" +
                "    viewBox=\"0 0 220 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <rect x=\"220\" width=\"5\" height=\"5\" stroke=\"black\" y=\"163\" fill=\"black\"/>\n" +
                "\n" +
                "    viewBox=\"0 0 220 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <rect x=\"80\" width=\"5\" height=\"5\" stroke=\"black\" y=\"163\" fill=\"black\"/>\n" +
                "\n" +
                "    svg viewBox=\"0 0 100 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <line stroke-dasharray=\"5, 5\" x1=\"2000\" y1=\"1900\" x2=\"50\" y2=\"-25\" stroke=\"black\" />\n" +
                "\n" +
                "    svg viewBox=\"0 0 100 100\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "    <line stroke-dasharray=\"5, 5\" x1=\"-2365\" y1=\"2506\" x2=\"350\" y2=\"-110\" stroke=\"black\" />\n" +
                "\n" +
                "\n" +
                "    <text x=\"120\" y=\"15\" style=\"text-anchor: middle\" transform=\"translate(10,200) rotate(-90)\"> 600 cm</text>\n" +
                "    <text x=\"150\" y=\"15\" style=\"text-anchor: middle\" transform=\"translate(10,200) rotate(-360)\"> 780 cm</text>\n" +
                "\n" +
                "    width=\"25%\" viewBox=\"0 0 150 40\">\n" +
                "        <defs>\n" +
                "            <marker\n" +
                "                    id=\"beginArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"0\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "            <marker\n" +
                "                    id=\"endArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"12\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "        </defs>\n" +
                "        <line x1=\"30\"  y1=\"10\" x2=\"30\"   y2=\"150\"\n" +
                "              style=\"stroke: #006600;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>\n" +
                "\n" +
                "\n" +
                "\n" +
                "        width=\"25%\" viewBox=\"0 0 150 40\">\n" +
                "        <defs>\n" +
                "            <marker\n" +
                "                    id=\"beginArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"0\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "            <marker\n" +
                "                    id=\"endArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"12\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "        </defs>\n" +
                "        <line x1=\"80\"  y1=\"200\" x2=\"230\"   y2=\"200\"\n" +
                "              style=\"stroke: #006600;\n" +
                "        marker-start: url(#beginArrow);\n" +
                "        marker-end: url(#endArrow);\"/>\n" +
                "    </svg>\n";

        request.setAttribute("drawing", svg);
        return pageToShow;
    }
}
