package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Pane.ErrorPane;
import ProjetPatron.src.controller.Graphics.Pane.HistoryPane;
import ProjetPatron.src.controller.Graphics.Pane.PluginsPane;
import ProjetPatron.src.model.MainModel;
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
        this.add(HistoryPane.getInstance());
        this.add(PluginsPane.getInstance());
        this.add(ErrorPane.getInstance());
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
