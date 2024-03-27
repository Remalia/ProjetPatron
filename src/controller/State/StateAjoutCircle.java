package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Action.Commandes.AjoutCercle;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

/***
 * Etat d'ajout de cercle
 */

public class StateAjoutCircle extends StateAjoutForme{

    private static StateAjoutCircle instance;

    private StateAjoutCircle(){
        super();
    }


    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutCircle();
        }
        return instance;
    }


    @Override
    public void hasClicked(MouseEvent e) {

    }

    @Override
    public void hasReleased(MouseEvent e) throws IOException {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
        MainModel.getInstance().getCh().addCommand(new AjoutCercle(Color.GREEN,getPosClicks(),false));
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