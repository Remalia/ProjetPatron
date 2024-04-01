package ProjetPatron.src.model.Action;

import ProjetPatron.src.model.Action.Commandes.*;
import ProjetPatron.src.model.Formes.*;
import ProjetPatron.src.model.Formes.Rectangle;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.model.Parser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Permet de charger une partie
 */
public class LoadLevel {

    /***
     * Permet de charger un niveau
     * @param path le path du niveau a charger
     * @return Si le niveau a pus etre charger
     * @throws IOException si fichier non trouver
     */
    public static boolean loadGameFromYAML(String path) throws IOException {
        String lastBalise = "";
        HashMap<String,String> hashMap =  Parser.getAllBalise(new File(path));
        if(!hashMap.isEmpty()){
            for (Map.Entry<String,String> entry:hashMap.entrySet()){
                switch (entry.getKey()){
                    case "historySvg", "historyRecup", "formes": lastBalise = entry.getKey(); break;
                    case "level" : traiter("level", entry.getKey(),entry.getValue()); break;
                    default: traiter(lastBalise, entry.getKey(),entry.getValue()); break;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    /***
     * permet de traiter la ligne
     * @param lastBalise la dernière balise lus
     * @param key la clé de la ligne
     * @param val la valeur de la ligne
     */
    private static void traiter(String lastBalise,String key,String val){
        switch (lastBalise){
            case "level": MainModel.getInstance().setActualLevel(Integer.parseInt(val)); break;
            case "formes": traiterForme(key,val); break;
            case "historySvg": traiterActions(key,val,true); break;
            case "historyRecup": traiterActions(key,val,false); break;
        }
    }

    /***
     * Permet de traiter les formes de l'app
     * @param key la clé de la ligne
     * @param val la valeur de la ligne
     */
    private static void traiterForme(String key,String val){
        if(val.contains("T")){
            Forme f = null;
            int id = Integer.parseInt(key.substring(key.lastIndexOf("-")+1));
            List<Coord> pts = new ArrayList<>();
            String firstPT = val.substring(0,val.indexOf("|")-1);
            String secondPT = val.substring(val.indexOf("|")+2);
            pts.add(LoadLevel.getCoord(firstPT));
            Color col = Color.RED;
            boolean locked = val.contains("T");;
            if(key.contains("triangle")){
                String thridPT = secondPT.substring(secondPT.indexOf("|")+2,secondPT.lastIndexOf("|")-1);
                secondPT = secondPT.substring(0,secondPT.indexOf("|")-1);
                pts.add(LoadLevel.getCoord(secondPT));
                pts.add(LoadLevel.getCoord(thridPT));
                f = new Triangle(col,pts,locked,id);
            }
            if(key.contains("cercle")){
                secondPT = secondPT.substring(0,secondPT.indexOf("|")-1);
                pts.add(LoadLevel.getCoord(secondPT));
                f = new Cercle(col,pts,locked,id);
            }
            if(key.contains("rectangle")){
                secondPT = secondPT.substring(0,secondPT.indexOf("|")-1);
                pts.add(LoadLevel.getCoord(secondPT));
                f = new Rectangle(col,pts,locked,id);
            }
            MainModel.getInstance().getFormes().add(f);
        }
    }

    /***
     * Permet de récupérer les coordonnées depuis une ligne d'un fichier de sauvegarde
     * @param line la ligne ou l'on doit recup les coordonnées
     * @return les coordonées sous forme x,y
     */
    public static Coord getCoord(String line){
        return new Coord(Integer.parseInt(line.substring(1,line.indexOf("/"))),Integer.parseInt(line.substring(line.indexOf("/")+1,line.lastIndexOf(")"))));
    }

    /***
     * Permet de traiter les actions de l'app
     * @param key La clé de la ligne
     * @param val La valeur de la ligne
     * @param svg Si il se situe dans la pile de undo --> true sinon false si pile de redo
     */
    private static void traiterActions(String key,String val,boolean svg){
        Command c = null;
        if(key.contains("suppr")){
            c = new SuppresionForme();
            c.readCommand(key,val);
            c.execute();
        }
        if(key.contains("deplacement")){
            c = new DeplacementForme();
            c.readCommand(key,val);
        }
        if(key.contains("triangle")){
            c = new AjoutTriangle();
            c.readCommand(key,val);
            c.execute();
        }
        if(key.contains("cercle")){
            c = new AjoutCercle();
            c.readCommand(key,val);
            c.execute();
        }
        if(key.contains("rectangle")){
            c = new AjoutRectangle();
            c.readCommand(key,val);
            c.execute();
        }
        if(svg)
            MainModel.getInstance().getCh().getStackCommand().push(c);
        else
            MainModel.getInstance().getCh().getStackRedo().push(c);
    }
}
