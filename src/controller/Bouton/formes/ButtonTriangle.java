package ProjetPatron.src.controller.Bouton.formes;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.controller.State.StateAjoutRectangle;
import ProjetPatron.src.controller.State.StateAjoutTriangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les triangles
 */
public class ButtonTriangle extends ButtonFormes{


    public ButtonTriangle(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateAjoutTriangle.getInstance()));
    }

    public ButtonTriangle(Image image) {
        super(image);
        this.addActionListener(e -> getMc().setState(StateAjoutTriangle.getInstance()));
    }
}
