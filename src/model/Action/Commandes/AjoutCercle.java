package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Cercle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/***
 *  Classe d'ajout de cercle dans le jeu
 */
public class AjoutCercle implements Command{

    private Cercle circle;

    /***
     * Constructeur pour l'ajout d'un cercle
     */
    public AjoutCercle(){}

    /***
     * Constructeur pour l'ajout d'un cercle avec arguments
     * @param color : la couleur du cercle
     * @param points : ses coordonnées
     * @param locked : si il est bloqué au déplacement ou non
     */
    public AjoutCercle(Color color, List<Coord> points, Boolean locked){
        this.circle = new Cercle(color,points,locked);
    }

    /***
     * Permet d'ajouter le cercle
     */
    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(circle);
    }

    /***
     * Permet d'annuler l'ajout du cercle
     */
    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().remove(circle);
    }

    /***
     * Permet d'écrire une commande d'ajout de cercle dans le Yaml de sauvegarde
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += "("+circle.getPoints().get(0).getX()+"/"+circle.getPoints().get(0).getY()+") |";
        ligneDesc += "("+circle.getPoints().get(1).getX()+"/"+circle.getPoints().get(1).getY()+") | ";
        ligneDesc += circle.isLocked() ? "T\n" : "F\n";
        return "  cercle-"+circle.getId()+": " + ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de cercle depuis une ligne de sauvegarde
     * @param ligne La ligne en question
     */
    @Override
    public void readCommand(String ligne) {
        List<Point> pts = new ArrayList<>();
    }
}
