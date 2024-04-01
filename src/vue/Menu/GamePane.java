package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


/***
 * Permet d'afficher le panel de jeu ou l'ont peut dessiner
 */
public class GamePane extends MenuAbstract implements MouseListener {

    public static GamePane instance;
    private MainController mc;

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "GamePane";
    }

    /***
     * Constructeur du panel de jeu
     */
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

    /***
     * Permet de dessiner les formes
     * @param g le graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        for (Forme f: MainModel.getInstance().getFormes()){
            f.createFormeVue().drawForme(g);
        }
    }

    /***
     * Permet de récupérer l'instance unique du panel de jeu
     * @return le panel de jeu
     */
    public static GamePane getInstance() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    /***
     * Permet detecter un click de souris
     * @param e l'event de la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            mc.getState().hasClicked(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /***
     * Permet de detecter une pression de souris
     * @param e l'event de la souris
     */
    @Override
    public void mousePressed(MouseEvent e) {
        try {
            mc.getState().hasPressed(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /***
     * Permet de detecter un relachement de souris
     * @param e l'event de la souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            mc.getState().hasReleased(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /***
     * Permet de detecter un survol de souris
     * @param e l'event de la souris
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        mc.getState().hasEntered(e);
    }

    /***
     * Permet de detecter une sortie de souris
     * @param e l'event de la souris
     */
    @Override
    public void mouseExited(MouseEvent e) {
        mc.getState().hasExited(e);
    }

    /***
     * Permet de récupérer la couleur d'un pixel
     * @param frm le panel
     * @param p le point
     * @return la couleur du pixel
     */
    public static Color getColorAt(JPanel frm, Point p) {
        Rectangle rect = frm.getBounds();
        BufferedImage img = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
        frm.paintAll(img.createGraphics());
        return new Color(img.getRGB(p.x, p.y), true);
    }

}