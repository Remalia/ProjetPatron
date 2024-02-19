package ProjetPatron.src.model;

import ProjetPatron.src.model.Action.Commandes.CommandHandler;

/***
 * S'occupe de faire les liasons entre les classes du models et celui de la classe global des controllers.
 */
public class MainModel {

    private CommandHandler ch;

    /***
     * Permet la création d'un mainModel
     */
    public MainModel(){
        this.ch = new CommandHandler();
    }
}
