package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

public class TriangleVue extends FormeVue{

    public TriangleVue(Forme forme) {
        super(forme);
    }

    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        g.drawPolygon(getForme().getPointX(), getForme().getPointY(), getForme().getPoints().size());
        g.fillPolygon(getForme().getPointX(), getForme().getPointY(), getForme().getPoints().size());
    }
}
