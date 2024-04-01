package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Action.LoadLevel;
import ProjetPatron.src.model.Formes.Cercle;
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

    public AjoutRectangle(){}

    public AjoutRectangle(Color color, List<Coord> points, Boolean locked){
        this.rectangle = new Rectangle(color,points,locked);
    }

    @Override
    public void execute() {
        MainModel.getInstance().getFormes().add(rectangle);
    }

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
        ligneDesc += "("+rectangle.getPoints().get(0).getX()+"/"+rectangle.getPoints().get(0).getY()+") | ";
        ligneDesc += "("+rectangle.getPoints().get(1).getX()+"/"+rectangle.getPoints().get(1).getY()+") | ";
        ligneDesc += rectangle.isLocked() ? "T\n" : "F\n";
        return "  rectangle-"+rectangle.getId()+":" +ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de rectangle depuis une ligne de sauvegarde
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
        this.rectangle = new Rectangle(col,pts,locked,id);
    }
}
