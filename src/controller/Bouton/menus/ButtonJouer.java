package ProjetPatron.src.controller.Bouton.menus;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.controller.State.StateAjoutTriangle;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuSelectionNiveau;

import java.awt.*;
import java.io.IOException;

public class ButtonJouer extends Button {


    public ButtonJouer(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonJouer(String name,Image image){
        super(name,image);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
