package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonSelectLevel;
import ProjetPatron.src.vue.Layout.LayoutSelectionNiveau;

import javax.swing.*;
import java.awt.*;

public class MenuSelectionNiveau extends MenuAbstract{

    private static MenuSelectionNiveau instance;

    private MenuSelectionNiveau(){
        this.setName("MenuSelectionNiveau");
        this.setLayout(new LayoutSelectionNiveau());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(new ButtonSelectLevel("1"));
    }

    public static MenuSelectionNiveau getInstance(){
        if(instance == null){
            instance = new MenuSelectionNiveau();
        }
        return instance;
    }

}
