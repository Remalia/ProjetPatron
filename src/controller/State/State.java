package ProjetPatron.src.controller.State;


import java.awt.event.MouseEvent;
import java.io.IOException;

/***
 * Interface gérant les états
 */
public interface State {

    /***
     * Méthode qui gère le clic de la souris
     */
    void hasClicked(MouseEvent e) throws IOException;

    /***
     * Méthode qui gère le relâchement de la souris
     */
    void hasReleased(MouseEvent e) throws IOException;

    /***
     * Méthode qui gère l'appui de la souris
     */
    void hasPressed(MouseEvent e) throws IOException;

    /***
     * Méthode qui gère l'entrée de la souris
     */
    void hasEntered(MouseEvent e);

    /***
     * Méthode qui gère la sortie de la souris
     */
    void hasExited(MouseEvent e);
}
