package ProjetPatron.src.controller.State;
/***
 * Etat de sélection
 */

public class StateSelect implements State {

    private static StateSelect instance;

    private StateSelect(){

    }


    public static State getInstance(){
        if (instance == null){
            instance = new StateSelect();
        }
        return instance;
    }

    @Override
    public void hasClicked() {

    }
}