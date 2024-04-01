package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.State.StateSelect;
import ProjetPatron.src.model.Action.SaveLevel;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuParametre;
import ProjetPatron.src.vue.Menu.NavBarJeu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
public class ButtonReset extends Button implements MouseListener {

    public ButtonReset(String name, String imgPath) {
        super(name, imgPath);
        this.addMouseListener(this);
        this.addActionListener(e -> {
            try {
                SaveLevel.resetAll();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonReset(String name){
        super(name);
        this.addActionListener(e -> {
            try {
                SaveLevel.resetAll();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /***
     * Méthode de gestion de l'événement de pression
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /***
     * Méthode de gestion de l'événement de relâchement
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /***
     * Méthode de gestion de l'événement de survol de zone
     */
    @Override
    public void mouseEntered(MouseEvent e) {
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal("assets/images/Menu/reset_hover.png")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }

    /***
     * Méthode de gestion de l'événement de sortie de zone
     */
    @Override
    public void mouseExited(MouseEvent e) {
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal("assets/images/Menu/reset.png")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }


}
