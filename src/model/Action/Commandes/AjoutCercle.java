package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Cercle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.List;

/***
 *  Classe d'ajout de cercle dans le jeu
 */
public class AjoutCercle implements Command{

    private Cercle circle;

    public AjoutCercle(Color color, List<Coord> points, Boolean locked){
        this.circle = new Cercle(color,points,locked);
    }

    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(circle);
    }

    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().remove(circle);
    }

    /***
     * Permet d'écrire une commande d'ajout de cercle dans le Yaml de sauvegarde
     * @param svg True --> Sauvegarde pour le Undo / False --> Sauvegarde pour le Redo
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand(boolean svg) {
        return null;
    }

    /***
     * Permet de reconstruire un ajout de cercle depuis une ligne de sauvegarde
     */
    @Override
    public void readCommand() {

    }
}
