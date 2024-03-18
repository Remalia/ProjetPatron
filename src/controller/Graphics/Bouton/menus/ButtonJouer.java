package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
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

    //TODO FAIRE EN SORTE QUE QUAND ON PASSE SUR LE BUTTON IL S'ECLAIRCIT --> Pareil pour params et retours

    public ButtonJouer(String name,String imgPath){
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
