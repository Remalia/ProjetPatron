package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Triangle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/***
 *  Classe d'ajout de triangle dans le jeu
 */
public class AjoutTriangle implements Command{

    private Triangle triangle;

    /***
     * Constructeur pour l'ajout d'un triangle
     */
    public AjoutTriangle(){}

    /***
     * Constructeur pour l'ajout d'un triangle avec arguments
     * @param color : la couleur du triangle
     * @param points : ses coordonnées
     * @param locked : si il est bloqué au déplacement ou non
     */
    public AjoutTriangle(Color color, List<Coord> points, Boolean locked){
        this.triangle = new Triangle(color,points,locked);
    }

    /***
     * Permet d'ajouter le triangle
     */
    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(triangle);
    }

    /***
     * Permet d'annuler l'ajout du triangle
     */
    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().remove(triangle);
    }

    /***
     * Permet d'écrire une commande d'ajout de triangle dans le Yaml de sauvegarde
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += "("+triangle.getPoints().get(0).getX()+"/"+triangle.getPoints().get(0).getY()+") |";
        ligneDesc += "("+triangle.getPoints().get(1).getX()+"/"+triangle.getPoints().get(1).getY()+") |";
        ligneDesc += "("+triangle.getPoints().get(2).getX()+"/"+triangle.getPoints().get(2).getY()+") | ";
        ligneDesc += triangle.isLocked() ? "T\n" : "F\n";
        return "  triangle-"+triangle.getId()+": " +ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de triangle depuis une ligne de sauvegarde
     * @param ligne La ligne en question
     */
    @Override
    public void readCommand(String ligne) {
        List<Point> pts = new ArrayList<>();
    }

}
