package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import javax.swing.*;
import java.awt.*;

public abstract class FormeVue extends JPanel {

    private Forme forme;

    FormeVue(Forme forme){
        this.forme = forme;
    }

    public Forme getForme() {
        return forme;
    }

    public abstract void drawForme(Graphics g);

    public abstract boolean isInForme(Coord coord);
}
