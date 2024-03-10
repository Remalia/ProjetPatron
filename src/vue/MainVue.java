package ProjetPatron.src.vue;

import ProjetPatron.src.vue.Layout.LayoutMenuGlobal;
import ProjetPatron.src.vue.Menu.*;

import javax.swing.*;
import java.io.IOException;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private static JPanel pane;
    private static MainVue instance;

    private MainVue() throws IOException {
        pane = new JPanel();
        pane.setLayout(new LayoutMenuGlobal());
        this.setSize(800,600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ProjetPatron");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        pane.add(NavBar.getInstance());
        pane.add(MenuPrincipal.getInstance());
        this.setContentPane(pane);
        this.setVisible(true);
    }

    public static void changeScene(MenuAbstract menu){
        pane = new JPanel();
        pane.add(menu);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public static MainVue getInstance() throws IOException {
        if(instance == null){
            instance = new MainVue();
        }
        return instance;
    }
}
