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
 *  Classe d'ajout de triangle dans le jeu
 */
public class AjoutTriangle implements Command{

    private Triangle triangle;

    public AjoutTriangle(){}

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
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += "("+triangle.getPoints().get(0).getX()+"/"+triangle.getPoints().get(0).getY()+") | ";
        ligneDesc += "("+triangle.getPoints().get(1).getX()+"/"+triangle.getPoints().get(1).getY()+") | ";
        ligneDesc += "("+triangle.getPoints().get(2).getX()+"/"+triangle.getPoints().get(2).getY()+") | ";
        ligneDesc += triangle.isLocked() ? "T\n" : "F\n";
        return "  triangle-"+triangle.getId()+":" +ligneDesc;
    }

    /***
     * Permet de reconstruire un ajout de triangle depuis une ligne de sauvegarde
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
        String thridPT = secondPT.substring(secondPT.indexOf("|")+2,secondPT.lastIndexOf("|")-1);
        secondPT = secondPT.substring(0,secondPT.indexOf("|")-1);
        pts.add(LoadLevel.getCoord(secondPT));
        pts.add(LoadLevel.getCoord(thridPT));
        this.triangle = new Triangle(col,pts,locked,id);
    }

}
