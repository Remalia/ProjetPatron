package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutTriangle;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les triangles
 */
public class ButtonTriangle extends ButtonFormes{


    public ButtonTriangle(String name) {
        super(name);
        this.addActionListener(e -> getMc().setState(StateAjoutTriangle.getInstance()));
    }

    public ButtonTriangle(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutTriangle.getInstance());
        });
    }
}
