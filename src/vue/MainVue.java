package ProjetPatron.src.vue;

import ProjetPatron.src.vue.Layout.LayoutMenuGlobal;
import ProjetPatron.src.vue.Menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private static JPanel pane;
    private static JPanel backupPanel;
    private static MainVue instance;

    private MainVue() throws IOException {
        backupPanel = new JPanel();
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

    public static void changeScene(MenuAbstract menu) throws IOException, InterruptedException {
        MenuAbstract navBarNeeded;
        if(menu == MenuJeu.getInstance()){
            navBarNeeded = NavBarJeu.getInstance();
        }else{
            navBarNeeded = NavBar.getInstance();
        }
        backupPanel.removeAll();
        for (Component comp: pane.getComponents()){
            backupPanel.add(comp);
        }
        pane.removeAll();
        pane.add(navBarNeeded);
        pane.add(menu);
        instance.repaint();
    }

    public static void backScene() throws IOException {
        if(backupPanel.getComponents().length == 0){
            System.out.println("Closing game");
            instance.dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
        }else{
            pane.removeAll();
            pane.add(NavBar.getInstance());
            for(Component comp: backupPanel.getComponents()){
                pane.add(comp);
            }
            instance.repaint();
        }
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
