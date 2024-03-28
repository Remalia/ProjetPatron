package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

public class RectangleVue extends FormeVue{

    public RectangleVue(Forme forme) {
        super(forme);
    }

    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        g.drawRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.fillRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
    }
}
