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

    private static JPanel pane;
    private MenuAbstract menu;
    private static MainVue instance;

    private MainVue(){
        pane = new JPanel();
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ProjetPatron");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        menu = new MenuPrincipal(this);
        pane.add(menu);
        this.setContentPane(pane);
        this.setVisible(true);
    }

    public static void changeScene(MenuAbstract menu){
        pane = new JPanel();
        pane.add(menu);
    }

    public static JPanel getPane(){
        return pane;
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

    public static MainVue getInstance(){
        if(instance == null){
            instance = new MainVue();
        }
        return instance;
    }
}
