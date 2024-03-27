package ProjetPatron.src.controller.State;

import java.awt.event.MouseEvent;

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