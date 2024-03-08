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

    public Button(Image image){
        this.selected = false;
        this.image = image;
        this.mc = MainController.getInstance();
        initImage();
    }

    public Button(String name){
        this.selected = false;
        this.name = name;
        this.mc = MainController.getInstance();
        initName();
    }

    private void initName() {
        this.setText(name);
    }

    private void initImage(){
        this.setIcon(new ImageIcon(image));
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
