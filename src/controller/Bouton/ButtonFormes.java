package ProjetPatron.src.controller.Bouton;

import javax.swing.*;
import java.awt.*;

/***
 * Interface pour tous les boutons créant des formes
 */
public abstract class ButtonFormes extends Button{

    public ButtonFormes(String name) {
        super(name);
    }

    public ButtonFormes(Image image){
        super(image);
    }

    public void makeForme() { //TODO ptet pas bon car ptet pas void mais prévisionel

    }
}
