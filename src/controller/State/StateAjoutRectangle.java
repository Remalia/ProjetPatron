package ProjetPatron.src.controller.State;

/***
 * Etat d'ajout de carré
 */

public class StateAjoutRectangle implements State {
    private static StateAjoutRectangle instance;

    private StateAjoutRectangle(){

    }

    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutRectangle();
        }
        return instance;
    }

    @Override
    public void hasClicked() {

    }
}