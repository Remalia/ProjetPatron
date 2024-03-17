package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Box.CheckBoxFullScreen;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxTheme;
import ProjetPatron.src.vue.Layout.LayoutMenuParametre;

import javax.swing.*;

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
