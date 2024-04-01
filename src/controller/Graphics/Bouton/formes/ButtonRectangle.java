package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutRectangle;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les rectangles
 */
public class ButtonRectangle extends ButtonFormes{

    /***
     * Constructeur des actions du bouton rectangle sans image
     * @param name : nom du bouton
     */
    public ButtonRectangle(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutRectangle.getInstance());
        });
    }


    /***
     * Constructeur des actions du bouton rectangle avec image
     * @param name : nom du bouton
     * @param imgPath : chemin de l'image
     */
    public ButtonRectangle(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutRectangle.getInstance());
        });
    }
}
