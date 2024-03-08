package ProjetPatron.src.controller;

import ProjetPatron.src.controller.State.*;

/***
 * Classe de gestion de tous les éléments faisant partie du controller
 */
public class MainController {
    private static MainController instance;
    private State state;

    private MainController(){
        this.state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public static MainController getInstance() {
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }
}
