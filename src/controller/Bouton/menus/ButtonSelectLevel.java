package ProjetPatron.src.controller.Bouton.menus;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton de sélection de niveau
 */
public class ButtonSelectLevel extends Button {

    public ButtonSelectLevel(String name,Image image) {
        super(name,image);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuJeu.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonSelectLevel(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuJeu.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
