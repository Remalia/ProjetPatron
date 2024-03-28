package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Cercle;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

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

}
