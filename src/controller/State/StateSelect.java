package ProjetPatron.src.controller.State;

import java.awt.event.MouseEvent;

/***
 * Etat de sélection
 */

public class StateSelect implements State {

    private static StateSelect instance;

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
    public void hasReleased(MouseEvent e) {

    }

    /***
     * Méthode qui gère l'appui sur la souris
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