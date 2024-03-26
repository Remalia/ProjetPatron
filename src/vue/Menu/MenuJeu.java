package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.GamePane;
import ProjetPatron.src.vue.Layout.LayoutMenuJeu;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuJeu extends MenuAbstract {

    private static MenuJeu instance;

    private MenuJeu() throws IOException {
        super();
        this.setName("MenuJeu");
        this.setLayout(new LayoutMenuJeu());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(HistoryPane.getInstance());
        this.add(PluginsPane.getInstance());
        this.add(ErrorPane.getInstance());
        //this.add(GamePane.getInstance());
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Component comp: this.getComponents()){
            comp.setBackground(ThemeView.getInstance().getColor());
            MenuAbstract menuAbstract = (MenuAbstract) comp;
            menuAbstract.reScaleAllComponentsImg();
        }
    }

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
    }

    public static MenuJeu getInstance() throws IOException {
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
