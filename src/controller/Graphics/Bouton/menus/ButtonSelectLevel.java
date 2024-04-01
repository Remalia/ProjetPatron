package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.Menu.HistoryPane;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuJeu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/***
 * Classe de gestion du bouton de sélection de niveau
 */
public class ButtonSelectLevel extends Button implements MouseListener {

    /***
     * Constructeur du bouton de sélection de niveau avec image
     * @param name : le nom du bouton
     * @param imgPath : le chemin de l'image
     * @param idMenu : l'id du menu
     */
    public ButtonSelectLevel(String name,String imgPath,int idMenu) {
        super(name,imgPath);
        this.addMouseListener(this);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().loadLevel(idMenu);
                HistoryPane.getInstance().reloadHistory();
                MainVue.changeScene(MenuJeu.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /***
     * Constructeur du bouton de sélection de niveau sans image
     * @param name : le nom du bouton
     * @param idMenu : l'id du menu
     */
    public ButtonSelectLevel(String name,int idMenu) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().loadLevel(idMenu);
                HistoryPane.getInstance().reloadHistory();
                MainVue.changeScene(MenuJeu.getInstance());
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
        if (!this.getImgPath().contains("jeu_libre"))
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeSelectionNiveau(this.getImgHoverPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        else{
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgHoverPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /***
     * Méthode de gestion de l'événement de sortie de zone
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (!this.getImgPath().contains("jeu_libre"))
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeSelectionNiveau(this.getImgPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        else{
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
