package ProjetPatron.src.controller;

import ProjetPatron.src.controller.State.*;

/***
 * Classe de gestion de tous les éléments faisant partie du controller
 */
public class MainController {

    private static MainController instance;
    private State state;

    /***
     * Constructeur de la classe MainController
     */
    private MainController(){
        this.state = StateSelect.getInstance();
    }

    /***
     * Permet de changer l'état de l'application
     * @param state : nouvel état
     */
    public void setState(State state) {
        this.state = state;
    }

    /***
     * Permet de récupérer l'état de l'application
     * @return : état
     */
    public State getState() {
        return state;
    }

    /***
     * Permet de récupérer l'instance unique de la classe
     * @return : instance de la classe
     */
    public static MainController getInstance() {
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }
}
