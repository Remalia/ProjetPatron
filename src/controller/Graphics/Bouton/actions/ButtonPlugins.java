package ProjetPatron.src.controller.Graphics.Bouton.actions;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.Menu.ErrorPane;

public class ButtonPlugins extends Button {

    public ButtonPlugins(String name, String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> ErrorPane.getInstance().setErrorText("Cette fonctionnalité n'est pas encore terminé !"));
    }

    public ButtonPlugins(String name) {
        super(name);
        this.addActionListener(e -> ErrorPane.getInstance().setErrorText("Cette fonctionnalité n'est pas encore terminé !"));
    }
}
