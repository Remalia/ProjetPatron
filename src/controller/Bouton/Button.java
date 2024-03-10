package ProjetPatron.src.controller.Bouton;

import ProjetPatron.src.controller.MainController;

import javax.swing.*;
import java.awt.*;

/***
 * Interface global pour les boutons
 */
public abstract class Button extends JButton {

    private String name;
    private Boolean selected;
    private Image image;
    private MainController mc;

    public Button(String name,Image image){
        this.selected = false;
        this.image = image;
        this.name = name;
        this.mc = MainController.getInstance();
        this.setName(name);
        this.setIcon(new ImageIcon(image));
    }

    public Button(String name){
        this.selected = false;
        this.name = name;
        this.mc = MainController.getInstance();
        this.setName(name);
        this.setText(name);
    }

    public boolean isSelected(){
        return selected;
    }

    public void select(){
        selected = !selected;
    }

    public MainController getMc() {
        return mc;
    }

}
