package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Rectangle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/***
 *  Classe d'ajout de rectangle dans le jeu
 */
public class AjoutRectangle implements Command{

    private Rectangle rectangle;

    /***
     * Constructeur de l'ajout de rectangle
     */
    public AjoutRectangle(){}

    /***
     * Constructeur de l'ajout de rectangle avec arguments
     * @param color : la couleur du rectangle
     * @param points : ses coordonnées
     * @param locked : si il est bloqué au déplacement ou non
     */
    public AjoutRectangle(Color color, List<Coord> points, Boolean locked){
        this.rectangle = new Rectangle(color,points,locked);
    }

    /***
     * Permet d'ajouter le rectangle
     */
    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(rectangle);
    }

    /***
     * Permet d'annuler l'ajout du rectangle
     */
    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().remove(rectangle);
    }

    /***
     * Permet d'écrire une commande d'ajout de rectangle dans le Yaml de sauvegarde
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += "("+rectangle.getPoints().get(0).getX()+"/"+rectangle.getPoints().get(0).getY()+") |";
        ligneDesc += "("+rectangle.getPoints().get(1).getX()+"/"+rectangle.getPoints().get(1).getY()+") | ";
        ligneDesc += rectangle.isLocked() ? "T\n" : "F\n";
        return "  rectangle-"+rectangle.getId()+": " +ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de rectangle depuis une ligne de sauvegarde
     * @param ligne La ligne en question
     */
    @Override
    public void readCommand(String ligne) {
        List<Point> pts = new ArrayList<>();
    }
}
