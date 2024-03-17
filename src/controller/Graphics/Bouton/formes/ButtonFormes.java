package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.Graphics.Bouton.Button;

import java.awt.*;

/***
 * Interface pour tous les boutons créant des formes
 */
public abstract class ButtonFormes extends Button {

    public ButtonFormes(String name) {
        super(name);
    }

    public ButtonFormes(String name,String imgPath){
        super(name,imgPath);
    }

}
