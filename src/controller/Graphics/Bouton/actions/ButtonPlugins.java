package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.Menu.ErrorPane;

/***
 * Classe de gestion du bouton plugins
 */
public class ButtonPlugins extends Button {

    /***
     * Constructeur du bouton plugins avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     */
    public ButtonPlugins(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> ErrorPane.getInstance().setErrorText("Cette fonctionnalité n'est pas encore terminé !"));
    }

    /***
     * Constructeur du bouton plugins sans image
     * @param name : le nom du bouton
     */
    public ButtonPlugins(String name) {
        super(name);
        this.addActionListener(e -> ErrorPane.getInstance().setErrorText("Cette fonctionnalité n'est pas encore terminé !"));
    }
}
