package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutCircle;
import ProjetPatron.src.controller.State.StateAjoutTriangle;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les triangles
 */
public class ButtonTriangle extends ButtonFormes{


    /***
     * Constructeur des actions du bouton triangle sans image
     * @param name : nom du bouton
     */
    public ButtonTriangle(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutTriangle.getInstance());
        });
    }

    /***
     * Constructeur des actions du bouton triangle avec image
     * @param name : nom du bouton
     * @param imgPath : chemin de l'image
     */
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
