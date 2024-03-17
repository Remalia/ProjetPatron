package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton de retour pour le menu
 */
public class ButtonRetour extends Button {

    public ButtonRetour(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainVue.backScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonRetour(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.backScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

