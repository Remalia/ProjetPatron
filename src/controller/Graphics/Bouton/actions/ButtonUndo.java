package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.model.MainModel;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton undo
 */
public class ButtonUndo extends Button {

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
