package ProjetPatron.src.controller.Bouton.formes;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.controller.State.StateAjoutRectangle;
import ProjetPatron.src.controller.State.StateAjoutTriangle;

import java.awt.*;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les rectangles
 */
public class ButtonRectangle extends ButtonFormes{


    public ButtonRectangle(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateAjoutRectangle.getInstance()));
    }

    public ButtonRectangle(String name,Image image) {
        super(name,image);
        this.addActionListener(e -> getMc().setState(StateAjoutRectangle.getInstance()));
    }
}
