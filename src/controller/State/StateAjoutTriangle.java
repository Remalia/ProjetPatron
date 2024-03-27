package ProjetPatron.src.controller.State;

import java.awt.event.MouseEvent;

/***
 * Etat d'ajout de triangle
 */

public class StateAjoutTriangle extends StateAjoutForme {

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