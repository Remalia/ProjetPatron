package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.Layout.LayoutMenuJeu;

import javax.swing.*;
import java.awt.*;

public class MenuJeu extends MenuAbstract {

    private static MenuJeu instance;

    private MenuJeu(){
        this.setName("MenuJeu");
        this.setLayout(new LayoutMenuJeu());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public static MenuJeu getInstance(){
        if(instance == null){
            instance = new MenuJeu();
        }
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Jeu";
    }
}
