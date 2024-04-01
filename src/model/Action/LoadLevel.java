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

    private static List<Forme> temp;

    public static boolean loadGameFromYAML(String path) throws IOException {
        temp = new ArrayList<>();
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
            MainModel.getInstance().setFormes(temp);
            return true;
        }else{
            return false;
        }
    }

    private static void traiter(String lastBalise,String key,String val){
        switch (lastBalise){
            case "level": MainModel.getInstance().setActualLevel(Integer.parseInt(val)); break;
            case "formes": Forme f = traiterForme(key,val); if (f!= null) temp.add(f); break;
            case "historySvg": traiterActions(key,val,true); break;
            case "historyRecup": traiterActions(key,val,false); break;
        }
    }

    private static Forme traiterForme(String key,String val){
        Forme f = null;
        if(val.contains("T")){
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
        }
        return f;
    }

    public static Coord getCoord(String line){
        return new Coord(Integer.parseInt(line.substring(1,line.indexOf("/"))),Integer.parseInt(line.substring(line.indexOf("/")+1,line.lastIndexOf(")"))));
    }

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
