package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Box.CheckBoxFullScreen;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxTheme;
import ProjetPatron.src.vue.Layout.LayoutMenuParametre;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class MenuParametre extends MenuAbstract{

    private static MenuParametre instance;

    private MenuParametre(){
        super();
        this.setName("Paramètre");
        this.setLayout(new LayoutMenuParametre());
        JLabel labelResolution = new JLabel("Resolution :");
        labelResolution.setName("LabelResolution");
        JLabel labelTheme = new JLabel("Theme :");
        labelTheme.setName("LabelTheme");
        JCheckBox checkBoxFullscreen = CheckBoxFullScreen.getInstance();
        JComboBox<String> cbResolution = ComboBoxResolution.getInstance();
        JComboBox<String> cbTheme = ComboBoxTheme.getInstance();
        this.add(checkBoxFullscreen);
        this.add(labelResolution);
        this.add(labelTheme);
        this.add(cbTheme);
        this.add(cbResolution);
    }

    @Override
    public void reScaleAllComponentsImg() {

    }

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c : this.getComponents())
            switch (c.getName()){
                case "LabelTheme","LabelResolution","cbFullScreen": c.setForeground(ThemeView.getInstance().getOppositeColor()); c.setBackground(color); break;
            }
    }

    public static MenuParametre getInstance(){
        if(instance == null){
            instance = new MenuParametre();
        }
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Paramètre";
    }
}
