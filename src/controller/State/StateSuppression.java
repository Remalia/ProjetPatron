package ProjetPatron.src.controller.State;

import java.awt.event.MouseEvent;

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
    public void hasClicked(MouseEvent e) {

    }

    @Override
    public void hasReleased(MouseEvent e) {

    }

    @Override
    public void hasPressed(MouseEvent e) {

    }

    @Override
    public void hasEntered(MouseEvent e) {

    }

    @Override
    public void hasExited(MouseEvent e) {

    }
}