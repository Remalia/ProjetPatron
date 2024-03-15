package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutCircle;

import java.awt.*;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les cercles
 */
public class ButtonCercle extends ButtonFormes{


    public ButtonCercle(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateAjoutCircle.getInstance()));
    }

    public ButtonCercle(String name,Image image){
        super(name,image);
        this.addActionListener(e -> getMc().setState(StateAjoutCircle.getInstance()));
    }
}
