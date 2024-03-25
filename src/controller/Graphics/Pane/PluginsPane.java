package ProjetPatron.src.controller.Graphics.Pane;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class PluginsPane extends JPanel {

    private static PluginsPane instance;


    private PluginsPane(){
        this.setName("PluginsAddons");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //TODO Ajouter plugins aucune idée la
    }

    public static PluginsPane getInstance(){
        if(instance == null){
            instance = new PluginsPane();
        }
        return instance;
    }

}
