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

    /***
     * constructeur de la classe
     */
    private StateAjoutTriangle(){

    }

    /***
     * Méthode qui retourne l'instance de la classe
     * @return instance
     */
    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutTriangle();
        }
        return instance;
    }

    /***
     * Méthode qui gère le clic de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasClicked(MouseEvent e) {
    }

    /***
     * Méthode qui gère le relâchement de la souris
     * @param e MouseEvent
     */
    @Override
    public void hasReleased(MouseEvent e) {

    }

    /***
     * Méthode qui gère l'appui sur la souris,
     * Pour la création d'un triangle (point par point)
     * @param e MouseEvent
     * @throws IOException Exception par rapport à l'instance
     */
    @Override
    public void hasPressed(MouseEvent e) throws IOException {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
        if(getPosClicks().size() == 3){
            MainModel.getInstance().getCh().addCommand(new AjoutTriangle(Color.GREEN,getPosClicks(),false));
            setPosClicks(new ArrayList<>());
        }
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