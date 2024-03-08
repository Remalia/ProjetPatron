package ProjetPatron.src.controller.State;
/***
 * Etat d'ajout de triangle
 */

public class StateAjoutTriangle implements State {
    private static StateAjoutTriangle instance;

    private StateAjoutTriangle(){

    }

    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutTriangle();
        }
        return instance;
    }

    @Override
    public void hasClicked() {

    }
}