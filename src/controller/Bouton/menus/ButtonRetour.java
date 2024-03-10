package ProjetPatron.src.controller.Bouton.menus;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.vue.MainVue;

import java.awt.*;
import java.io.IOException;

/***
 * Classe de gestion du bouton de retour pour le menu
 */
public class ButtonRetour extends Button {

    public ButtonRetour(String name,Image image) {
        super(name,image);
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
    }
}

