package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSuppression;

public class ButtonDelete extends Button {

    public ButtonDelete(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> getMc().setState(StateSuppression.getInstance()));
    }

    public ButtonDelete(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSuppression.getInstance()));
    }
}
