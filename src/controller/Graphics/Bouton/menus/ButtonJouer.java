package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuSelectionNiveau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ButtonJouer extends Button implements MouseListener{


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

    public ButtonJouer(String name,String imgPath) {
        super(name, imgPath);
        this.addActionListener(e -> {
            try {
                MainVue.changeScene(MenuSelectionNiveau.getInstance());
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
        //this.setIcon(this.getImgPath());
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
