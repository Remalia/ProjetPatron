package ProjetPatron.src.controller.Graphics;

import javax.swing.*;
import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.vue.Menu.ErrorPane;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class GamePane extends JPanel implements MouseListener {
    public static GamePane instance;
    private MainController mc;
    public GamePane(){
        this.mc = MainController.getInstance();
        addMouseListener(this);
    }

    public static GamePane getInstance(){
        if(instance == null){
            instance = new GamePane();
        }
        return instance;
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
       System.out.println("test");
    }
}
