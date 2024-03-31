package ProjetPatron.src.model;

import ProjetPatron.src.model.Action.Commandes.CommandHandler;
import ProjetPatron.src.model.Formes.Forme;

import java.util.ArrayList;
import java.util.List;

/***
 * S'occupe de faire les liasons entre les classes du models et celui de la classe global des controllers.
 */
public class MainModel {

    private static MainModel instance;
    private CommandHandler ch;
    private static int nbForme = 0;
    private List<Forme> formes;
    private int actualLevel;

    /***
     * Permet la création d'un mainModel
     */
    private MainModel(int idLevel){
        this.actualLevel = idLevel;
        this.ch = new CommandHandler();
        this.formes = new ArrayList<>();
    }

    public int getActualLevel() {
        return actualLevel;
    }

    public void setActualLevel(int actualLevel) {
        this.actualLevel = actualLevel;
    }

    public List<Forme> getFormes() {
        return formes;
    }

    public static int getNextIdForme(){
        return nbForme++;
    }

    public static MainModel getInstance() {
        if(instance == null){
            instance = new MainModel(-1);
        }
        return instance;
    }

    /***
     * permet de récupèrer le handler de commande
     * @return le handler
     */
    public CommandHandler getCh() {
        return ch;
    }

    public static int getNbForme() {
        return nbForme;
    }

    public void loadLevel(int id){
        instance = new MainModel(id);
        System.out.println("Loading");
    }

    public void setFormes(List<Forme> formes) {
        this.formes = formes;
    }
}
