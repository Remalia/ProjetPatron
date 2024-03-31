package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutRectangle;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les rectangles
 */
public class ButtonRectangle extends ButtonFormes{


    public ButtonRectangle(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutRectangle.getInstance());
        });
    }

    public ButtonRectangle(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutRectangle.getInstance());
        });
    }
}
