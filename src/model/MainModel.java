package ProjetPatron.src.model;

import ProjetPatron.src.model.Action.Commandes.CommandHandler;
import ProjetPatron.src.model.Action.LoadLevel;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.vue.MainVue;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    private Score score;

    /***
     * Permet la création d'un mainModel
     * @param idLevel : l'id du niveau
     */
    private MainModel(int idLevel){
        this.actualLevel = idLevel;
        this.ch = new CommandHandler();
        this.formes = new ArrayList<>();
        this.score = new Score();
    }

    /***
     * Permet de récupérer le niveau actuel
     * @return le niveau actuel
     */
    public int getActualLevel() {
        return actualLevel;
    }

    /***
     * Permet de changer le niveau actuel
     * @param actualLevel : le nouveau niveau
     */
    public void setActualLevel(int actualLevel) {
        this.actualLevel = actualLevel;
    }

    /***
     * Permet de récupérer toutes les formes
     * @return la liste des formes
     */
    public List<Forme> getFormes() {
        return formes;
    }

    /***
     * Permet de récupérer une forme par son id
     * @return l'id de la forme
     */
    public static int getNextIdForme(){
        return nbForme++;
    }

    /***
     * Permet de récupérer l'instance unique du MainModel
     * @return l'instance
     */
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

    /***
     * Permet de récupérer le nombre de formes
     * @return le nombre de formes
     */
    public static int getNbForme() {
        return nbForme;
    }

    public static void setNbForme(int nbId) {
        nbForme = nbId;
    }


    /***
     * Permet de charger un niveau
     * @param id : id du niveau
     */
    public void loadLevel(int id) throws IOException {
        instance = new MainModel(id);
        if(!LoadLevel.loadGameFromYAML("assets/saves/Niveau"+instance.getActualLevel()+"Save.yaml") && instance.getActualLevel() != 0)
            LoadLevel.loadGameFromYAML("assets/saves/Niveau"+instance.getActualLevel()+".yaml");
        MainVue.getInstance().repaintAll();
    }

    /***
     * Permet de placer les formes du niveau
     * @param formes : liste de formes
     */
    public void setFormes(List<Forme> formes) {
        this.formes = formes;
    }

    /***
     * Permet de récupérer le score
     * @return le score
     */
    public Score getScore() {
        return score;
    }
}
