package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutRectangle;

import java.awt.*;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les rectangles
 */
public class ButtonRectangle extends ButtonFormes{


    public ButtonRectangle(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateAjoutRectangle.getInstance()));
    }

    public ButtonRectangle(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> getMc().setState(StateAjoutRectangle.getInstance()));
    }
}
