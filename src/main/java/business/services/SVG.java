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

    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;\"/>";

    private final String textvandretTemplate = " <text style=\"text-anchor: middle\" x=\"%d\" y=\"%d\">%s</text>";

    private final String textlodretTemplate = "<text style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(-90)\">%s</text>";

    private final String stippledelineTemplate = "<line stroke-dasharray=\"5, 5\" x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"black\" />";

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

    public void addvandretText(int x,int y, String text)
    {
        svg.append(String.format(textvandretTemplate,x,y,text));
    }

    public void addlodretText(int x,int y, String text)
    {
        svg.append(String.format(textlodretTemplate,x,y,text));
    }

    public void addstippledeline(int x1, int y1, int x2, int y2)
    {
        svg.append(String.format(stippledelineTemplate,x1,y1,x2,y2));
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}
