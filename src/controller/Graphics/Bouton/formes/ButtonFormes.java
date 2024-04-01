package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.Graphics.Bouton.Button;

import java.awt.*;

/***
 * Interface pour tous les boutons créant des formes
 */
public abstract class ButtonFormes extends Button {

    /***
     * Constructeur des actions des boutons sans image
     * @param name : nom du bouton
     */
    public ButtonFormes(String name) {
        super(name);
    }

    /***
     * Constructeur des actions des boutons avec image
     * @param name : nom du bouton
     * @param imgPath : chemin de l'image
     */
    public ButtonFormes(String name,String imgPath){
        super(name,imgPath);
    }

}
