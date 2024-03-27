package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateAjoutCircle;
import ProjetPatron.src.model.MainModel;

import java.awt.*;

/***
 * Classe de gestion du bouton redo
 */
public class ButtonRedo extends Button {

    public ButtonRedo(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> MainModel.getInstance().getCh().redo());
    }

    public ButtonRedo(String name) {
        super(name);
        this.addActionListener(e -> MainModel.getInstance().getCh().redo());
    }
}
