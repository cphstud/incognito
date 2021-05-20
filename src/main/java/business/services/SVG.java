package business.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" "  +
            "width=\"%d%%\" "  +
            " viewBox=\"%s\" "+
            "x=\"%d\" "+
            "y=\"%d\" "+
        " preserveAspectRatio=\"xMinYMin\">";


    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\"/>";

    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;" +
           " marker-start: url(#beginArrow);"+
           " marker-end: url(#endArrow);\"/>";

    private final String markerTemplate = "<marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\"+ " +
            "<path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }

    public void addRect(int x, int y,int height, int width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2)
    {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    public void addSvg(SVG innerSVG)
    {
        svg.append(innerSVG.toString());
    }

    public void addMarker()
    {

    }


    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}
