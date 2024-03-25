package ProjetPatron.src.model;

import ProjetPatron.src.model.Action.Commandes.CommandHandler;

/***
 * S'occupe de faire les liasons entre les classes du models et celui de la classe global des controllers.
 */
public class MainModel {

    private static MainModel instance;
    private CommandHandler ch;
    private static int nbForme = 0;

    /***
     * Permet la création d'un mainModel
     */
    private MainModel(){
        this.ch = new CommandHandler();
    }

    public static int getNextIdForme(){
        return nbForme++;
    }

    public static MainModel getInstance() {
        if(instance == null){
            instance = new MainModel();
        }
        return instance;
    }

    public void loadLevel(int id){
        instance = new MainModel();
        System.out.println("Loading");
    }
}
