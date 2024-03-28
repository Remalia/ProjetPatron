package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

public abstract class FormeVue{

    private Forme forme;

    FormeVue(Forme forme){
        this.forme = forme;
    }

    public Forme getForme() {
        return forme;
    }

    public abstract void drawForme(Graphics g);

}
