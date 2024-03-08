package ProjetPatron.src.controller.State;
/***
 * Etat d'ajout de suppression
 */

public class StateSuppression implements State {

    private static StateSuppression instance;

    private StateSuppression(){

    }


    public static State getInstance(){
        if (instance == null){
            instance = new StateSuppression();
        }
        return instance;
    }

    @Override
    public void hasClicked() {

    }
}