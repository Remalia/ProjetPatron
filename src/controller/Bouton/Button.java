package ProjetPatron.src.controller.Bouton;

import javax.swing.*;
import java.awt.*;

/***
 * Interface global pour les boutons
 */
public abstract class Button extends JButton {

    private String name;
    private Boolean selected;
    private Image image;

    public Button(Image image){
        this.selected = false;
        this.image = image;
        initImage();
    }

    public Button(String name){
        this.selected = false;
        this.name = name;
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

}
