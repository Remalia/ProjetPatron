package ProjetPatron.src.controller.Graphics.Box;

import javax.swing.*;

public class ComboBoxTheme extends JComboBox<String> {

    private static ComboBoxTheme instance;

    private ComboBoxTheme(){
        String[] themes = {"White","Black"};
        this.setName("cbTheme");
        for (String theme: themes)
            this.addItem(theme);
    }

    public static ComboBoxTheme getInstance(){
        if(instance == null){
            instance = new ComboBoxTheme();
        }
        return instance;
    }
}
