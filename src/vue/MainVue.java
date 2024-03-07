package ProjetPatron.src.vue;

import ProjetPatron.src.vue.Menu.MenuAbstract;
import ProjetPatron.src.vue.Menu.MenuJeu;
import ProjetPatron.src.vue.Menu.MenuPrincipal;

import javax.swing.*;
import java.awt.*;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JPanel {

    private JFrame base;
    private MenuAbstract menu;

    public MainVue(){
        this.base = new JFrame();
        this.base.setSize(800,600);
        this.base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.base.setTitle("ProjetPatron");
        this.base.setResizable(false);
        this.base.setLocationRelativeTo(null);
        this.base.setContentPane(new MenuPrincipal(this));
        this.base.setVisible(true);
    }

    public void setMenu(MenuAbstract menu) {
        this.menu = menu;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public JFrame getBase() {
        return base;
    }

    public void setBase(JFrame base) {
        this.base = base;
    }
}
