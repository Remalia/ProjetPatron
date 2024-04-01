package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Action.Commandes.AjoutRectangle;
import ProjetPatron.src.model.Action.Commandes.DeplacementForme;
import ProjetPatron.src.model.Action.Commandes.SuppresionForme;
import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

/***
 * Etat de sélection
 */

public class StateSelect implements State {

    private static StateSelect instance;
    private Forme formeADeplacer;
    private Point debut;

    /***
     * Constructeur de la classe
     */
    private StateSelect(){

    }

    /***
     * Méthode qui retourne l'instance de la classe
     * @return instance
     */
    public static State getInstance(){
        if (instance == null){
            instance = new StateSelect();
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
    public void hasReleased(MouseEvent e) throws IOException {
        if(this.formeADeplacer != null){
            MainModel.getInstance().getCh().addCommand(new DeplacementForme(this.formeADeplacer, e.getX() - (int)debut.getX() , e.getY() - (int)debut.getY()));
            this.formeADeplacer = null;
        }
    }

    /***
     * Méthode qui gère l'appui sur la souris
     * @param e MouseEvent
     */
    @Override
    public void hasPressed(MouseEvent e) {
        if(GamePane.getColorAt(GamePane.getInstance(), new Point(e.getX(), e.getY())).equals(Color.GREEN)){
            for (Forme f:MainModel.getInstance().getFormes()){
                if(f.getFv().isInForme(new Coord(e.getX(),e.getY()))){
                    this.formeADeplacer = f;
                    this.debut = new Point(e.getX(), e.getY());
                }
            }

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