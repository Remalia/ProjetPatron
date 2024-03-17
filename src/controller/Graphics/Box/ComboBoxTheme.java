package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxTheme extends JComboBox<String> {

    private static ComboBoxTheme instance;

    private ComboBoxTheme(){
        String[] themes = {"White","Black"};
        this.setName("cbTheme");
        for (String theme: themes)
            this.addItem(theme);
        this.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String item = (String)cb.getSelectedItem();
            ThemeView.getInstance().swapColorTo(item);
        });
    }

    public static ComboBoxTheme getInstance(){
        if(instance == null){
            instance = new ComboBoxTheme();
        }
        return instance;
    }
}
