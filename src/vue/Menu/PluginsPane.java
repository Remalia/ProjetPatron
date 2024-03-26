package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PluginsPane extends MenuAbstract {

    private static PluginsPane instance;


    @Override
    public String getNameFrame() {
        return "PluginsFrame";
    }

    private PluginsPane(){
        this.setName("PluginsAddons");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //TODO Ajouter plugins aucune idée la
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {

    }

    public static PluginsPane getInstance(){
        if(instance == null){
            instance = new PluginsPane();
        }
        return instance;
    }

}
