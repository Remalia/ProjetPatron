package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Action.Commandes.AjoutCercle;
import ProjetPatron.src.model.Action.Commandes.AjoutRectangle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/***
 * Etat d'ajout de carré
 */

public class StateAjoutRectangle extends StateAjoutForme {

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
    public void hasClicked(MouseEvent e) {

    }

    @Override
    public void hasReleased(MouseEvent e) throws IOException {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
        MainModel.getInstance().getCh().addCommand(new AjoutRectangle(Color.GREEN,getPosClicks(),false));
        setPosClicks(new ArrayList<>());
    }

    @Override
    public void hasPressed(MouseEvent e) {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
    }

    @Override
    public void hasEntered(MouseEvent e) {

    }

    @Override
    public void hasExited(MouseEvent e) {

    }
}