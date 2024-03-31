package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

public class RectangleVue extends FormeVue{

    private Rectangle rectangle;

    public RectangleVue(Forme forme) {
        super(forme);
    }

    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        this.rectangle = new Rectangle(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.drawRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.fillRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
    }

    @Override
    public boolean isInForme(Coord coord) {
        boolean b = rectangle.contains(new Point(coord.getX(),coord.getY()));
        return b;
    }
}
