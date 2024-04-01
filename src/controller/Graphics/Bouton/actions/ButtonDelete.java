package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.io.IOException;

/***
 * Classe de gestion du bouton delete
 */
public class ButtonDelete extends Button {

    /***
     * Constructeur du bouton delete avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     */
    public ButtonDelete(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateSuppression.getInstance());
        });
    }

    /***
     * Constructeur du bouton delete sans image
     * @param name : le nom du bouton
     */
    public ButtonDelete(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSuppression.getInstance()));
    }
}
