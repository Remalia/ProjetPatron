package ProjetPatron.src.controller.Bouton.formes;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.controller.MainController;

import javax.swing.*;
import java.awt.*;

/***
 * Interface pour tous les boutons créant des formes
 */
public abstract class ButtonFormes extends Button {

    public ButtonFormes(String name) {
        super(name);
    }

    public ButtonFormes(String name,Image image){
        super(name,image);
    }

}
