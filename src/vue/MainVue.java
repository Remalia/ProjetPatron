package ProjetPatron.src.vue;

import ProjetPatron.src.vue.Layout.LayoutMenuGlobal;
import ProjetPatron.src.vue.Menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private static final Stack<String> lastTitleNames = new Stack<>();;
    private static final Stack<Container> backupPanel = new Stack<>();;
    private static MainVue instance;

    private MainVue() throws IOException {
        this.getContentPane().setLayout(new LayoutMenuGlobal());
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Principal");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(NavBar.getInstance());
        this.getContentPane().add(MenuPrincipal.getInstance());
        this.setVisible(true);
    }

    public static void changeScene(MenuAbstract menu) throws IOException, InterruptedException {
        lastTitleNames.push(instance.getTitle());
        MenuAbstract navBarNeeded;
        if(menu == MenuJeu.getInstance()){
            navBarNeeded = NavBarJeu.getInstance();
        }else{
            navBarNeeded = NavBar.getInstance();
        }
        Container oldPanel = new Container();
        for(Component comp: instance.getContentPane().getComponents()){
            oldPanel.add(comp);
        }
        backupPanel.push(oldPanel);
        instance.getContentPane().removeAll();
        instance.getContentPane().add(navBarNeeded);
        instance.getContentPane().add(menu);
        instance.setTitle(menu.getNameFrame());
        instance.repaint();
        instance.setVisible(true);
    }

    public static Dimension getResolution(){
        return new Dimension(instance.getWidth(),instance.getHeight());
    }

    public static void backScene() throws IOException {
        if(lastTitleNames.empty()) {
            System.out.println("Closing game");
            instance.dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
        }else{
            String title = lastTitleNames.pop();
            instance.setTitle(title);
            Container oldPanel = new Container();
            for (Component comp : backupPanel.pop().getComponents()){
                oldPanel.add(comp);
            }
            instance.getContentPane().removeAll();
            if(Objects.equals(title, "Menu Principal"))
                instance.getContentPane().add(NavBar.getInstance());
            for (Component comp : oldPanel.getComponents()){
                instance.getContentPane().add(comp);
            }
            instance.repaint();
            instance.setVisible(true);
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
