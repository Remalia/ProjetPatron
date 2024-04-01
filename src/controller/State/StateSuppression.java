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

/***
 * Etat d'ajout de suppression
 */

public class StateSuppression implements State {

    private static StateSuppression instance;

    /***
     * Constructeur de la classe
     */
    private StateSuppression(){

    }

    /***
     * Méthode qui retourne l'instance de la classe
     * @return instance
     */
    public static State getInstance(){
        if (instance == null){
            instance = new StateSuppression();
        }
        return instance;
    }


    /***
     * Méthode qui gère le clic de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasClicked(MouseEvent e){
    }

    /***
     * Méthode qui gère le relâchement de la souris
     * @param e MouseEvent
     * @throws IOException Exception par rapport à l'instance
     */
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

    /***
     * Méthode qui gère l'appui de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasPressed(MouseEvent e) {

    }

    /***
     * Méthode qui gère l'entrée de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasEntered(MouseEvent e) {

    }

    /***
     * Méthode qui gère la sortie de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasExited(MouseEvent e) {

    }
}