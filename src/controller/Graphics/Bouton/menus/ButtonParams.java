package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuParametre;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/***
 * Classe de gestion du bouton de contrôles
 */
public class ButtonParams extends Button implements MouseListener {

    public ButtonParams(String name,String imgPath) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuParametre.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonParams(String name) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuParametre.getInstance());
            } catch (IOException | InterruptedException ex) {
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
