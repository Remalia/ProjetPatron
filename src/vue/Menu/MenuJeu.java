package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.actions.ButtonRedo;
import ProjetPatron.src.vue.Layout.LayoutMenuJeu;

import javax.swing.*;
import java.awt.*;

public class MenuJeu extends MenuAbstract {

    private static MenuJeu instance;

    private MenuJeu(){
        super();
        this.setName("MenuJeu");
        this.setLayout(new LayoutMenuJeu());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.buttons.add(new ButtonRedo("redo","assets/jeu/undo.png"));
        this.addAllButtons();
    }

    @Override
    public void reScaleAllComponentsImg() {

    }

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
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
