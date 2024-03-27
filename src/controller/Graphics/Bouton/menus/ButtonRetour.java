package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.MainVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/***
 * Classe de gestion du bouton de retour pour le menu
 */
public class ButtonRetour extends Button implements MouseListener {

    public ButtonRetour(String name,String imgPath) {
        super(name,imgPath);
        this.addMouseListener(this);
        this.addActionListener(e -> {
            try {
                MainVue.backScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonRetour(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.backScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.getImgPath().contains("Menu"))
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgHoverPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.getImgPath().contains("Menu"))
            try {
                this.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeMenuPrincipal(this.getImgPath())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }
}

