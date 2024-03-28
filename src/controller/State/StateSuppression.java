package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Action.Commandes.SuppresionForme;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void hasClicked(MouseEvent e){
    }

    @Override
    public void hasReleased(MouseEvent e) throws IOException {
        if(GamePane.getColorAt(GamePane.getInstance(), new Point(e.getX(), e.getY())).equals(Color.GREEN)){
            Forme formeAdelete = null;
            for (Forme f:MainModel.getInstance().getFormes()){
                if(f.getFv().isInForme(new Coord(e.getX(),e.getY()))){
                    formeAdelete = f;
                }
            }
            MainModel.getInstance().getCh().addCommand(new SuppresionForme(formeAdelete));
        }
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