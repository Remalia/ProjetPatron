package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

/***
 * Classe qui permet de gérer l'affichage d'un rectangle
 */
public class RectangleVue extends FormeVue{

    private Rectangle rectangle;

    /***
     * Constructeur de la vue d'un rectangle
     * @param forme : forme à afficher
     */
    public RectangleVue(Forme forme) {
        super(forme);
    }

    /***
     * Permet de dessiner un rectangle
     * @param g : graphics
     */
    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        this.rectangle = new Rectangle(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.drawRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
        g.fillRect(getForme().getMostLeftCoord(), getForme().getMostUpCoord(), getForme().getWidth(), getForme().getHeight());
    }

    /***
     * Permet de savoir si un point est dans le rectangle
     * @param coord : coordonnées du point
     * @return vrai si le point est dans le rectangle, faux sinon
     */
    @Override
    public boolean isInForme(Coord coord) {
        return rectangle.contains(new Point(coord.getX(),coord.getY()));
    }
}
