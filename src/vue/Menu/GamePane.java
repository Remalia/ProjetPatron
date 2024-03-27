package ProjetPatron.src.vue.Menu;

import javax.swing.*;
import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.vue.ThemeView;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class GamePane extends MenuAbstract implements MouseListener {

    public static GamePane instance;
    private MainController mc;

    @Override
    public String getNameFrame() {
        return "GamePane";
    }

    public GamePane() {
        this.mc = MainController.getInstance();
        addMouseListener(this);
        this.setName("Game");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {

    }

    public static GamePane getInstance() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
    }

}