package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Action.LoadLevel;
import ProjetPatron.src.model.Formes.Cercle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Triangle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/***
 *  Classe d'ajout de cercle dans le jeu
 */
public class AjoutCercle implements Command{

    private Cercle circle;

    public AjoutCercle(){}

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
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += "("+circle.getPoints().get(0).getX()+"/"+circle.getPoints().get(0).getY()+") | ";
        ligneDesc += "("+circle.getPoints().get(1).getX()+"/"+circle.getPoints().get(1).getY()+") | ";
        ligneDesc += circle.isLocked() ? "T\n" : "F\n";
        return "  cercle-"+circle.getId()+":" + ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de cercle depuis une ligne de sauvegarde
     * @param key key de la ligne
     * @param val valeur de la ligne
     */
    @Override
    public void readCommand(String key, String val) {
        int id = Integer.parseInt(key.substring(key.lastIndexOf("-")+1));
        List<Coord> pts = new ArrayList<>();
        String firstPT = val.substring(0,val.indexOf("|")-1);
        String secondPT = val.substring(val.indexOf("|")+2);
        pts.add(LoadLevel.getCoord(firstPT));
        Color col = val.contains("T") ? Color.RED : Color.GREEN;
        boolean locked = val.contains("T");;
        secondPT = secondPT.substring(0,secondPT.indexOf("|")-1);
        pts.add(LoadLevel.getCoord(secondPT));
        this.circle = new Cercle(col,pts,locked,id);
    }
}
