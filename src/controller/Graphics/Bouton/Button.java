package ProjetPatron.src.controller.Graphics.Bouton;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

/***
 * Interface global pour les boutons
 */
public abstract class Button extends JButton {

    private String imgPath;
    private String imgHoverPath;
    private Boolean selected;
    private MainController mc;

    public Button(String name,String imgPath){
        this.imgPath = imgPath;
        this.selected = false;
        this.imgHoverPath = imgPath.split(".png")[0]+"_hover.png";
        this.mc = MainController.getInstance();
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setIcon(new ImageIcon());
    }

    public Button(String name){
        this.mc = MainController.getInstance();
        this.selected = false;
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setText(name);
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getImgHoverPath(){
        return imgHoverPath;
    }

    public MainController getMc() {
        return mc;
    }

}
