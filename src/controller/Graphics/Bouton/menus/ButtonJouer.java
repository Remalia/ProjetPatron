package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuSelectionNiveau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/***
 * Classe de gestion du bouton de jouer
 */
public class ButtonJouer extends Button implements MouseListener {

    /***
     * Constructeur du bouton de jouer sans image
     * @param name nom du bouton
     */
    public ButtonJouer(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Constructeur du bouton de jouer avec image
     * @param name nom du bouton
     * @param imgPath chemin de l'image
     */
    public ButtonJouer(String name, String imgPath) {
        super(name, imgPath);
        this.addMouseListener(this);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Méthode de gestion de l'événement de clic
     */
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
     * Méthode de gestion de l'événement de survol
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.getImgPath() != null)
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgHoverPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }

    /***
     * Méthode de gestion de l'événement de sortie de zone
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (this.getImgPath() != null)
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }
}
