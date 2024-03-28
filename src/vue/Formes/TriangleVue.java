package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

public class TriangleVue extends FormeVue{

    private Polygon polygon;

    public TriangleVue(Forme forme) {
        super(forme);
    }

    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        this.polygon = new Polygon(getForme().getPointX(), getForme().getPointY(), getForme().getPoints().size());
        g.drawPolygon(polygon);
        g.fillPolygon(polygon);
    }

    @Override
    public boolean isInForme(Coord coord) {
        return polygon.contains(new Point(coord.getX(),coord.getY()));
    }
}
