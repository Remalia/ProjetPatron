package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Action.Commandes.AjoutCercle;
import ProjetPatron.src.model.Action.Commandes.AjoutTriangle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

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
    public void hasPressed(MouseEvent e) throws IOException {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
        if(getPosClicks().size() == 3){
            MainModel.getInstance().getCh().addCommand(new AjoutTriangle(Color.GREEN,getPosClicks(),false));
            setPosClicks(new ArrayList<>());
        }
    }

    @Override
    public void hasEntered(MouseEvent e) {

    }

    @Override
    public void hasExited(MouseEvent e) {

    }
}