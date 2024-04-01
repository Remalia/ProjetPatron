package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Box.CheckBoxFullScreen;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxTheme;
import ProjetPatron.src.vue.Layout.LayoutMenuParametre;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser le menu des paramètres
 *
 */
public class MenuParametre extends MenuAbstract{

    private static MenuParametre instance;

    /***
     * Constructeur du menu des paramètres
     * 
     */
    private MenuParametre() throws IOException {
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

    /***
     * Permet de changer le background du menu
     * @param color La couleur du background
     */
    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c : this.getComponents())
            switch (c.getName()){
                case "LabelTheme", "cbFullScreen", "LabelResolution": c.setForeground(ThemeView.getInstance().getOppositeColor()); c.setBackground(color); break;
            }
    }

    /***
     * Permet de retourner l'instance unique du menu des paramètres
     * @return l'instance en question
     */
    public static MenuParametre getInstance() throws IOException {
        if(instance == null){
            instance = new MenuParametre();
        }
        return instance;
    }

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "Paramètre";
    }
}
