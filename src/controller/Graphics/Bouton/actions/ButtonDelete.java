package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.io.IOException;

public class ButtonDelete extends Button {

    public ButtonDelete(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateSuppression.getInstance());
        });
    }

    public ButtonDelete(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateSuppression.getInstance()));
    }
}
