package ProjetPatron.src.controller.Graphics.Bouton.formes;

import ProjetPatron.src.controller.State.StateAjoutCircle;
import ProjetPatron.src.controller.State.StateSuppression;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import java.awt.*;
import java.io.IOException;

/***
 * Classe permettant la gestion des interactions utilisateurs pour les cercles
 */
public class ButtonCercle extends ButtonFormes{

    /***
     * Constructeur des actions du bouton cercle sans image
     * @param name : nom du bouton
     */
    public ButtonCercle(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutCircle.getInstance());
        });
    }

    /***
     * Constructeur des actions du bouton cercle avec image
     * @param name : nom du bouton
     * @param imgPath : chemin de l'image
     */
    public ButtonCercle(String name,String imgPath){
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                NavBarJeu.getInstance().newButtonSelected(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            getMc().setState(StateAjoutCircle.getInstance());
        });
    }
}
