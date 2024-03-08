package ProjetPatron.src.vue;

import ProjetPatron.src.vue.Menu.MenuAbstract;
import ProjetPatron.src.vue.Menu.MenuJeu;
import ProjetPatron.src.vue.Menu.MenuPrincipal;

import javax.swing.*;
import java.awt.*;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private JPanel butPanel;
    private JPanel pane;
    private MenuAbstract menu;

    public MainVue(){
        butPanel = new JPanel();
        pane = new JPanel();
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ProjetPatron");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        butPanel.setLayout(new BoxLayout(butPanel,BoxLayout.Y_AXIS));
        pane.add(butPanel);
        pane.add(new MenuPrincipal(this));
        this.setContentPane(pane);
        this.setVisible(true);
    }

    public JPanel getButPanel() {
        return butPanel;
    }

    public void setButPanel(JPanel butPanel) {
        this.butPanel = butPanel;
    }

    public void setMenu(MenuAbstract menu) {
        this.menu = menu;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public int getWidthScreen(){
        return this.getWidth();
    }

    public int getHeightScreen(){
        return this.getHeight();
    }
}
