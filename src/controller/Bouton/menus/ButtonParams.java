package ProjetPatron.src.controller.Bouton.menus;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuParametre;
import ProjetPatron.src.vue.Menu.MenuSelectionNiveau;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton de contrôles
 */
public class ButtonParams extends Button {

    public ButtonParams(String name,Image image) {
        super(name,image);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuParametre.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonParams(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuParametre.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
