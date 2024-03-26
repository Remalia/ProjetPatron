package ProjetPatron.src.controller.State;

/***
 * Etat d'ajout de cercle
 */

public class StateAjoutCircle implements State {

    private static StateAjoutCircle instance;

    private StateAjoutCircle(){

    }


    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutCircle();
        }
        return instance;
    }


    @Override
    public void hasClicked() {
        System.out.print("test");
    }
}