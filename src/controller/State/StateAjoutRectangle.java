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

    /***
     * Constructeur de la classe
     */
    private StateAjoutRectangle(){

    }

    /***
     * Méthode qui retourne l'instance de la classe
     * @return instance
     */
    public static State getInstance(){
        if (instance == null){
            instance = new StateAjoutRectangle();
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
     * Méthode qui gère le relâchement de la souris,
     * Pour la création d'un rectangle
     * @param e MouseEvent
     * @throws IOException Exception par rapport à l'instance
     */
    @Override
    public void hasReleased(MouseEvent e) throws IOException {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
        MainModel.getInstance().getCh().addCommand(new AjoutRectangle(Color.GREEN,getPosClicks(),false));
        setPosClicks(new ArrayList<>());
    }

    /***
     * Méthode qui gère l'appui sur la souris
     * @param e MouseEvent
     */
    @Override
    public void hasPressed(MouseEvent e) {
        getPosClicks().add(new Coord(e.getX(),e.getY()));
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