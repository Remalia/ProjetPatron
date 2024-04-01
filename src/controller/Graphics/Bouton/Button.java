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

    /***
     * Constructeur de la classe Button avec image
     * @param name : nom du bouton
     * @param imgPath : chemin de l'image du bouton
     */
    public Button(String name,String imgPath){
        this.imgPath = imgPath;
        this.selected = false;
        this.imgHoverPath = imgPath.split(".png")[0]+"_hover.png";
        this.mc = MainController.getInstance();
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setIcon(new ImageIcon(imgPath));
    }

    /***
     * Constructeur de la classe Button sans image
     * @param name : nom du bouton
     */
    public Button(String name){
        this.mc = MainController.getInstance();
        this.selected = false;
        this.setBorderPainted(false);
        this.setBackground(ThemeView.getInstance().getColor());
        this.setName(name);
        this.setText(name);
    }

    /*** 
     * Permet de savoir si le bouton est sélectionné ou non
     */
    public Boolean getSelected() {
        return selected;
    }

    /***
     * Permet de changer si le bouton est sélectionné ou non
     * @param selected True ou False suivant s'il est sélectionné ou non
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /***
     * Permet de récupérer le chemin de l'image du bouton
     * @return : chemin de l'image du bouton
     */
    public String getImgPath() {
        return imgPath;
    }

    /***
     * Permet de récupérer le chemin de l'image du bouton lorsqu'il est survolé
     * @return : chemin de l'image du bouton survolé
     */
    public String getImgHoverPath(){
        return imgHoverPath;
    }


    /***
     * Permet de récupérer le mainController
     * @return : mainController
     */
    public MainController getMc() {
        return mc;
    }

}
