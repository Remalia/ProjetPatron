package ProjetPatron.src.vue.Formes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

import java.awt.*;

/***
 * Classe qui permet de gérer l'affichage d'un triangle
 
 */
public class TriangleVue extends FormeVue{

    private Polygon polygon;

    /***
     * Constructeur de la vue d'un triangle
     * @param forme : forme à afficher
     */
    public TriangleVue(Forme forme) {
        super(forme);
    }

    /***
     * Permet de dessiner un triangle
     * @param g : graphics
     */
    @Override
    public void drawForme(Graphics g) {
        g.setColor(getForme().getColor());
        this.polygon = new Polygon(getForme().getPointX(), getForme().getPointY(), getForme().getPoints().size());
        g.drawPolygon(polygon);
        g.fillPolygon(polygon);
    }

    /***
     * Permet de savoir si un point est dans le triangle
     * @param coord : coordonnées du point
     * @return vrai si le point est dans le triangle, faux sinon
     */
    @Override
    public boolean isInForme(Coord coord) {
        return polygon.contains(new Point(coord.getX(),coord.getY()));
    }
}
