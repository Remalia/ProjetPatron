package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSelect;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.io.IOException;

public class ButtonSelect extends Button {

    public ButtonSelect(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateSelect.getInstance());
        });
    }

    public ButtonSelect(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSelect.getInstance()));
    }
}
