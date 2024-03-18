package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
            try {
                ThemeView.getInstance().swapColorTo(item);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    public static ComboBoxTheme getInstance(){
        if(instance == null){
            instance = new ComboBoxTheme();
        }
        return instance;
    }
}
