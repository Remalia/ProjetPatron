package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.model.MainModel;

import java.awt.*;

/***
 * Classe de gestion du bouton undo
 */
public class ButtonUndo extends Button {

    public ButtonUndo(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> MainModel.getInstance().getCh().undo());
    }

    public ButtonUndo(String name) {
        super(name);
        this.addActionListener(e -> MainModel.getInstance().getCh().undo());
    }
}
