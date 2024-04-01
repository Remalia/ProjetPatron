package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateAjoutCircle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton redo
 */
public class ButtonRedo extends Button {

    /***
     * Constructeur du bouton redo avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     */
    public ButtonRedo(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().getCh().redo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Constructeur du bouton redo sans image
     * @param name : le nom du bouton
     */
    public ButtonRedo(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().getCh().redo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
