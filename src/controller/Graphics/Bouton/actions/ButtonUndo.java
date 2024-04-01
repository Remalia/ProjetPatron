package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton undo
 */
public class ButtonUndo extends Button {

    /***
     * Constructeur du bouton undo avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     */
    public ButtonUndo(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().getCh().undo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Constructeur du bouton undo sans image
     * @param name : le nom du bouton
     */
    public ButtonUndo(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().getCh().undo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
