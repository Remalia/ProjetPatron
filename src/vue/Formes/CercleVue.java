package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/***
 * Classe qui permet de gérer l'affichage d'un cercle
 */
public class CercleVue extends FormeVue {

    /***
     * Constructeur de la vue d'un cercle
     * @param forme : forme à afficher
     */
    public CercleVue(Forme forme){
        super(forme);
    }

    /***
     * Permet de dessiner un cercle
     * @param g : graphics
     */
    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        g.drawOval(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.fillOval(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
    }

    /***
     * Permet de savoir si un point est dans le cercle
     * @param coord : coordonnées du point
     * @return vrai si le point est dans le cercle, faux sinon
     */
    @Override
    public boolean isInForme(Coord coord) {
        return coord.getX() < getForme().getMostRightCoord() && coord.getY() < getForme().getMostDownCoord() && coord.getY() > getForme().getMostUpCoord() && coord.getX() > getForme().getMostLeftCoord();
    }

}
