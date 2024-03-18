package ProjetPatron.src.controller.Graphics.Bouton;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

/***
 * Interface global pour les boutons
 */
public abstract class Button extends JButton {

    private String name;
    private String imgPath;
    private Boolean selected;
    private MainController mc;

    public Button(String name,String imgPath){
        this.imgPath = imgPath;
        this.selected = false;
        this.name = name;
        this.mc = MainController.getInstance();
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setIcon(new ImageIcon());
    }

    public Button(String name){
        this.selected = false;
        this.name = name;
        this.mc = MainController.getInstance();
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setText(name);
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isSelected(){
        return selected;
    }

    public MainController getMc() {
        return mc;
    }

}
