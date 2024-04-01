package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstraite qui permet de gérer l'affichage d'une forme
 */
public abstract class FormeVue extends JPanel {

    private Forme forme;

    /**
     * Constructeur de la vue d'une forme
     * @param forme : forme à afficher
     */
    FormeVue(Forme forme){
        this.forme = forme;
    }

    /***
     * permet de récupérer l'instance de la forme
     * @return la forme
     */
    public Forme getForme() {
        return forme;
    }

    /***
     * Permet de dessiner une forme
     * @param g : graphics
     */
    public abstract void drawForme(Graphics g);

    /***
     * Permet de savoir si un point est dans la forme
     * @param coord : coordonnées du point
     * @return vrai si le point est dans la forme, faux sinon
     */
    public abstract boolean isInForme(Coord coord);
}
