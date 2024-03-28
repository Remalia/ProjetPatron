package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CercleVue extends FormeVue {

    public CercleVue(Forme forme){
        super(forme);
    }

    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        g.drawOval(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.fillOval(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
    }

    @Override
    public boolean isInForme(Coord coord) {
        return coord.getX() < getForme().getMostRightCoord() && coord.getY() < getForme().getMostDownCoord() && coord.getY() > getForme().getMostUpCoord() && coord.getX() > getForme().getMostLeftCoord();
    }

}
