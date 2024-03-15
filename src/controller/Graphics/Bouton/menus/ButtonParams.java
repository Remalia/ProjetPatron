package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuParametre;

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
