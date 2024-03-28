package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.Formes.CercleVue;
import ProjetPatron.src.vue.Formes.FormeVue;
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
        this.addMouseListener(this);
        this.setLayout(null);
        this.setName("Game");
        this.setBackground(ThemeView.getInstance().getColor());
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
    }

    @Override
    protected void paintComponent(Graphics g) {
        FormeVue fv;
        for (Forme f: MainModel.getInstance().getFormes()){
            fv = f.createForme();
            fv.drawForme(g);
        }
    }

    public static GamePane getInstance() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mc.getState().hasClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            mc.getState().hasPressed(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            mc.getState().hasReleased(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mc.getState().hasEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mc.getState().hasExited(e);
    }

}