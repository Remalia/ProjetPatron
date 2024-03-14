package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.Layout.LayoutMenuParametre;

import javax.swing.*;

public class MenuParametre extends MenuAbstract{

    private static MenuParametre instance;

    private MenuParametre(){
        this.setName("Paramètre");
        this.setLayout(new LayoutMenuParametre());
        JLabel labelResolution = new JLabel("Resolution :");
        labelResolution.setName("LabelResolution");
        JLabel labelTheme = new JLabel("Theme :");
        labelTheme.setName("LabelTheme");
        JComboBox<JLabel> cbResolution = new JComboBox<>();
        JComboBox<JLabel> cbTheme = new JComboBox<>();
        cbResolution.setName("cbResolution");
        cbTheme.setName("cbTheme");
        //TODO instance de cbResolution a init
        this.add(labelResolution);
        this.add(labelTheme);
        this.add(cbTheme);
        this.add(cbResolution);
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
