package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.model.Param;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/***
 * classe permettant de gérer la ComboBox des thèmes
 
 */
public class ComboBoxTheme extends JComboBox<String> {

    private static ComboBoxTheme instance;

    /***
     * Constructeur de la classe,
     * Ajoute les différents thèmes possibles (noir, blanc) pour l'interface
     */
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
                Param.saveParam();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Permet de savoir si une action a été effectuée
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    /***
     * Permet de récupérer l'instance de la classe
     * @return : instance de la classe
     */
    public static ComboBoxTheme getInstance(){
        if(instance == null){
            instance = new ComboBoxTheme();
        }
        return instance;
    }
}
