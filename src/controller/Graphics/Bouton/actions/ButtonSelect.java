package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSelect;
import ProjetPatron.src.controller.State.StateSuppression;

/***
 * Classe de gestion du bouton select
 */
public class ButtonSelect extends Button {

    /***
     * Constructeur du bouton select avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     */
    public ButtonSelect(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> getMc().setState(StateSelect.getInstance()));
    }

    /***
     * Constructeur du bouton select sans image
     * @param name : le nom du bouton
     */
    public ButtonSelect(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSelect.getInstance()));
    }
}
