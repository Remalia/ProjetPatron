package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSelect;
import ProjetPatron.src.controller.State.StateSuppression;

public class ButtonSelect extends Button {

    public ButtonSelect(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> getMc().setState(StateSelect.getInstance()));
    }

    public ButtonSelect(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSelect.getInstance()));
    }
}
