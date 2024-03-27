package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Rectangle;
import ProjetPatron.src.model.Formes.Triangle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.List;

/***
 *  Classe d'ajout de triangle dans le jeu
 */
public class AjoutTriangle implements Command{

    private Triangle triangle;

    public AjoutTriangle(Color color, List<Coord> points, Boolean locked){
        this.triangle = new Triangle(color,points,locked);
    }

    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(triangle);
    }

    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().remove(triangle);
    }

    /***
     * Permet d'écrire une commande d'ajout de triangle dans le Yaml de sauvegarde
     * @param svg True --> Sauvegarde pour le Undo / False --> Sauvegarde pour le Redo
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand(boolean svg) {
        return null;
    }

    /***
     * Permet de reconstruire un ajout de triangle depuis une ligne de sauvegarde
     */
    @Override
    public void readCommand() {

    }

}
